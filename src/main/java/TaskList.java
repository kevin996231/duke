import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;
    public TaskList() {
        tasks = new ArrayList<>();
    }
    public void addTask(String type,String description,String time) {
        if (type.equals("todo")) {
            tasks.add(new Todo(description));
        } else if (type.equals("event")) {
            tasks.add(new Event(description,time));
        } else if (type.equals("deadline")) {
            tasks.add(new Deadline(description,time));
        }
    }
    public void deleteTask(int index) {
        tasks.remove(tasks.get(index));
    }
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
