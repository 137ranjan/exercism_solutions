public class LogLevels {
    
    public static String message(String logLine) {
        int startIndex = logLine.indexOf(":") + 1;
        String message = logLine.substring(startIndex, logLine.length());
        return message.trim();
    }

    public static String logLevel(String logLine) {
        int startIndex = logLine.indexOf("[") + 1;
        int endIndex = logLine.indexOf("]");
        String logLevel = logLine.substring(startIndex,endIndex);
        return logLevel.toLowerCase();
    }

    public static String reformat(String logLine) {
        String logLevel = logLevel(logLine);
        String message = message(logLine);
        String reformatted = message+" ("+logLevel+")";
        return reformatted;
    }
}
