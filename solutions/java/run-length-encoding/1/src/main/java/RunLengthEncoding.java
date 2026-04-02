class RunLengthEncoding {

    String encode(String data) {
        if (data == null || data.isEmpty()) {
            return "";
        }
        StringBuilder encoded = new StringBuilder();
        char previous = data.charAt(0);
        int count = 1;
        for (int i = 1; i < data.length(); i++) {
            char curr = data.charAt(i);
            if (isAlphabetOrSpace(curr)) {
                if (curr == previous) {
                    count++;
                } else {
                    if (count == 1) {
                        encoded.append(previous);
                        previous = curr;
                    } else {
                        encoded.append(count).append(previous);
                        previous = curr;
                        count = 1;
                    }
                }
            }
        }

        if (count == 1) {
            encoded.append(previous);
        } else {
            encoded.append(count).append(previous);
        }

        return encoded.toString();
    }

    String decode(String data) {
        if (data == null || data.isEmpty()) {
            return "";
        }
        StringBuilder decoded = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            char curr = data.charAt(i);
            if (isAlphabetOrSpace(curr)) {
                decoded.append(curr);
            } else {
                StringBuilder numString = new StringBuilder();

                while (!isAlphabetOrSpace(curr)) {
                    numString.append(curr);
                    i++;
                    curr = data.charAt(i);
                }
                int count = Integer.parseInt(numString.toString());
                char ch = curr;
                decoded.repeat(ch, count);
            }
        }

        return decoded.toString();
    }

    private boolean isAlphabetOrSpace(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || ch == ' ';
    }

}