import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(appointmentDateDescription,formatter);
        return dateTime;
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return appointmentDate.isBefore(currentDateTime);
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        int hour = appointmentDate.getHour();
        return (hour >= 12 && hour < 18);
    }

    public String getDescription(LocalDateTime appointmentDate) {
        return String.format("You have an appointment on %s, %s %s, %d, at %s.",
        appointmentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH),
        appointmentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH),
        appointmentDate.getDayOfMonth(),
        appointmentDate.getYear(),
        appointmentDate.format(DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH)));
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(2023, 9, 15);
    }
}
