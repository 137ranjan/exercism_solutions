public class LogLine {

    private String logLine;
    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {
        if(logLine.contains("INF")){
            return LogLevel.INFO;
        }else if(logLine.contains("DBG")){
            return LogLevel.DEBUG;
        }
        else if(logLine.contains("TRC")){
            return LogLevel.TRACE;
        }else if(logLine.contains("WRN")){
            return LogLevel.WARNING;
        }
        else if(logLine.contains("ERR")){
            return LogLevel.ERROR;
        }else if(logLine.contains("FTL")){
            return LogLevel.FATAL;
        }else{
            return LogLevel.UNKNOWN;
        }
        //throw new UnsupportedOperationException("Please implement the getLogLevel() method");
    }

    public String getOutputForShortLog() {
        LogLevel logLevel = getLogLevel();
        switch(logLevel){
            case UNKNOWN: return logLine.replaceAll("\\[(.*?)\\]: ","0:");
            case TRACE: return logLine.replace("[TRC]: ","1:");
            case DEBUG : return logLine.replace("[DBG]: ","2:");
            case INFO : return logLine.replace("[INF]: ","4:");
            case WARNING : return logLine.replace("[WRN]: ","5:");
            case ERROR : return logLine.replace("[ERR]: ","6:");
            case FATAL : return logLine.replace("[FTL]: ","42:");
            default: 
                return logLine;
                
        }
        // throw new UnsupportedOperationException("Please implement the getOutputForShortLog() method");
    }
}
