import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class StudentPerformanceTrackerTest {

    @Test
    void testStudentRecordCreation() {
        StudentRecord record = new StudentRecord("Math", 20, 10, 15, 30, 5);

        assertNotNull(record, "Student record should not be null");
        assertEquals("Math", record.subject, "Subject name mismatch");
        assertEquals(80, record.getTotalMarks(), "Total marks calculation is incorrect");
    }

   

    @Test
    public void testGradeCalculation() {
        ViewResultsWindow viewResults = new ViewResultsWindow(new ArrayList<>());

        assertEquals("A+", viewResults.calculateGrade(85), "Grade should be A+");
        assertEquals("A", viewResults.calculateGrade(78), "Grade should be A");
        assertEquals("B+", viewResults.calculateGrade(65), "Grade should be B+");
        assertEquals("D", viewResults.calculateGrade(40), "Grade should be D");
        assertEquals("F", viewResults.calculateGrade(30), "Grade should be F");
    }

    @Test
    void testGPACalculation() {
        ViewResultsWindow viewResults = new ViewResultsWindow(new ArrayList<>());

        assertEquals(4.0, viewResults.calculateGPA(85), "GPA should be 4.0");
        assertEquals(3.75, viewResults.calculateGPA(76), "GPA should be 3.75");
        assertEquals(2.5, viewResults.calculateGPA(50), "GPA should be 2.5");
        assertEquals(0.0, viewResults.calculateGPA(30), "GPA should be 0.0");
    }
    

    @Test
    void testViewResultsDoesNotThrowForValidRecords() {
        List<StudentRecord> records = new ArrayList<>();
        records.add(new StudentRecord("Math", 25, 15, 20, 30, 10));

        assertDoesNotThrow(() -> new ViewResultsWindow(records), "Should not throw exception for valid records");
    }

    @Test
    void testAddStudentRecord() {
        List<StudentRecord> records = new ArrayList<>();
        StudentRecord record = new StudentRecord("Biology", 30, 20, 20, 25, 5);
        records.add(record);

        assertTrue(records.contains(record), "Record should be added to the list");
        assertEquals(1, records.size(), "Records list should have one entry");
    }

    @Test
    void testEmptyStudentRecord() {
        StudentRecord record = null;
        assertNull(record, "Student record should be null");
    }

    @Test
    void testNonEmptyStudentRecord() {
        StudentRecord record = new StudentRecord("Chemistry", 20, 10, 15, 30, 5);
        assertNotNull(record, "Student record should not be null");
    }

    @Test
    void testArrayEquals() {
        String[] expectedSubjects = {"Math", "Science", "English"};
        String[] actualSubjects = {"Math", "Science", "English"};

        assertArrayEquals(expectedSubjects, actualSubjects, "Subject arrays should match");
    }

    @Test
    void testLinesMatch() {
        List<String> expectedLines = List.of("Math - 85", "Science - 90", "English - 75");
        List<String> actualLines = List.of("Math - 85", "Science - 90", "English - 75");

        assertLinesMatch(expectedLines, actualLines, "Lines should match");
    }

    @Test
    void testFailExample() {
        try {
            StudentRecord record = new StudentRecord("Math", 25, 15, 10, 35, 5);
            if (record.getTotalMarks() < 0) {
                fail("Total marks should not be negative");
            }
        } catch (Exception e) {
            fail("An unexpected exception occurred: " + e.getMessage());
        }
    }
}
