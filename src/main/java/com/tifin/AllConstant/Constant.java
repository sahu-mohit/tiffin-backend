package com.tifin.AllConstant;

public enum Constant {

    INDIAN_DATE_FORMAT("dd-MM-yyyy"),
    YEAR_MONTH_DATE("yyyy-MM-dd"),
    US_DATE_FORMAT_WITH_TIME("MM/dd/yyyy HH:mm:ss"),
    SQL_FORMAT_DATE_TIME("yyyy-MM-dd HH:mm:ss"),
    SQL_FORMAT_DATE("yyyy-MM-dd"),
    INDIAN_DATE_FORMAT_WITH_TIME("dd-MM-yyyy HH:mm:ss");

    private final String value;

    Constant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
