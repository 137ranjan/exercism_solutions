class ReverseString {

    String reverse(String inputString) {
        char[] arr = inputString.toCharArray();
        String reversed = "";
        for(int i = arr.length - 1; i >= 0; i--)
            reversed += arr[i];
        return reversed;
    }
  
}
