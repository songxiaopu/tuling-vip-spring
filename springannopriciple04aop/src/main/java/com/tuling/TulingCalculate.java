package com.tuling;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

/**
 * Created by smlz on 2019/6/10.
 */
@Component
public class TulingCalculate implements Calculate {

    public int add(int numA, int numB) {
        System.out.println("执行目标方法:add");
//        System.out.println(1/0);
        return numA + numB;
    }

    public int reduce(int numA, int numB) {
        System.out.println("执行目标方法:reduce");
        return numA - numB;
    }

    public int div(int numA, int numB) {
        System.out.println("执行目标方法:div");

        return numA / numB;
    }

    public int multi(int numA, int numB) {
        System.out.println("执行目标方法:multi");

        return numA * numB;
    }

    public int mod(int numA, int numB) {
        System.out.println("执行目标方法:mod");
        if (numA > numB) {
            return multi(numA, numB);
        } else {
            return ((Calculate) AopContext.currentProxy()).multi(numA, numB);
        }
    }

}
