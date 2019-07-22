package com.example.helpers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BooksUtilTest {

    @Test
    void isYYYY_DateFormattedOk() {
        String inputDate = "2019";
        Assertions.assertEquals("2019-01-01", BooksUtil.formatStringDate(inputDate));
    }

    @Test
    void isYYYY_MM_DateFormattedOk() {
        String inputDate = "2019-03";
        Assertions.assertEquals("2019-03-01", BooksUtil.formatStringDate(inputDate));
    }

    @Test
    void isYYYY_MM_DD_DateFormattedOk() {
        String inputDate = "2019-03-05";

        Assertions.assertEquals(inputDate, BooksUtil.formatStringDate(inputDate));
    }

}