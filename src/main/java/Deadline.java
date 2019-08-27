import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
public class Deadline extends Task {

    protected String time;
    protected Date date = null;
    SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy HHmm");
    SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
    public Deadline(String description, String time) {
        super(description);
        this.time = time;
        try{
            this.date = formatter1.parse(time);
            System.out.println(date);
        }
        catch(ParseException e1){
            try{
                this.date = formatter2.parse(time);
            }catch (ParseException e2){
                System.out.println("Can't understand as date. Stored as string.");
            }
        }
    }

    @Override
    public String getDescription() {
        if (date == null){
            return "[D]" + super.getDescription() + " (by: " + time + ")";
        } else {
            return "[D]" + super.getDescription() + " (by: " + date + ")";
        }
    }

    @Override
    public String getProfile() {
        if (date == null){
            return "D" + " | " + super.getProfile() + " | " + this.time;
        } else {
            return "D" + " | " + super.getProfile() + " | " + this.date;
        }
    }
}