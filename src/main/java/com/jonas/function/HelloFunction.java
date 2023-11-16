package com.jonas.function;

import com.greenpineyu.fel.common.ObjectUtils;
import com.greenpineyu.fel.function.CommonFunction;
import com.jonas.constant.FunctionName;

public class HelloFunction extends CommonFunction {
    @Override
    public Object call(Object[] arguments) {
        Object msg = null;
        if(arguments!= null && arguments.length>0){
            msg = "hello " + arguments[0];
        }
        return ObjectUtils.toString(msg);
    }

    @Override
    public String getName() {
        return FunctionName.HELLO;
    }
}
