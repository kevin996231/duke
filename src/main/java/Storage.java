import java.io.IOException;
import java.io.PrintWriter;

public class Storage {
    private String path;
    public Storage(String path) {
        this.path = path;
    }
    public void save(TaskList tasks) throws DukeException{
        try {
            PrintWriter writer = new PrintWriter("./data/duke.txt");
            for (int i = 0; i < tasks.length(); i++) {
                String profile = tasks.getProfile(i);
                writer.println(profile);
            }
            writer.close();
        } catch (IOException e) {
            throw new DukeException("No such file.");
        }
    }
}
