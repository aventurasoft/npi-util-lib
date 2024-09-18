package com.inttao.npi.backend.util.persistence;

import jakarta.persistence.Converter;
import jakarta.persistence.AttributeConverter;
import java.time.LocalDate;
import java.time.YearMonth;

@Converter
public class YearMonthIntegerAttributeConverter implements AttributeConverter<YearMonth, LocalDate> {

    @Override
    public LocalDate convertToDatabaseColumn(YearMonth yearMonth) {
        if (yearMonth == null)
            return null;
        else
            return LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), 1);
    }

    @Override
    public YearMonth convertToEntityAttribute(LocalDate date) {
        if (date == null) return null;
        return YearMonth.of(date.getYear(), date.getMonth());
    }


}
