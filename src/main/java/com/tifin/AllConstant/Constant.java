package com.tifin.AllConstant;

public enum Constant {

    INDIAN_DATE_FORMAT("dd-MM-yyyy"),
    INDIAN_DATE_TIME_FORMAT_IN_CHAR("EEE, MMM d, yyyy HH:mm:ss a"),
    YEAR_MONTH_DATE("yyyy-MM-dd"),
    US_DATE_FORMAT_WITH_TIME_24("MM/dd/yyyy HH:mm:ss"),
    US_DATE_FORMAT_WITH_TIME_12("MM/dd/yyyy HH:mm:ss a"),
    SQL_FORMAT_DATE_TIME("yyyy-MM-dd HH:mm:ss"),
    SQL_FORMAT_DATE("yyyy-MM-dd"),
    ERROR("Oops! Something went wrong on our end. Please try again later or contact support."),
    SUCCESS_STATUS("success"),
    SUCCESS_CODE("0"),
    FAILED_CODE("1"),
    TECHNICAL_ERROR("Technical Error Occurred"),
    FAILED_STATUS("Failed"),
    EXCEPTION_OCCURRED_STATUS("Exception Occurred"),
    EXCEPTION_OCCURRED_CODE("EXP_1"),
    INDIAN_DATE_FORMAT_WITH_TIME("dd-MM-yyyy HH:mm a");

    private final String value;

    Constant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
