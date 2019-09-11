import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {

    @Test
    public void testValidDate() {
        Deadline tester = new Deadline("123","9/9/19 1837");
        assertEquals("X", tester.getStatusIcon(),"check icon at the beginning");
        assertEquals("[D][X] 123 (by: Sat Sep 09 18:37:00 CST 19)", tester.getDescription(),"check description at the beginning" );
        assertEquals("D | X | 123 | Sat Sep 09 18:37:00 CST 19", tester.getProfile(),"check profile at the beginning" );
        tester.markAsDone();
        assertEquals("V", tester.getStatusIcon(),"check icon after task is done" );
        assertEquals("[D][V] 123 (by: Sat Sep 09 18:37:00 CST 19)", tester.getDescription(),"check description after task is done" );
        assertEquals("D | V | 123 | Sat Sep 09 18:37:00 CST 19", tester.getProfile(),"check profile after task is done" );

    }
    @Test
    public void testInvalidDate() {
        Deadline tester = new Deadline("123","time");
        assertEquals("X", tester.getStatusIcon(),"check icon at the beginning");
        assertEquals("[D][X] 123 (by: time)", tester.getDescription(),"check description at the beginning" );
        assertEquals("D | X | 123 | time", tester.getProfile(),"check profile at the beginning" );
        tester.markAsDone();
        assertEquals("V", tester.getStatusIcon(),"check icon after task is done" );
        assertEquals("[D][V] 123 (by: time)", tester.getDescription(),"check description after task is done" );
        assertEquals("D | V | 123 | time", tester.getProfile(),"check profile after task is done" );

    }


}