class ResistorColorTrio {
    String label(String[] colors) {
        int firstDigit = colorValueMapping(colors[0]);
        int secondDigit = colorValueMapping(colors[1]);
        int numOfZeroes = colorValueMapping(colors[2]);
        if (secondDigit == 0) {
            numOfZeroes++;
        }
        String suffix = suffix(numOfZeroes);

        if (secondDigit == 0) {
            if(firstDigit == 0){
                return suffix + "ohms";
            }
            return firstDigit + suffix + "ohms";
        } else {
            return firstDigit*10 + secondDigit + suffix + "ohms";
        }
    }

    private int colorValueMapping(String color) {
        return switch (color) {
            case "black" -> 0;
            case "brown" -> 1;
            case "red" -> 2;
            case "orange" -> 3;
            case "yellow" -> 4;
            case "green" -> 5;
            case "blue" -> 6;
            case "violet" -> 7;
            case "grey" -> 8;
            case "white" -> 9;
            default -> -1;
        };
    }

    private String suffix(int numOfZeroes) {
        return switch (numOfZeroes) {
            case 1 -> "0 ";
            case 2 -> "00 ";
            case 3 -> " kilo";
            case 4 -> "0 kilo";
            case 5 -> "00 kilo";
            case 6 -> " mega";
            case 7 -> "0 mega";
            case 8 -> "00 mega";
            case 9 -> " giga";
            default -> " ";
        };
    }
}
