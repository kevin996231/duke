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
        System.out.println("    Hello! I'm Duke\n    What can I do for you?");
        Scanner input = new Scanner(System.in);
        Task tasks[] = new Task[100];
        int taskNum = 0;
        while (true) {
            String userInput = input.nextLine();
            if (userInput.equals("bye")) {
                break;
            } else if (userInput.equals("list")) {
                for (int i = 0; i < taskNum; i++) {
                    System.out.println("    " + Integer.toString(i + 1) + ". " + tasks[i].description);
                }
            } else if (userInput.split(" ")[0].equals("done")){
                String stringNumber = userInput.split(" ")[1];
                Integer number = Integer.valueOf(stringNumber);
                tasks[number - 1].markAsDone();
                System.out.println("    Nice! I've marked this task as done:");
                System.out.println("    "+tasks[number - 1].description);
            } else {
                tasks[taskNum] = new Task(userInput);
                taskNum++;
                System.out.println("    added: " + userInput);
            }

        }
        System.out.println("    Bye. Hope to see you again soon!");


    }
}
