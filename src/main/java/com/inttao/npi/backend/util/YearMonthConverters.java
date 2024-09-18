package com.inttao.npi.backend.util;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;


public class YearMonthConverters {


    /***
     * Convierte string date a YearMonth
     * La idea es que acepte formato 'yyyy-MM-dd'
     * @param localDateStr string con formato 'yyyy-MM-dd'
     * @return YearMonth
     */
    public static YearMonth stringToYearMonth(String localDateStr) {
        if (localDateStr == null) return null;
        LocalDate localDate = LocalDate.parse(localDateStr.substring(0, 10));
        return YearMonth.of(localDate.getYear(), localDate.getMonthValue());
    }

    /****
     * Convierte a string un YearMonth
     * @param yearMonth YearMonth
     * @return string con formato 'yyyy-MM-dd'
     */
    public static String yearMonthToString(YearMonth yearMonth) {
        if (yearMonth == null) return null;
        return yearMontToLocalDate(yearMonth).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static YearMonth localDateToYearMonth(LocalDate localDate) {
        if (localDate == null) return null;
        return YearMonth.of(localDate.getYear(), localDate.getMonthValue());
    }

    public static LocalDate yearMontToLocalDate(YearMonth yearMonth) {
        if (yearMonth == null) return null;
        return LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), 1);
    }


}
