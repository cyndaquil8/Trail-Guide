package trailguide;

public class Printer {
//constructor
  public Printer() {

  }

  //slowprint variables
  final static int CHARDELAY = 50;
  final static int STRINGDELAY = 1000;
  static char[] chars;

  //clear function
  public static void clear() {
    System.out.print("\033[H\033[2J");
  }

  //prints out message, letter by letter
  public static void pr(String currentMessage) {
    chars = currentMessage.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      System.out.print(chars[i]);
      try {
        Thread.sleep(CHARDELAY);
      } catch (InterruptedException e) {
        System.out.println("Threading Error: " + e.getMessage());
      }
    }
    System.out.println("");
    try {
      Thread.sleep(STRINGDELAY);
    } catch (InterruptedException e) {
      System.out.println("Threading Error: " + e.getMessage());
    }
  }
}
