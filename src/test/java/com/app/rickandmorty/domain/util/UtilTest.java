package com.app.rickandmorty.domain.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilTest {

    @Test
    public void testUrlValidator(){
        Assertions.assertTrue(Util.urlValidator("https://stackoverflow.com"));
        Assertions.assertFalse(Util.urlValidator("stackoverflow.com"));
        Assertions.assertFalse(Util.urlValidator("stackoverflow"));
        Assertions.assertFalse(Util.urlValidator(null));
        Assertions.assertFalse(Util.urlValidator(""));
    }
}
