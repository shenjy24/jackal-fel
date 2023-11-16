package com.jonas.engine;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.context.ArrayCtxImpl;
import com.greenpineyu.fel.context.FelContext;
import com.jonas.function.HelloFunction;

import java.util.Map;

public class FelExpressionEngine {

    private final FelEngine felEngine;

    public FelExpressionEngine() {
        felEngine = new FelEngineImpl();

        // 添加自定义函数
        felEngine.addFun(new HelloFunction());
    }

    /**
     * 执行表达式
     *
     * @param exp 表达式
     * @return 返回值
     */
    public Object eval(String exp) {
        return felEngine.eval(exp);
    }

    /**
     * 执行表达式
     *
     * @param paramsMap 参数的map集合
     * @param expr      fel规则引擎表达式
     * @return 是否成功
     */
    public Boolean felEval(Map<String, Object> paramsMap, String expr) {
        // clean context
        felEngine.setContext(new ArrayCtxImpl());
        FelContext context = felEngine.getContext();
        // 放入变量
        paramsMap.forEach(context::set);
        try {
            Object result = felEngine.eval(expr);
            return (Boolean) result;
        } catch (Exception e) {
            throw new RuntimeException("表达式解析错误, expr:" + expr);
        }
    }
}
