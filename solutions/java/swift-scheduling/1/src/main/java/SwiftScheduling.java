import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;

public class SwiftScheduling {
    public static LocalDateTime convertToDeliveryDate(LocalDateTime meetingStart, String description) {
        switch (description) {
            case "NOW":
                return meetingStart.plusHours(2);
            case "ASAP":
                if (meetingStart.getHour() < 13) {
                    // same day 17:00
                    return meetingStart.withHour(17)
                            .withMinute(0)
                            .withSecond(0)
                            .withNano(0);
                } else {
                    // next day 13:00
                    return meetingStart.plusDays(1)
                            .withHour(13)
                            .withMinute(0)
                            .withSecond(0)
                            .withNano(0);
                }
            case "EOW":
                DayOfWeek dow = meetingStart.getDayOfWeek();
                if (dow == DayOfWeek.MONDAY || dow == DayOfWeek.TUESDAY || dow == DayOfWeek.WEDNESDAY) {
                    // Friday 17:00
                    LocalDate friday = meetingStart.toLocalDate()
                            .with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
                    return friday.atTime(17, 0);
                } else {
                    // Thursday or Friday -> Sunday 20:00
                    LocalDate sunday = meetingStart.toLocalDate()
                            .with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
                    return sunday.atTime(20, 0);
                }
        }

        // Variable patterns
        if (description.matches("\\d+M")) {
            int month = Integer.parseInt(description.replace("M", ""));
            return handleMonth(meetingStart, month);
        }

        if (description.matches("Q\\d+")) {
            int quarter = Integer.parseInt(description.substring(1));
            return handleQuarter(meetingStart, quarter);
        }

        throw new IllegalArgumentException("Unkown description: " + description);
    }

    private static LocalDateTime handleMonth(LocalDateTime meetingStart, int targetMonth) {
        int currentMonth = meetingStart.getMonthValue();
        int year = meetingStart.getYear();

        if (currentMonth >= targetMonth) {
            year += 1; // move to next year
        }

        YearMonth ym = YearMonth.of(year, targetMonth);
        LocalDate firstDay = ym.atDay(1);

        // Adjust to first workday (Mon-Fri)
        while (firstDay.getDayOfWeek() == DayOfWeek.SATURDAY ||
                firstDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
            firstDay = firstDay.plusDays(1);
        }
        return firstDay.atTime(8, 0);
    }

    private static LocalDateTime handleQuarter(LocalDateTime meetingStart, int targetQuarter) {
        int currentQuarter = (meetingStart.getMonthValue() - 1) / 3 + 1;
        int year = meetingStart.getYear();

        if (currentQuarter > targetQuarter) {
            year += 1; // move to next year
        }

        int endMonth = targetQuarter * 3;
        YearMonth ym = YearMonth.of(year, endMonth);
        LocalDate lastDay = ym.atEndOfMonth();

        // Adjust to last workday (Mon-Fri)
        while (lastDay.getDayOfWeek() == DayOfWeek.SATURDAY ||
                lastDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
            lastDay = lastDay.minusDays(1);
        }

        return lastDay.atTime(8, 0);
    }
}