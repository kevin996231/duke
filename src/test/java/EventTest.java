import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {

    @Test
    public void testValidDate() {
        Event tester = new Event("123","9/9/19");
        assertEquals("X", tester.getStatusIcon(),"check icon at the beginning");
        assertEquals("[E][X] 123 (at: Sat Sep 09 00:00:00 CST 19)", tester.getDescription(),"check description at the beginning" );
        assertEquals("E | X | 123 | Sat Sep 09 00:00:00 CST 19", tester.getProfile(),"check profile at the beginning" );
        tester.markAsDone();
        assertEquals("V", tester.getStatusIcon(),"check icon after task is done" );
        assertEquals("[E][V] 123 (at: Sat Sep 09 00:00:00 CST 19)", tester.getDescription(),"check description after task is done" );
        assertEquals("E | V | 123 | Sat Sep 09 00:00:00 CST 19", tester.getProfile(),"check profile after task is done" );

    }
    @Test
    public void testInvalidDate() {
        Event tester = new Event("123","time");
        assertEquals("X", tester.getStatusIcon(),"check icon at the beginning");
        assertEquals("[E][X] 123 (at: time)", tester.getDescription(),"check description at the beginning" );
        assertEquals("E | X | 123 | time", tester.getProfile(),"check profile at the beginning" );
        tester.markAsDone();
        assertEquals("V", tester.getStatusIcon(),"check icon after task is done" );
        assertEquals("[E][V] 123 (at: time)", tester.getDescription(),"check description after task is done" );
        assertEquals("E | V | 123 | time", tester.getProfile(),"check profile after task is done" );

    }


}