public class Main {
  public static void main(String[] args) {
    String input = "wwwaaadbbeqqvvvvxxxx";
    String encoded = encode(input);
    System.out.printf("Encoded: %s%n", encoded);
    String decoded = decode(encoded);
    System.out.printf("Decoded: %s%n", decoded);
  }

  public static String encode(String input) {
    StringBuilder encodedString = new StringBuilder();
    int count = 1;
    for (int i = 1; i < input.length(); i++) {
      if (input.charAt(i) == input.charAt(i - 1)) {
        count++;
      } else {
        encodedString.append(count);
        encodedString.append(input.charAt(i - 1));
        count = 1;
      }
    }
    encodedString.append(count);
    encodedString.append(input.charAt(input.length() - 1));
    return encodedString.toString();
  }

  public static String decode(String input) {
    StringBuilder decodedString = new StringBuilder();
    int count = 0;
    for (int i = 0; i < input.length(); i++) {
      if (Character.isDigit(input.charAt(i))) {
        count = count * 10 + input.charAt(i) - '0';
      } else {
        for (int j = 0; j < count; j++) {
          decodedString.append(input.charAt(i));
        }
        count = 0;
      }
    }
    return decodedString.toString();
  }
}