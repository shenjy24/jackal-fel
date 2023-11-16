package com.jonas;

import com.jonas.engine.FelExpressionEngine;
import org.junit.Test;

public class FelTest {

    private final FelExpressionEngine felExpressionEngine = new FelExpressionEngine();

    @Test
    public void testHelloFunction() {
        String exp = "hello('Tom')";
        Object res = felExpressionEngine.eval(exp);
        System.out.println(res);
    }
}
