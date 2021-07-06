class Player {
    //variables
    int depth;
    int sanity;
    int mood;
    
    //constructor
    public Player () {
      depth = 4;
      sanity = 0;
      mood = 0;
    }
  
    //return the current tiredness
    String findMood() {
      switch (mood) {
        case 0:
          return "You are beginning to feel fatigued.";
        case 1:
          return "You are very tired.";
        case 2:
          return "You can barely keep your eyes open.";
        case 3:
          return "You cannot go on any longer without rest.";
      }
      return null;
    }
  
    String findSanity() {
      switch (sanity) {
        /* for each case, have 2-3 options */
      }
      return null;
    }
  
    //return the level of depth based on number
    String findDepth() {
      switch (depth) {
        case 0:
          return "The forest is safe and warm. You walk on the trail home.";
        case 1:
          return "The forest looks familar to you.";
        case 2:
          return "The forest looks familar to you.";
        case 3:
          return "The forest is unfamiliar to you.";
        case 4:
          return "The forest is unfamiliar to you.";
        case 5:
          return "The forest is unfamiliar to you.";
        case 6:
          return "The forest cold and dark.";
        case 7:
          return "The forest cold and dark.";
        case 8:
          return "The forest cold and dark.";
        case 9:
          return "You have lost all hope. The forest is getting hungry.";
      }
      return null;
    }
  }