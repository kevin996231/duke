import java.io.PrintWriter;
import java.io.IOException;


public class Duke {


    static TaskList tasks;
    static Ui ui;
    static Parser parser;

    /** main. */

    public static void main(String[] args) {
        //        String logo = " ____        _        \n"
        //                + "|  _ \\ _   _| | _____ \n"
        //                + "| | | | | | | |/ / _ \\\n"
        //                + "| |_| | |_| |   <  __/\n"
        //                + "|____/ \\__,_|_|\\_\\___|\n";
        //        System.out.println("Hello from\n" + logo);
        tasks = new TaskList();
        ui = new Ui();
        parser = new Parser();

        ui.welcome();

        while (true) {
            try {

                String userInput = ui.input();
                String[] inputSplit = parser.parse(userInput);
                parser.checkValidation(inputSplit);
                if (userInput.equals("bye")) {
                    break;
                } else if (userInput.equals("list")) {
                    if (tasks.length() == 0) {
                        throw new DukeException("There are no tasks.");
                    }
                    ui.output("Here are the tasks in your list:");
                    for (int i = 0; i < tasks.length(); i++) {
                        ui.output((i + 1) + "." + tasks.getDescription(i));
                    }
                } else {
                    if (inputSplit[0].equals("done") || inputSplit[0].equals("delete")) {
                        String stringNumber = inputSplit[1];
                        int number = Integer.parseInt(stringNumber);

                        if (number > tasks.length() || number < 1) {
                            throw new DukeException("This task doesn't exist.");
                        }
                        if (inputSplit[0].equals("done")) {
                            tasks.markAsDone(number - 1);
                            ui.output("Nice! I've marked this task as done:");
                            ui.output("  " + tasks.getDescription(number - 1));
                        } else {
                            ui.output("Noted. I've removed this task:");
                            ui.output("  " + tasks.getDescription(number - 1));
                            tasks.deleteTask(number - 1);
                            ui.output("Now you have " + tasks.length() + " tasks in the list.");
                        }
                    } else if (inputSplit[0].equals("todo")) {
                        String[] detail = parser.extract(inputSplit,null);
                        tasks.addTask("todo",detail[0],null);
                        ui.printAddedClass(tasks.getDescription(tasks.length() - 1),tasks.length());
                    } else if (inputSplit[0].equals("event")) {
                        String[] detail = parser.extract(inputSplit,"/at");
                        tasks.addTask("event",detail[0],detail[1]);
                        ui.printAddedClass(tasks.getDescription(tasks.length() - 1),tasks.length());
                    } else if (inputSplit[0].equals("deadline")) {
                        String[] detail = parser.extract(inputSplit,"/by");
                        tasks.addTask("deadline",detail[0],detail[1]);
                        ui.printAddedClass(tasks.getDescription(tasks.length() - 1),tasks.length());
                    } else if (inputSplit[0].equals("find")) {
                        int count = 0;
                        for (int i = 0; i < tasks.length(); i++) {
                            if (tasks.getDescription(i).contains(inputSplit[1])) {
                                count += 1;
                                if (count == 1) {
                                    ui.output("Here are the matching tasks in your list:");
                                }
                                ui.output(count + "." + tasks.getDescription(i));
                            }
                        }
                        if (count == 0) {
                            ui.output("Sorry. No tasks are found.");
                        }
                    }
                    save();
                }
            } catch (DukeException e) {
                ui.showErrorMessage(e.message);
            }
        }
        ui.output("Bye. Hope to see you again soon!");
    }

    private static void save() {
        try {
            PrintWriter writer = new PrintWriter("./data/duke.txt");
            for (int i = 0; i < tasks.length(); i++) {
                String profile = tasks.getProfile(i);
                writer.println(profile);
            }
            writer.close();
        } catch (IOException e) {
            ui.output("No such file.");
        }
    }



}
