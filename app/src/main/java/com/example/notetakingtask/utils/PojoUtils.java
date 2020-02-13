package com.example.notetakingtask.utils;

public class PojoUtils
{

    public static String checkResult(String result)
    {
        if (result == null || result.equals("null"))
            return "";
        return result;
    }

}
