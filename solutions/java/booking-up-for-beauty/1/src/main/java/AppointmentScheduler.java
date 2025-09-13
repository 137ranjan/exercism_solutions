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
        DayOfWeek dayOfWeek = appointmentDate.getDayOfWeek();
        String dayString = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        
        Month month = appointmentDate.getMonth();
        String monthString = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        int dayOfMonth = appointmentDate.getDayOfMonth();

        int year = appointmentDate.getYear();

        int hour = appointmentDate.getHour();

        int minute = appointmentDate.getMinute();
        String amPm = "";
        if(hour >= 12){
            amPm = "PM";
            hour = hour - 12;
        }else{
            amPm = "AM";
        }

        String minutePrecedingZero = "";
        if(minute < 10){
            minutePrecedingZero = "0";
        }

        String description = "You have an appointment on "+dayString+", "+monthString+" "+dayOfMonth+", "+year+", at "+hour+":"+minutePrecedingZero+minute+" "+amPm+".";

        return description;
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(2023, 9, 15);
    }
}
