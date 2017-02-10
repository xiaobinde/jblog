package com.blog.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * Created by liuhaibin on 07/01/2017.
 */
public class LoggerUtils {

    /**
     * 是否开启Debug
     */
    public static  boolean isDebug = Logger.getLogger(LoggerUtils.class).isDebugEnabled();

    /**
     * Debug 输出
     * @param clazz    目标类
     * @param message  输出信息
     */
    public  static void debug(Class<? extends Object> clazz,String message){
        if (!isDebug) return;
        Logger logger = Logger.getLogger(clazz);
        logger.debug(message);
    }

    /**
     * 按照格式输出日志信息
     * @param clazz
     * @param fmtString
     * @param value
     */
    public static void fmtDebug(Class<? extends Object> clazz,String fmtString,Object...value){
        if (!isDebug) return;
        if (StringUtils.isBlank(fmtString)){
            return;
        }
        if (null != value && value.length != 0){
            fmtString = String.format(fmtString,value);
        }
        debug(clazz,fmtString);
    }

    /**
     * Error 日志输出
     * @param clazz
     * @param message
     * @param e
     */
    public static void error(Class<? extends Object> clazz,String message,Exception e){
        Logger logger = Logger.getLogger(clazz);
        if (null == e){
            logger.error(message);
            return;
        }
        logger.error(message,e);
    }

    /**
     * Error 日志输出
     * @param clazz
     * @param message
     */
    public static void error(Class<? extends Object> clazz,String message){
        error(clazz, message,null);
    }


    /**
     * Error 格式化日志输出
     * @param clazz
     * @param e
     * @param fmtString
     * @param value
     */
    public static void fmtError(Class<? extends Object> clazz,Exception e,String fmtString,Object...value){
        if (StringUtils.isBlank(fmtString)){
            return;
        }
        if (null != value && value.length != 0){
            fmtString = String.format(fmtString,value);
        }
        error(clazz,fmtString,e);
    }

    /**
     * Error 格式化日志输出
     * @param clazz
     * @param fmtString
     * @param vlaue
     */
    public static void fmtError(Class<? extends Object> clazz,String fmtString,Object...vlaue){
        fmtError(clazz,null,fmtString,vlaue);
    }

}
