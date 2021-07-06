class Event {
  //identity variables
  String name;
  String desc;
  boolean metyet;
  String numid; //numid is defined outside of json file

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
    /*use name -> derive all vars from matching name in masterlist */
    metyet = false;
    numid = null; /*add up all numbers into numid to be parsed later*/
  }

}
  
class Stranger extends Event {
  public Stranger(String name) {
    super();
  }
  public Stranger() {
    super();
  }


}

class Location extends Event {
  public Location(String name) {
    super();
  }


}