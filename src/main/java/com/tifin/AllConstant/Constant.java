package com.tifin.AllConstant;

public enum Constant {

    INDIAN_DATE_FORMAT("dd-MM-yyyy"),
    YEAR_MONTH_DATE("yyyy-MM-dd"),
    US_DATE_FORMAT_WITH_TIME("MM/dd/yyyy HH:mm:ss"),
    SQL_FORMAT_DATE_TIME("yyyy-MM-dd HH:mm:ss"),
    SQL_FORMAT_DATE("yyyy-MM-dd"),
    ERROR("Oops! Something went wrong on our end. Please try again later or contact support."),
    SUCCESS_STATUS("Succes"),
    SUCCESS_CODE("0"),
    FAILED_CODE("1"),
    TECHNICAL_ERROR("Technical Error Occurred"),
    FAILED_STATUS("Failed"),
    INDIAN_DATE_FORMAT_WITH_TIME("dd-MM-yyyy HH:mm:ss");

    private final String value;

    Constant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
