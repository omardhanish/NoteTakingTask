package com.example.notetakingtask;

public class PojoUtils
{

    public static String checkResult(String result)
    {
        if (result == null || result.equals("null"))
            return "";
        return result;
    }

    public static Boolean checkBoolean(Boolean b){
        if(b == null)
            return false;

        return b;
    }

    public static Object checkObject(Object result)
    {
        if (result == null || result.equals("null"))
            return "";
        return result;
    }

    public static String checkResultFlag(String result)
    {
        if (result == null)
            result = "";
        if (result.equals(""))
            result = "N";
        return result;
    }

    public static Integer checkResultAsInt(Integer result)
    {
        if (result == null)
            return 0;
        return result;
    }

    public static Double checkResultAsDouble(Double result)
    {
        if (result == null)
            return 0.0;
        return result;
    }

    public static Integer checkResultAsString(String result)
    {
        if (result == null)
            return 0;
        if (result.equals(""))
            return 0;
        return Integer.parseInt(result);
    }

    public static String checkResultAsColor(String result)
    {
        if (result == null)
            return "000000";
        if (result.equals(""))
            return "000000";
        return result;
    }

}
