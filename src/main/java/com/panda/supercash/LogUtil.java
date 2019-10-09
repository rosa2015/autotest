package com.panda.supercash;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogUtil {
    private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);
    public static void log(String log) {
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        StackTraceElement stack1 = stacks[1];
        String runLog=">>>>>>---class:" + stack1.getClassName() +",mn:" + stack1.getMethodName()+",line:" + stack1.getLineNumber();
       // String runLog=stack1.getMethodName()+",line:" + stack1.getLineNumber();
        logger.info(runLog+"------"+log);
    }

}
