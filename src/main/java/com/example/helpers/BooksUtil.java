package com.example.helpers;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

final public class BooksUtil {

    private BooksUtil() {
        throw new UnsupportedOperationException();
    }

    public static String formatStringDate(String publishedDate) {

        if (publishedDate == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder(publishedDate);

        int length = publishedDate.length();
        if (length == 4) {
            sb.append("-01-01");
        } else if (length == 7) {
            sb.append("-01");
        }

        return sb.toString();
    }

    public static Long convertToUnixTimeStamp(String publishedDate) {
        String stringDate = formatStringDate(publishedDate);

        if (stringDate != null) {
            return LocalDate
                    .parse(stringDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    .atStartOfDay()
                    .toEpochSecond(ZoneOffset.UTC);
        } else {
            return null;
        }
    }
}