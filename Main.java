class Main {
  public static void main(String[] args) {
    Forest f = new Forest();
    Printer.clear();
    Translator.loadStrangerInfo();
    while (f.v.depth != 11) {
      //new day: stuff that only happens once
      Printer.printMessage("You have been lost in the forest for " + f.day + " days.");
      Printer.printMessage("--- --- ---");
      //depth update
      Printer.printMessage(f.v.findDepth());
      //start walking here
      for (int i = 0; i < 4; i++) {
        f.showStatus();
        if (f.event == 1) {
          f.eventStranger();
        } else if (f.event == 2) {
          //f.eventLocation();
        } else if (f.event == 0) {
          f.justWalk();
        }
        //after everything else is done, increase the time
        if (f.time != 3) {
          f.time++;
        } else {
          f.time = 0;
          f.day++;
        }
      }
      Printer.clear();
    }
  }
}