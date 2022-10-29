import java.util.*;

class Forest {
  //objects
  Player v = new Player();
  Stranger activeStranger = null;
  Location activeLocation = null;
  Random r = new Random();

  //scanner variables
  Scanner scan = new Scanner(System.in);
  char charin;
  int intin;

  //variables
  int day;
  int time;
  int weather;
  int event;

  //constructor
  public Forest() {
    day = 3;
    time = 0;
    weather = 0;
    event = 0;
  }

  //happens once for every time of day
  void showStatus() {
    //time + weather update
    if (v.depth <= 5) {
      Printer.printMessage("It is currently " + findTime() + " " + findWeather());
    } else {
      if (weather != 0) {
        Printer.printMessage("You cannot tell the time of day anymore." + " " + findWeather());
      }
    }
    //sanity update
    /* 
      if (sanity is less than x) do 1
      if (sanity is between x and y) do 2
      if (sanity is greater than y) do 3
    */
  }

  //prompt for when there is no stranger or location
  void justWalk() {
    //to do when it is nighttime only
    if (time == 3) {
      //show player level of exhaustion
      Printer.printMessage(v.findMood());
      //ask to rest
      Printer.printMessage("\n (1) Keep walking. \n (2) Rest here.");
      intin = scan.nextInt();
      switch (intin) {
        //keep walking, increase exhaustion, create the next room
        case 1:
          Printer.printMessage("You keep walking.");
          v.mood++;
          event = genNewRoom();
          break;
        //reset exhaustion, don't create a new room b/c the player stays still
        case 2:
          Printer.printMessage("You decide to stop here for the night.");
          v.mood = 0;
          event = 0;
          break;
      }
    //to do when it is not nighttime
    } else {
      Printer.printMessage("\n (1) Keep walking.");
      intin = scan.nextInt();
      Printer.printMessage("You keep walking.");
      //no event is generated during night to avoid errors with pre-existing nighttime code
      if (time != 2) {
        event = genNewRoom();
      } else {
        event = 0;
      }
    }
  }

  void eventStranger() {
    Printer.printMessage("Ahead of you, you see " + activeStranger.desc);
    Printer.printMessage("\n (1) Approach the stranger \n (2) Avoid the stranger");
    intin = scan.nextInt();
    switch (intin) {
      case 1:
        Printer.printMessage("NOCODEYETLMAO");
        break;
      case 2:
        Printer.printMessage("You give the stranger a wide berth. Best to keep to yourself today.");
        if (time != 2) {
          event = genNewRoom();
        } else {
          event = 0;
        }
        break;
    }
  }

  //decide what happens next
  int genNewRoom() {
    activeStranger = null;
    activeLocation = null;
    int chance = r.nextInt(4);
    //20% to encounter a stranger
    if (chance < 2) {
      activeStranger = newStranger();
      return 1;
    //impossible for now - will be 20% when locations exist
    } else if (chance > 200) {
      activeLocation = newLocation();
      return 2;
    } else {
      //60% chance to continue unhindered
      return 0;
    }
  }

  Stranger newStranger() {
    boolean k = false;
    //create an empty stranger to be filled
    Stranger c = new Stranger();
    while (k == false) {
      c = Translator.strangerdata.get(r.nextInt(Translator.strangerdata.size()));
      if (c.depth == v.depth && c.weather == weather) {
        k = true;
      }
    }
    return c;
  }

  Location newLocation() {
    Location c;
    //below is temp
    c = new Location("The Waterfall");
    //same as newstranger but w location
    return c;
  }

  //return the weather
  String findWeather() {
    switch (weather) {
      case 0:
        return "The sky is clear.";
      case 1:
        return "Rain pours down all around you.";
      case 2:
        return "A thick fog creeps through the forest.";
    }
    return null;
  }

  //return the time of day based on number
  String findTime() {
    switch (time) {
      case 0:
        return "morning.";
      case 1:
        return "noon.";
      case 2:
        return "evening.";
      case 3:
        return "night.";
    }
    return null;
  }

  
}