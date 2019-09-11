public class Todo extends Task {

    /** Todo, a type of task.
     * @param description  name of the event.
     */
    public Todo(String description) {
        super(description);
    }

    @Override
    public String getDescription() {
        return "[T]" + super.getDescription();
    }

    @Override
    public String getProfile() {
        return "T" + " | " + super.getProfile();
    }
}