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
        String[] tasks = new String[100];
        int task_num = 0;
        while (true) {
            String userinput = input.nextLine();
            if (userinput.equals("bye")) {
                break;
            }
            tasks[task_num] = userinput;
            task_num++;

            System.out.println("    added: " + userinput);
        }
        System.out.println("    Bye. Hope to see you again soon!");


    }
}
