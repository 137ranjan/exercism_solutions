import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
    private LocalDateTime moment;
    public Gigasecond(LocalDate moment) {
        this.moment = moment.atStartOfDay();
    }

    public Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    public LocalDateTime getDateTime() {
        return moment.plusSeconds(1000000000);
    }
}
