import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test
  public void testList() {
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("test");
    stringList.add("testa");
    stringList.add("testa1");
    List<String> ans = ListExamples.filter(stringList, (String s) -> {
      return s.contains("a");
    });
    assertArrayEquals(ans.toArray(), new String[]{"testa", "testa1"});
  }
}
