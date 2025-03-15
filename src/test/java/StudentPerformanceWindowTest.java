import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class StudentPerformanceWindowTest {

    @Test
    void testGeneratePerformanceTip() {
        StudentPerformanceWindow performanceWindow = new StudentPerformanceWindow(new ArrayList<>());

        assertSame("Excellent! Keep up the great work!", performanceWindow.generatePerformanceTip(3.9));
        assertNotSame("Needs Improvement! Focus on weaker subjects.", performanceWindow.generatePerformanceTip(3.5));
    }
}
