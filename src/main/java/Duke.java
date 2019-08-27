import java.util.Scanner;

public class Duke {
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
        Task[] tasks = new Task[100];
        int taskNum = 0;
        while (true) {
            String userInput = input.nextLine();
            if (userInput.equals("bye")) {
                break;
            } else if (userInput.equals("list")) {
                print("Here are the tasks in your list:");
                for (int i = 0; i < taskNum; i++) {
                    print(Integer.toString(i + 1) + "."
                            + tasks[i].getDescription());
                }
            } else {
                String[] inputSplit = userInput.split(" ");
                String description = inputSplit[1];
                for (int i = 2; i < inputSplit.length - 2; i++) {
                    description += " " + inputSplit[i];
                }
                if (inputSplit[0].equals("done")) {
                    String stringNumber = inputSplit[1];
                    Integer number = Integer.valueOf(stringNumber);
                    tasks[number - 1].markAsDone();
                    print("Nice! I've marked this task as done:");
                    print("  " + tasks[number - 1].getDescription());
                } else if (inputSplit[0].equals("todo")) {
                    for (int i = inputSplit.length - 2; i < inputSplit.length ; i++) {
                        if (i == 1)
                            continue;
                        description += " " + inputSplit[i];
                    }
                    tasks[taskNum] = new Todo(description);
                    print("Got it. I've added this task:");
                    print("  " + tasks[taskNum].getDescription());
                    taskNum++;
                    print("Now you have "+taskNum+" tasks in the list.");
                } else if (inputSplit[0].equals("event")) {
                    tasks[taskNum] = new Event(description,inputSplit[inputSplit.length - 1]);
                    print("Got it. I've added this task:");
                    print("  " + tasks[taskNum].getDescription());
                    taskNum++;
                    print("Now you have "+taskNum+" tasks in the list.");
                } else if (inputSplit[0].equals("deadline")) {
                    tasks[taskNum] = new Deadline(description,inputSplit[inputSplit.length - 1]);
                    print("Got it. I've added this task:");
                    print("  " + tasks[taskNum].getDescription());
                    taskNum++;
                    print("Now you have "+taskNum+" tasks in the list.");
                }
            }

        }
        print("Bye. Hope to see you again soon!");


    }

    private static void print(String input) {
        System.out.println("    " + input);
    }
}
