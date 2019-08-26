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
                for (int i = 0; i < taskNum; i++) {
                    print(Integer.toString(i + 1) + ".["
                            + tasks[i].getStatusIcon() + "] " + tasks[i].description);
                }
            } else if (userInput.split(" ")[0].equals("done")) {
                String stringNumber = userInput.split(" ")[1];
                Integer number = Integer.valueOf(stringNumber);
                tasks[number - 1].markAsDone();
                print("Nice! I've marked this task as done:");
                print("  [" + tasks[number - 1].getStatusIcon() + "] " + tasks[number - 1].description);
            } else {
                tasks[taskNum] = new Task(userInput);
                taskNum++;
                print("added: " + userInput);
            }

        }
        print("Bye. Hope to see you again soon!");


    }

    private static void print(String input) {
        System.out.println("    " + input);
    }
}
