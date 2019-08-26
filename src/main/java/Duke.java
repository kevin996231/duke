import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
        System.out.println("    Hello! I'm Duke\n    What can I do for you?");
        Scanner input = new Scanner(System.in);
        while(true){
            String userinput = input.nextLine();
            if(userinput.equals("bye"))
                break;
            System.out.println("    "+userinput);
        }
        System.out.println("    Bye. Hope to see you again soon!");


    }
}
