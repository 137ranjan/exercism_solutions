class Scrabble {
    private String word;
    
    Scrabble(String word) {
        this.word = word;
    }

    int getScore() {
        int totalScore = 0;
        for(int i=0; i<word.length(); i++){
            totalScore += letterScore(word.charAt(i));
        }
        return totalScore;
    }

    private int letterScore(char letter){
        
        switch(letter){
            case 'A', 'E', 'I','O', 'U', 'L', 'N', 'R', 'S', 'T', 'a', 'e', 'i','o', 'u', 'l', 'n', 'r', 's', 't': return 1;
            case 'D', 'G', 'd', 'g': return 2;
            case 'B', 'C', 'M', 'P','b', 'c', 'm', 'p': return 3;
            case 'F', 'H', 'V', 'W', 'Y','f', 'h', 'v', 'w', 'y': return 4;
            case 'K', 'k': return 5;
            case 'J', 'X', 'j', 'x': return 8;
            case 'Q', 'Z','q', 'z': return 10;
        }

        return 0;
    }

}
