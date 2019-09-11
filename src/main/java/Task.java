public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /** Show the status is done or not.     */
    public String getStatusIcon() {
        return (isDone ? "V" : "X"); //return tick or X symbols
    }

    /** Change the status into done.     */
    public void markAsDone() {
        this.isDone = true;
    }

    /** Get the description of task.     */
    public String getDescription() {
        return  "[" + this.getStatusIcon() + "] " + this.description; //return tick or X symbols
    }

    /** Get the profile of task.     */
    public String getProfile() {
        return this.getStatusIcon() + " | " + this.description;
    }
}
