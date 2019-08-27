import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Event extends Task {

    protected String time;
    protected Date date = null;
    SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy HHmm");
    SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
    /** event. */

    public Event(String description, String time) {
        super(description);
        this.time = time;
        try {
            this.date = formatter1.parse(time);
        } catch (ParseException e1) {
            try {
                this.date = formatter2.parse(time);
            } catch (ParseException e2) {
                System.out.println("    Can't understand as date. Stored as string.");
            }

        }
    }

    @Override
    public String getDescription() {
        if (date == null) {
            return "[E]" + super.getDescription() + " (by: " + time + ")";
        } else {
            return "[E]" + super.getDescription() + " (by: " + date + ")";
        }
    }

    @Override
    public String getProfile() {
        if (date == null) {
            return "E" + " | " + super.getProfile() + " | " + this.time;
        } else {
            return "E" + " | " + super.getProfile() + " | " + this.date;
        }
    }
}