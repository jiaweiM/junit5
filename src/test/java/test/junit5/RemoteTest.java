package test.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author JiaweiMao 2017.03.16
 * @since 1.0.0
 */
@DisplayName("Remote test")
public class RemoteTest {

    @Test
    @Remote
    public void testGetUser(){
        System.out.println("Get user");
    }

}
