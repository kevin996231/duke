import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {
    @Test
    public void testTaskList() {
        TaskList tester = new TaskList();

        tester.addTask("todo","111",null);
        tester.addTask("event","222","9/9/19");
        tester.addTask("deadline","333","9/9/19 1844");

        assertEquals(3, tester.length(),"check length");
        assertEquals("[D][X] 333 (by: Sat Sep 09 18:44:00 CST 19)", tester.getDescription(2),"check description");
        assertEquals("E | X | 222 | Sat Sep 09 00:00:00 CST 19", tester.getProfile(1),"check profile");

        tester.markAsDone(0);
        assertEquals("T | V | 111", tester.getProfile(0),"check markasdone");

        tester.deleteTask(1);
        assertEquals(2, tester.length(),"check length after delete");
        assertEquals("D | X | 333 | Sat Sep 09 18:44:00 CST 19", tester.getProfile(1),"check profile after delete");

    }



}