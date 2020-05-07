package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBase {

    @Test
    public void someTest(){
        Assertions.assertTrue(2 + 2 == 5);
    }
}
