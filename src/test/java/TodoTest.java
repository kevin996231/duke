import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {

    @Test
    public void testTodoClass() {
        Todo tester = new Todo("123");
        assertEquals("X", tester.getStatusIcon(),"check icon at the beginning");
        assertEquals("[T][X] 123", tester.getDescription(),"check description at the beginning" );
        assertEquals("T | X | 123", tester.getProfile(),"check profile at the beginning" );
        tester.markAsDone();
        assertEquals("V", tester.getStatusIcon(),"check icon after task is done" );
        assertEquals("[T][V] 123", tester.getDescription(),"check description after task is done" );
        assertEquals("T | V | 123", tester.getProfile(),"check profile after task is done" );

    }


}