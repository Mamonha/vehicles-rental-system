package Helpers;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateHelper {

    public static Long diffInDays(LocalDateTime dataInicio, LocalDateTime dataFim) {
        return ChronoUnit.DAYS.between(dataInicio, dataFim);
    }

    public static void main(String[] args) {
        LocalDateTime dataInicio = LocalDateTime.of(2023, 6, 24, 0, 0);
        LocalDateTime dataFim = LocalDateTime.of(2024, 6, 24, 0, 0);

        Long diffDays = diffInDays(dataInicio, dataFim);
        System.out.println("Diferença em dias: " + diffDays);
    }
}
