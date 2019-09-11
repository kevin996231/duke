import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class ParserTest {
    @Test
    public void testParser() throws DukeException {
        Parser tester = new Parser();
        assertArrayEquals(new String[] {"123","456","789"}, tester.parse("123 456 789"),"check parse1");
        assertArrayEquals(new String[] {"123","456","789"}, tester.parse("123      456      789"),"check parse2");
        assertEquals(1, tester.find(new String[] {"123","456","789"},"456"),"check find");
        assertArrayEquals(new String[] {"abc","time1 time2 time3",null,null,null},
                tester.extract(new String[] {"event","abc","/at","time1","time2","time3"},"/at"),"check extract");

    }
}
