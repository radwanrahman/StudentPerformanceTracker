import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentRecordTest {

    private StudentRecord record;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Starting all tests for StudentRecord...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("All tests completed for StudentRecord.");
    }

    @BeforeEach
    void setUp() {
        record = new StudentRecord("Mathematics", 20, 10, 10, 40, 10);
        System.out.println("Setting up test case...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test case completed.");
    }
    @Test
    void testGetTotalMarks() {
        assertEquals(90, record.getTotalMarks(), "Total marks calculation is incorrect!");
    }

    

}
