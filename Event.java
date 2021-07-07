class Event {
  //identity variables
  String name;
  String desc;

  //mod variables
  int depthmod;
  int sanitymod;
  
  //call and response variables
  /*
    variable: opening dialogue
    variable: options for interaction 1
    variable: etc
  */

  //locator variables
  int depth;
  int weather;

  //constructor
  public Event() {
    
  }

}
  
class Stranger extends Event {
  public Stranger() {
    super();
  }

}

class Location extends Event {
  public Location(String name) {
    super();
  }

}