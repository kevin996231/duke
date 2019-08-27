public class Deadline extends Task {

    protected String time;

    public Deadline(String description, String time) {
        super(description);
        this.time = time;
    }

    @Override
    public String getDescription() {
        return "[D]" + super.getDescription() + " (by: " + time + ")";
    }
}