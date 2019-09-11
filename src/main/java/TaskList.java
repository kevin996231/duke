import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    /** Add task to tasklist.
     * @param type type of task.
     * @param description  name of the task.
     * @param time the date/time when task occurs.
     */
    public void addTask(String type,String description,String time) {
        if (type.equals("todo")) {
            tasks.add(new Todo(description));
        } else if (type.equals("event")) {
            tasks.add(new Event(description,time));
        } else if (type.equals("deadline")) {
            tasks.add(new Deadline(description,time));
        }
    }

    /** Delete task from tasklist.
     * @param index The index of task that needs to be deleted.
     */
    public void deleteTask(int index) {
        tasks.remove(tasks.get(index));
    }

    /** Number of tasks remaining.     */
    public Integer length() {
        return tasks.size();
    }

    public String getDescription(int index) {
        return  tasks.get(index).getDescription();
    }

    public String getProfile(int index) {
        return  tasks.get(index).getProfile();
    }

    public void markAsDone(int index) {
        tasks.get(index).markAsDone();
    }
}
