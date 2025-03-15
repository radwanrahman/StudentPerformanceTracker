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
    @Test
    void testCalculateGPA() {
        StudentPerformanceWindow performanceWindow = new StudentPerformanceWindow(new ArrayList<>());

        assertFalse(performanceWindow.calculateGPA(55) == 3.0);
        assertFalse(performanceWindow.calculateGPA(75) == 2.0);
        //check gpa calc
    }
}
