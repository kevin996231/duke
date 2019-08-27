public class Event extends Task {

    protected String time;

    public Event(String description, String time) {
        super(description);
        this.time = time;
    }

    @Override
    public String getDescription() {
        return "[E]" + super.getDescription() + " (at: " + time + ")";
    }
}