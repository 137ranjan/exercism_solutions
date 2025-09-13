class Proverb {

    private final String[] words;

    Proverb(String[] words) {
        this.words = words == null ? new String[0] : words.clone(); // defensive copy
    }

    String recite() {
        int len = words.length;
        if (len == 0) return "";

        StringBuilder sb = new StringBuilder(len * 50); // rough estimate to avoid resizing
        for (int i = 0; i < len - 1; i++) {
            sb.append("For want of a ")
                    .append(words[i])
                    .append(" the ")
                    .append(words[i + 1])
                    .append(" was lost.\n");
        }

        sb.append("And all for the want of a ").append(words[0]).append('.');
        return sb.toString();
    }
}
