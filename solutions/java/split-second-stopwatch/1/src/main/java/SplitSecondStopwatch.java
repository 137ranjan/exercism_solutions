import java.util.ArrayList;
import java.util.List;

public class SplitSecondStopwatch {

    private enum State {READY, RUNNING, STOPPED}

    private State state;
    private long currentLapMillis;
    private long totalMillis;
    private final List<Long> previousLaps;

    public SplitSecondStopwatch() {
        state = State.READY;
        currentLapMillis = 0;
        totalMillis = 0;
        previousLaps = new ArrayList<>();
    }

    public void start() {
        if (state == State.RUNNING) {
            throw new IllegalStateException("cannot start an already running stopwatch");
        }
        if (state == State.READY || state == State.STOPPED) {
            state = State.RUNNING;
        }
    }

    public void stop() {
        if (state != State.RUNNING) {
            throw new IllegalStateException("cannot stop a stopwatch that is not running");
        }
        state = State.STOPPED;
    }

    public void reset() {
        if (state != State.STOPPED) {
            throw new IllegalStateException("cannot reset a stopwatch that is not stopped");
        }
        state = State.READY;
        currentLapMillis = 0;
        totalMillis = 0;
        previousLaps.clear();
    }

    public void lap() {
        if (state != State.RUNNING) {
            throw new IllegalStateException("cannot lap a stopwatch that is not running");
        }
        previousLaps.add(currentLapMillis);
        currentLapMillis = 0;
    }

    public String state() {
        return state.name().toLowerCase();
    }

    public String currentLap() {
        return formatTime(currentLapMillis);
    }

    public String total() {
        return formatTime(totalMillis);
    }

    public java.util.List<String> previousLaps() {
        List<String> laps = new ArrayList<>();
        for (Long lap : previousLaps) {
            laps.add(formatTime(lap));
        }
        return laps;
    }

    public void advanceTime(String timeString) {
        if (state == State.RUNNING) {
            long millis = parseTime(timeString);
            currentLapMillis += millis;
            totalMillis += millis;
        }
    }

    // --- Helpers ---
    private long parseTime(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        return (h * 3600L + m * 60L + s) * 1000L;
    }

    private String formatTime(long millis) {
        long totalSeconds = millis / 1000;
        long hours = totalSeconds / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}