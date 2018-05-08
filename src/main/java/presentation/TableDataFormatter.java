/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author sprlajur
 */
public class TableDataFormatter {

    private static final int MAX_SUBJECT_LENGTH = 150;
    private static final String CURRENCY_EUR = "EUR";
    public static final String DATE_PATTERN = "dd.MM.yyyy";
    private static final String DATA_DB_SEPARATOR = ";;";

    public static Object dataOrEmptyString(Object data) {
        if (data == null) {
            return "";
        }
        return data;
    }
    
    public static Object dataOrDash(Object data) {
        if (data == null) {
            return "-";
        }
        return data;
    }

    public static String priceFormatter(BigDecimal price, String currency) {
        if (price == null) {
            return "";
        }
        if (currency != null && currency.equals(CURRENCY_EUR)) {
            NumberFormat format = NumberFormat.getCurrencyInstance(Locale.FRANCE);
            return format.format(price);
        } else {
            return price + " " + dataOrEmptyString(currency);
        }
    }
    
    public static String priceFormatter(float price, String currency){
        return priceFormatter(new BigDecimal(price), currency);
    }

    public static String dateFormatter(Date dbDate) {
        return dbDate == null ? "-" : dateFormatter(dbDate.toString());
    }

    public static String dateFormatter(LocalDate dbDate) {
        return dbDate == null ? "-" : dateFormatter(dbDate.toString());
    }
    
    public static String dateFormatter(String dbDate) {
        if (dbDate == null) {
            return "-";
        }
        return LocalDate.parse(dbDate).format(DateTimeFormatter.
                ofPattern(DATE_PATTERN));
    }

    public static String formatTextData(String data) {
        if (data == null) {
            return "-";
        }
        data = data.trim().replaceAll(DATA_DB_SEPARATOR, "");
        if (data.length() < 150) {
            data = data.substring(0, data.length());
        } else {
            data = data.substring(0, MAX_SUBJECT_LENGTH) + "...";
        }
        return data.trim();
    }

    public static String formatParties(String data, int partyOrd) {
        if (data == null) {
            return "-";
        }
        try {
            data = data.split(DATA_DB_SEPARATOR)[partyOrd];
        } catch (IndexOutOfBoundsException e) {
            return "-";
        }
        data = data.trim();
        return data.charAt(data.length() - 1) == ',' ? data.substring(0, data.length() - 1) : data;
    }
}
