import java.util.Scanner;

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
                String[] inputSplit = userInput.split("\\s+");
                if (inputSplit[0].equals("done")) {
                    String stringNumber = inputSplit[1];
                    Integer number = Integer.valueOf(stringNumber);
                    tasks[number - 1].markAsDone();
                    print("Nice! I've marked this task as done:");
                    print("  " + tasks[number - 1].getDescription());
                } else if (inputSplit[0].equals("todo")) {
                    String description = stringCompose(inputSplit,1,inputSplit.length - 1);
                    tasks[taskNum] = new Todo(description);
                    printAddedClass();
                } else if (inputSplit[0].equals("event")) {
                    int breakpoint = find(inputSplit,"/at");
                    String description = stringCompose(inputSplit,1,breakpoint - 1);
                    String time = stringCompose(inputSplit,breakpoint + 1,inputSplit.length - 1);
                    tasks[taskNum] = new Event(description,time);
                    printAddedClass();
                } else if (inputSplit[0].equals("deadline")) {
                    int breakpoint = find(inputSplit,"/by");
                    String description = stringCompose(inputSplit,1,breakpoint - 1);
                    String time = stringCompose(inputSplit,breakpoint + 1,inputSplit.length - 1);
                    tasks[taskNum] = new Deadline(description,time);
                    printAddedClass();
                }
            }

        }
        print("Bye. Hope to see you again soon!");


    }
    private static int find(String[] input,String key) {
        for (int i = 0; i < input.length; i++) {
            if( input[i].equals(key)){
                return i;
            }
        }
        return -1;
    }
    private static String stringCompose(String[] input,int start, int end) {
        String s = input[start];
        for (int i = start + 1; i <= end; i++) {
            s += " " + input[i];
        }
        return s;
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
