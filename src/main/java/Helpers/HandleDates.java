package Helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class HandleDates {

    public static Long diffInDays(String dataInicio, String dataFim){

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dataInicioParsed = dateFormat.parse(dataInicio);
            Date dataFimParsed = dateFormat.parse(dataFim);

            Calendar calendarInicio = Calendar.getInstance();
            Calendar calendarFim = Calendar.getInstance();

            calendarInicio.setTime(dataInicioParsed);
            calendarFim.setTime(dataFimParsed);

            long diffInMillies = Math.abs(calendarFim.getTimeInMillis() - calendarInicio.getTimeInMillis());

            long diffDays = diffInMillies / (1000 * 60 * 60 * 24);

            return diffDays;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
