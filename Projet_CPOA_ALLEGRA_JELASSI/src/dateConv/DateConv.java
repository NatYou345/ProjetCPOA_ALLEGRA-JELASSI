package dateConv;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateConv {
	private static final String DATE_PATTERN = "dd/MM/yyyy";
	
	private static final DateTimeFormatter DATE_FORMATTER =
			DateTimeFormatter.ofPattern(DATE_PATTERN);	
	
	public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

	public static LocalDate parse(String dateString) {
	        try {
	        	return DATE_FORMATTER.parse(dateString, LocalDate::from);
	        } catch (DateTimeParseException e) {
	            return null;
	        }

	}
	public static boolean validDate(String dateString) {
    	// Try to parse the String.
    	return DateConv.parse(dateString) != null;
    }
	
	
	
	
	public static Date asDate(LocalDate localDate) {
	    return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	  }

	  public static Date asDate(LocalDateTime localDateTime) {
	    return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	  }

	  public static LocalDate asLocalDate(Date date) {
	    return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	  }

	  public static LocalDateTime asLocalDateTime(Date date) {
	    return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	  }
}
