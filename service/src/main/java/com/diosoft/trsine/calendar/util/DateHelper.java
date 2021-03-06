package com.diosoft.trsine.calendar.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Help to handle simple <code>Date</code> operations.
 *
 * @author  Alexander Zamkovyi
 * @version 1.0
 * @since 1.0
 */

public final class DateHelper {

    /**
     * Noargument constructor.
     */
    private DateHelper() { }

    /**
     * Gets <code>Date</code> without time.
     *
     * @param date input <code>Date</code>
     * @return <code>Date</code> without time
     */
    public static Date getOnlyDate(final Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date result = null;
        try {
            result = sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Adds 1 day to the input <code>Date</code>.
     *
     * @param date input <code>Date</code>
     * @return result <code>Date</code>
     */
    public static Date dayIncrement(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    /**
     * Converts String of "yyyy-MM-dd HH:mm:ss" format into <code>Date</code>.
     *
     * @param inputStringDate input <code>Date</code>
     *                        in format "yyyy-MM-dd HH:mm:ss", 24h
     *
     * @return result <code>Date</code>
     */
    public static Date getDateFromSimpleString(final String inputStringDate) {
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(inputStringDate));
        } catch (ParseException e) {
            System.err.println("Error parsing date " + e.getMessage());
            return null;
        }

        return calendar.getTime();
    }

    /**
     * Converts String of  given format into <code>Date</code>.
     *
     * @param inputStringDate input <code>Date</code>
     *                        in format given, 24h
     *
     * @return result <code>Date</code>
     */
    public static Date getDateFromString(final String inputStringDate, final String format) {
        SimpleDateFormat dateFormat =
                new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(inputStringDate));
        } catch (ParseException e) {
            System.err.println("Error parsing date " + e.getMessage());
            return null;
        }

        return calendar.getTime();
    }
}
