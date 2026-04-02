import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class RateLimiter<K> {

    private final int limit;
    private final Duration windowSize;
    private final TimeSource timeSource;

    private static class Window {
        Instant windowStart;
        int count;

        Window(Instant windowStart) {
            this.windowStart = windowStart;
            this.count = 0;
        }
    }

    private final Map<K, Window> clientMap;

    public RateLimiter(int limit, Duration windowSize, TimeSource timeSource) {
        this.limit = limit;
        this.windowSize = windowSize;
        this.timeSource = timeSource;
        this.clientMap = new HashMap<>();
    }

    public boolean allow(K clientId) {
        Instant now = timeSource.now();
        Window window = clientMap.get(clientId);

        if (window == null) {
            window = new Window(now);
            window.count = 1;
            clientMap.put(clientId, window);
            return true;
        }

        // Check if window expired
        if (!now.isBefore(window.windowStart.plus(windowSize))) {
            // Reset window
            window.windowStart = now;
            window.count = 1;
            return true;
        }

        // Same window
        if (window.count < limit) {
            window.count++;
            return true;
        }

        return false;
    }
}
