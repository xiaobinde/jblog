package com.blog.common.utils;

import java.io.File;

/**
 * Created by liuhaibin on 15/01/2017.
 */
public class PathKitUtils {
    private static String webRootPath;
    private static String rootClassPath;

    public PathKitUtils() {
    }

    public static String getPath(Class clazz) {
        String path = clazz.getResource("").getPath();
        return (new File(path)).getAbsolutePath();
    }

    public static String getPath(Object object) {
        String path = object.getClass().getResource("").getPath();
        return (new File(path)).getAbsolutePath();
    }

    public static String getRootClassPath() {
        if(rootClassPath == null) {
            try {
                String e = PathKitUtils.class.getClassLoader().getResource("").toURI().getPath();
                rootClassPath = (new File(e)).getAbsolutePath();
            } catch (Exception var2) {
                String path = PathKitUtils.class.getClassLoader().getResource("").getPath();
                rootClassPath = (new File(path)).getAbsolutePath();
            }
        }

        return rootClassPath;
    }

    public void setRootClassPath(String rootClassPath) {
        PathKitUtils.rootClassPath = rootClassPath;
    }

    public static String getPackagePath(Object object) {
        Package p = object.getClass().getPackage();
        return p != null?p.getName().replaceAll("\\.", "/"):"";
    }

    public static File getFileFromJar(String file) {
        throw new RuntimeException("Not finish. Do not use this method.");
    }

    public static String getWebRootPath() {
        if(webRootPath == null) {
            webRootPath = detectWebRootPath();
        }

        return webRootPath;
    }

    public static void setWebRootPath(String webRootPath) {
        if(webRootPath != null) {
            if(webRootPath.endsWith(File.separator)) {
                webRootPath = webRootPath.substring(0, webRootPath.length() - 1);
            }

            PathKitUtils.webRootPath = webRootPath;
        }
    }

    private static String detectWebRootPath() {
        try {
            String e = PathKitUtils.class.getResource("/").toURI().getPath();
            return (new File(e)).getParentFile().getParentFile().getCanonicalPath();
        } catch (Exception var1) {
            throw new RuntimeException(var1);
        }
    }

    public static boolean isAbsolutelyPath(String path) {
        return path.startsWith("/") || path.indexOf(":") == 1;
    }

}
