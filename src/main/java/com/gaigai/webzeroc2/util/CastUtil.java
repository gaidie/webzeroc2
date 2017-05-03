package com.gaigai.webzeroc2.util;

/**
 * Created by Administrator on 2017/5/3.
 */
public final class CastUtil {

    public static String castString(Object obj){
        return castString(obj, "");
    }

    public static String castString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    public static double castDouble(Object obj){
        return castDouble(obj, 0);
    }

    public static double castDouble(Object obj, double defaultValue) {
        double doubleValue = defaultValue;
        if (obj != null){
            String objValue = castString(obj);
            if (StringUtil.isNotEmpty(objValue)){
                try {
                    doubleValue = Double.parseDouble(objValue);
                }catch (NumberFormatException e){
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    public static long castLong(Object obj){
        return castLong(obj, 0);
    }

    public static long castLong(Object obj, long defaultValue) {
        long doubleValue = defaultValue;
        if (obj != null){
            String objValue = castString(obj);
            if (StringUtil.isNotEmpty(objValue)){
                try {
                    doubleValue = Long.parseLong(objValue);
                }catch (NumberFormatException e){
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    public static int castInt(Object obj){
        return castInt(obj, 0);
    }

    public static int castInt(Object obj, int defaultValue) {
        int doubleValue = defaultValue;
        if (obj != null){
            String objValue = castString(obj);
            if (StringUtil.isNotEmpty(objValue)){
                try {
                    doubleValue = Integer.parseInt(objValue);
                }catch (NumberFormatException e){
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    public static boolean castBoolean(Object obj){
        return castBoolean(obj, false);
    }

    public static boolean castBoolean(Object obj, boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if (obj != null){
            booleanValue = Boolean.parseBoolean(castString(obj));
        }
        return booleanValue;
    }

}
