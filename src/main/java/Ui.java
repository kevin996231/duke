import java.util.Scanner;

public class Ui {
    Scanner scanner;
    public Ui() {
        scanner = new Scanner(System.in);
    }
    public String input() {
        return scanner.nextLine();
    }
    public void output(String out) {
        System.out.println("    " + out);
    }
    public void welcome() {
        this.output("Hello! I'm Duke");
        this.output("What can I do for you?");
    }
    public void printAddedClass(String description, int length) {
        this.output("Got it. I've added this task:");
        this.output("  " + description);
        this.output("Now you have " + length + " tasks in the list.");
    }
    public void showErrorMessage(String message) {
        this.output("OOPS!!! " + message);
    }
}
