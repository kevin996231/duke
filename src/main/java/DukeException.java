public class DukeException extends Exception {
    protected String message;

    public DukeException(String errorMessage) {
        this.message = "OOPS!!! " + errorMessage;
    }
}
