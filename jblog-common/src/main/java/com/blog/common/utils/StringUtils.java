package com.blog.common.utils;

/**
 * Created by liuhaibin on 07/01/2017.
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * 一次性判断多个或者单个对象为空
     * @param objects
     * @return
     */
    public static boolean isEmpty(Object...objects){
        Boolean result = false;

        if (objects == null || objects.length == 0)
            return result;

        for (Object object : objects){
            if (null == object || "".equals(object.toString().trim())){
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * 判断多个String对象是否为空
     * @param objects
     * @return
     */
    public static boolean isEmpty(String...objects){
        Object[] object = objects;
        return isEmpty(object);
    }

    /**
     * 判断一个String对象是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        Object object = str;
        return isEmpty(object);
    }

}

