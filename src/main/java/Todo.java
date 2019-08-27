public class Todo extends Task {


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