import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Ledger {
    public enum Currency {
        USD("$"), EUR("€");
        final String symbol;
        Currency(String symbol) {
            this.symbol = symbol;
        }
        static Currency from(String s){
            return s.equals("USD") ? USD : EUR;
        }
    }
    public enum LocaleType {
        US("en-US"), NL("nl-NL");
        final String code;
        LocaleType(String code) {
            this.code = code;
        }
        static LocaleType from(String s){
            return s.equals("en-US") ? US : NL;
        }
    }
    private static final Map<LocaleType, String> HEADERS = Map.of(
            LocaleType.US, "Date       | Description               | Change       ",
            LocaleType.NL, "Datum      | Omschrijving              | Verandering  "
    );
    private static final Map<LocaleType, String> DATE_PATTERNS = Map.of(
            LocaleType.US, "MM/dd/yyyy",
            LocaleType.NL, "dd/MM/yyyy"
    );
    private static final Map<LocaleType, String> DECIMAL_SEP = Map.of(
            LocaleType.US, ".",
            LocaleType.NL, ","
    );
    private static final Map<LocaleType, String> THOUSAND_SEP = Map.of(
            LocaleType.US, ",",
            LocaleType.NL, "."
    );
    public LedgerEntry createLedgerEntry(String d, String desc, int c) {
        LedgerEntry le = new LedgerEntry();
        le.setChange(c);
        le.setDescription(desc);
        le.setLocalDate(LocalDate.parse(d));
        return le;
    }

    public String format(String cur, String loc, LedgerEntry[] entries) {
        Currency currency = Currency.from(cur);
        LocaleType locale = LocaleType.from(loc);

        StringBuilder sb = new StringBuilder();
        sb.append(HEADERS.get(locale));

        if (entries.length == 0) {
            return sb.toString();
        }

        List<LedgerEntry> sorted = sortEntries(entries);

        for (LedgerEntry entry : sorted){
            sb.append("\n");
            sb.append(formatEntry(entry, currency, locale));
        }
        return sb.toString();
    }

    private String formatEntry(LedgerEntry entry, Currency currency, LocaleType locale) {
        String date = entry.getLocalDate().format(DateTimeFormatter.ofPattern(DATE_PATTERNS.get(locale)));
        String desc = entry.getDescription();
        if (desc.length() > 25) {
            desc = desc.substring(0, 22) + "...";
        }
        String amount = formatAmount(entry.getChange(), currency, locale);
        return String.format("%s | %-25s | %13s", date, desc, amount);
    }

    private String formatAmount(double change, Currency currency, LocaleType locale) {
        boolean negative = change < 0;
        double absChange = Math.abs(change) / 100.0;
        String formatted = String.format("%.2f", absChange);
        String[] parts = formatted.split("\\.");
        String integerPart = addThousandSep(parts[0], THOUSAND_SEP.get(locale));
        String decPart = parts[1];
        String amount = integerPart + DECIMAL_SEP.get(locale) + decPart;

        if (locale == LocaleType.NL) {
            amount = currency.symbol + " " + amount;
            if (negative) {
                amount = currency.symbol + " -" + amount.replace(currency.symbol, "").trim() + " ";
            } else {
                amount = " " + amount + " ";
            }
        } else {
            amount = currency.symbol + amount;
            if (negative) {
                amount = "(" + amount + ")";
            } else {
                amount = amount + " ";
            }
        }
        return amount;
    }

    private String addThousandSep(String digits, String sep) {
        StringBuilder sb = new StringBuilder();
        int len = digits.length();
        for( int i=0; i< len; i++){
            if(i > 0 && (len - i)%3 == 0){
                sb.append(sep);
            }
            sb.append(digits.charAt(i));
        }
        return sb.toString();
    }

    private List<LedgerEntry> sortEntries(LedgerEntry[] entries) {
        List<LedgerEntry> list = new ArrayList<>(Arrays.asList(entries));
        list.sort(Comparator
                .comparing(LedgerEntry::getLocalDate)
                .thenComparing(LedgerEntry::getDescription)
                .thenComparing(LedgerEntry::getChange));
        return list;
    }

    public static class LedgerEntry {
        LocalDate localDate;
        String description;
        double change;

        public LocalDate getLocalDate() {
            return localDate;
        }

        public void setLocalDate(LocalDate localDate) {
            this.localDate = localDate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getChange() {
            return change;
        }

        public void setChange(double change) {
            this.change = change;
        }
    }

}
