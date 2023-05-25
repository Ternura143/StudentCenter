package test.studentCenter.util;

import com.studyCenter.util.FileOperator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FileOperatorTest {
    private static final String TEST_FILE_NAME = "test_data.txt";

    @Before
    public void setUp() {

        File dataDirectory = new File("data");
        if (!dataDirectory.exists()) {
            assertTrue(dataDirectory.mkdir());
        }
    }

    @After
    public void tearDown() {

        File testFile = new File("data/" + TEST_FILE_NAME);
        if (testFile.exists()) {
            assertTrue(testFile.delete());
        }
    }

    @Test
    public void testWriteAndLoadData() throws IOException {

        List<String> testData = new ArrayList<>();
        testData.add("Object 1");
        testData.add("Object 2");
        testData.add("Object 3");

        FileOperator.writeData(testData, TEST_FILE_NAME);

        List<String> loadedData = FileOperator.loadData(TEST_FILE_NAME, String.class);

        assertEquals(testData.size(), loadedData.size());
        for (int i = 0; i < testData.size(); i++) {
            assertEquals(testData.get(i), loadedData.get(i));
        }
    }

    @Test
    public void testWriteData() throws IOException {

        String testObject = "Test Object";

        FileOperator.writeData(testObject, TEST_FILE_NAME);

        List<String> loadedData = FileOperator.loadData(TEST_FILE_NAME, String.class);

        assertEquals(1, loadedData.size());
        assertEquals(testObject, loadedData.get(0));
    }
}

