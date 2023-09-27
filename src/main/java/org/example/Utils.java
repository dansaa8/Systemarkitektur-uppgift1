package org.example;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public final class Utils {
   private Utils(){}

       public static String getNameOfToday () {
       return LocalDate.now().getDayOfWeek()
                   .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
       }
}
