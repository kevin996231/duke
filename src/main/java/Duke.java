import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.util.ArrayList;


public class Duke {


    static ArrayList<Task> tasks = new ArrayList<>();
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
                    if (tasks.size() == 0) {
                        throw new DukeException("There are no tasks.");
                    }
                    print("Here are the tasks in your list:");
                    for (int i = 0; i < tasks.size(); i++) {
                        print(Integer.toString(i + 1) + "."
                                + tasks.get(i).getDescription());
                    }
                } else {
                    String[] inputSplit = userInput.split("\\s+");
                    if (inputSplit[0].equals("done") || inputSplit[0].equals("delete")) {
                        if (inputSplit.length != 2) {
                            throw new DukeException("Wrong format.");
                        }

                        String stringNumber = inputSplit[1];
                        Integer number;
                        try {
                            number = Integer.valueOf(stringNumber);
                        } catch (NumberFormatException e) {
                            throw new DukeException("Index of task must be an integer.");
                        }

                        if (number > tasks.size() || number < 1) {
                            throw new DukeException("This task doesn't exist.");
                        }
                        if (inputSplit[0].equals("done")) {
                            tasks.get(number - 1).markAsDone();
                            print("Nice! I've marked this task as done:");
                            print("  " + tasks.get(number - 1).getDescription());
                        } else {
                            print("Noted. I've removed this task:");
                            print("  " + tasks.get(number - 1).getDescription());
                            tasks.remove(tasks.get(number - 1));
                            print("Now you have " + tasks.size() + " tasks in the list.");
                        }
                    } else if (inputSplit[0].equals("todo")) {
                        if (inputSplit.length == 1) {
                            throw new DukeException("The description of a todo cannot be empty.");
                        }
                        String description = stringCompose(inputSplit, 1, inputSplit.length - 1);
                        tasks.add(new Todo(description));
                        printAddedClass();
                    } else if (inputSplit[0].equals("event")) {
                        int breakpoint = find(inputSplit, "/at");
                        if (breakpoint == -1) {
                            throw new DukeException("Wrong format: no /at when creating event task.");
                        }
                        String description = stringCompose(inputSplit, 1, breakpoint - 1);
                        String time = stringCompose(inputSplit, breakpoint + 1, inputSplit.length - 1);
                        tasks.add(new Event(description, time));
                        printAddedClass();
                    } else if (inputSplit[0].equals("deadline")) {
                        int breakpoint = find(inputSplit, "/by");
                        if (breakpoint == -1) {
                            throw new DukeException("Wrong format: no /by when creating deadline task.");
                        }
                        String description = stringCompose(inputSplit, 1, breakpoint - 1);
                        String time = stringCompose(inputSplit, breakpoint + 1, inputSplit.length - 1);
                        tasks.add(new Deadline(description, time));
                        printAddedClass();
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
            for (int i = 0; i < tasks.size(); i++) {
                String profile = tasks.get(i).getProfile();
                writer.println(profile);
            }
            writer.close();
        } catch (IOException e) {
            print("No such file.");
        }
    }

    private static void printAddedClass() {
        print("Got it. I've added this task:");
        print("  " + tasks.get(tasks.size() - 1).getDescription());
        print("Now you have " + tasks.size() + " tasks in the list.");
    }

    private static void print(String input) {
        System.out.println("    " + input);
    }

}
