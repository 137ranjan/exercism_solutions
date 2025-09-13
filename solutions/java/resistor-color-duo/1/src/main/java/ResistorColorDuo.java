class ResistorColorDuo {
    int value(String[] colors) {
        int firstDigit = colorValueMapping(colors[0]);
        int secondDigit = colorValueMapping(colors[1]);
        return firstDigit*10 + secondDigit;
    }

    private int colorValueMapping(String color){
        switch(color){
            case "black": return 0;
            case "brown": return 1;
            case "red": return 2;
            case "orange": return 3;
            case "yellow": return 4;
            case "green": return 5;
            case "blue": return 6;
            case "violet": return 7;
            case "grey": return 8;
            case "white": return 9;
            default: return -1;
        }
    }
}
