import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

public class Duke {

    static int taskNum = 0;
    static Task[] tasks = new Task[100];
    /** main. */

    public static void main(String[] args) {
        //        String logo = " ____        _        \n"
        //                + "|  _ \\ _   _| | _____ \n"
        //                + "| | | | | | | |/ / _ \\\n"
        //                + "| |_| | |_| |   <  __/\n"
        //                + "|____/ \\__,_|_|\\_\\___|\n";
        //        System.out.println("Hello from\n" + logo);
        print("Hello! I'm Duke");
        print("What can I do for you?");
        Scanner input = new Scanner(System.in);

        while (true) {
            try {

                String userInput = input.nextLine();
                if (userInput.equals("bye")) {
                    break;
                } else if (userInput.equals("list")) {
                    if (taskNum == 0) {
                        throw new DukeException("There are no tasks.");
                    }
                    print("Here are the tasks in your list:");
                    for (int i = 0; i < taskNum; i++) {
                        print(Integer.toString(i + 1) + "." + tasks[i].getDescription());
                    }
                } else {
                    String[] inputSplit = userInput.split("\\s+");
                    if (inputSplit[0].equals("done")) {
                        String stringNumber = inputSplit[1];
                        Integer number = Integer.valueOf(stringNumber);
                        if (number > taskNum || number < 1) {
                            throw new DukeException("This task doesn't exist.");
                        }
                        tasks[number - 1].markAsDone();
                        print("Nice! I've marked this task as done:");
                        print("  " + tasks[number - 1].getDescription());
                    } else if (inputSplit[0].equals("todo")) {
                        if (inputSplit.length == 1) {
                            throw new DukeException("The description of a todo cannot be empty.");
                        }
                        String description = stringCompose(inputSplit, 1, inputSplit.length - 1);
                        tasks[taskNum] = new Todo(description);
                        printAddedClass();
                    } else if (inputSplit[0].equals("event")) {
                        int breakpoint = find(inputSplit, "/at");
                        if (breakpoint == -1) {
                            throw new DukeException("Wrong format: no /at when creating event task.");
                        }
                        String description = stringCompose(inputSplit, 1, breakpoint - 1);
                        String time = stringCompose(inputSplit, breakpoint + 1, inputSplit.length - 1);
                        tasks[taskNum] = new Event(description, time);
                        printAddedClass();
                    } else if (inputSplit[0].equals("deadline")) {
                        int breakpoint = find(inputSplit, "/by");
                        if (breakpoint == -1) {
                            throw new DukeException("Wrong format: no /by when creating deadline task.");
                        }
                        String description = stringCompose(inputSplit, 1, breakpoint - 1);
                        String time = stringCompose(inputSplit, breakpoint + 1, inputSplit.length - 1);
                        tasks[taskNum] = new Deadline(description, time);
                        printAddedClass();
                    } else if (inputSplit[0].equals("find")) {
                        Integer count = 0;
                        if (inputSplit.length != 2) {
                            throw new DukeException("Please search exactly one keyword.");
                        }
                        for (int i = 0; i < taskNum; i++) {
                            if (tasks[i].getDescription().contains(inputSplit[1])) {
                                count += 1;
                                if (count == 1) {
                                    print("Here are the matching tasks in your list:");
                                }
                                print(Integer.toString(count) + "." + tasks[i].getDescription());
                            }
                        }
                        if (count == 0) {
                            print("Sorry. No tasks are found.");
                        }
                    } else {
                        throw new DukeException("I'm sorry, but I don't know what that means :-(");
                    }
                    save();
                }
            } catch (DukeException e) {
                print(e.message);
            }
        }
        print("Bye. Hope to see you again soon!");
    }

    private static int find(String[] input,String key) {
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private static String stringCompose(String[] input,int start, int end) throws DukeException {
        if (start > end) {
            throw new DukeException("Time or description is missing.");
        }
        String s = input[start];
        for (int i = start + 1; i <= end; i++) {
            s += " " + input[i];
        }
        return s;
    }

    private static void save() {
        try {
            PrintWriter writer = new PrintWriter("./data/duke.txt");
            for (int i = 0; i < taskNum; i++) {
                String profile = tasks[i].getProfile();
                writer.println(profile);
            }
            writer.close();
        } catch (IOException e) {
            print("No such file.");
        }
    }

    private static void printAddedClass() {
        print("Got it. I've added this task:");
        print("  " + tasks[taskNum].getDescription());
        taskNum++;
        print("Now you have " + taskNum + " tasks in the list.");
    }

    private static void print(String input) {
        System.out.println("    " + input);
    }
}
