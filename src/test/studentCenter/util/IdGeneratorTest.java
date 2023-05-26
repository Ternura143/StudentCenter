package test.studentCenter.util;

import com.studyCenter.util.IdGenerator;
import org.junit.Assert;
import org.junit.Test;

public class IdGeneratorTest {

    @Test
    public void testGetCode() {
        String id = IdGenerator.getCode();

        // Check if the generated ID is not null
        Assert.assertNotNull(id);

        // Check if the generated ID has the correct format
        Assert.assertTrue(id.matches("\\d{10}"));
    }
}
