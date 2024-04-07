package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SkbControllers {
    public static String getUniqueName(String str) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date());
    }
}
