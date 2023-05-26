package test.studentCenter.util;

import com.studyCenter.util.GsonUtil;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;

public class GsonUtilTest {

    @Test
    public void testToJson() {
        SampleObject obj = new SampleObject("John Doe", 25);

        String json = GsonUtil.toJson(obj);

        // Check if the JSON string is not null
        Assert.assertNotNull(json);

        // Perform additional assertions on the JSON string if needed
    }

    @Test
    public void testToObj() {
        String json = "[{\"name\":\"John Doe\",\"age\":25}]";

        SampleObject obj = (SampleObject) GsonUtil.toObj(json, SampleObject.class);

        // Check if the converted object is not null
        Assert.assertNotNull(obj);

        // Perform additional assertions on the object if needed
    }

    @Test
    public void testToObjList() {
        String json = "[{\"name\":\"John Doe\",\"age\":25},{\"name\":\"Jane Smith\",\"age\":30}]";

        List<Object> objList = GsonUtil.toObjList(json, SampleObject.class);

        // Check if the converted object list is not null
        Assert.assertNotNull(objList);

        // Perform additional assertions on the object list if needed
    }

    // Define a sample object class for testing purposes
    private static class SampleObject {
        private String name;
        private int age;

        public SampleObject(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
