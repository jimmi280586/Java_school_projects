package starsign;

public abstract class AbstractStarSign {

  private String name;
  private DateInterval interval;

  // the following class variable is not shown in the class diagram:
  public static final String[] LEGAL_NAMES = {"Aries", "Taurus", "Gemini", "Cancer", "Leo",
      "Virgo", "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"};

  public AbstractStarSign(String name) {
    this.name = Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
    setDateInterval();
  }

  public String getName() {
    return name;
  }

  public DateInterval getInterval() {
    return interval;
  }

  public String toString() {
    return getName() + " (" + interval + ")";
  }

  private void setDateInterval() {
    // Not a fan of these if-elses...would prefer switch
    if (name.equals("Aries")) {
      interval = new DateInterval(21, 3, 19, 4);
    } else if (name.equals("Taurus")) {
      interval = new DateInterval(20, 4, 20, 5);
    } else if (name.equals("Gemini")) {
      interval = new DateInterval(21, 5, 20, 6);
    } else if (name.equals("Cancer")) {
      interval = new DateInterval(21, 6, 22, 7);
    } else if (name.equals("Leo")) {
      interval = new DateInterval(23, 7, 22, 8);
    } else if (name.equals("Virgo")) {
      interval = new DateInterval(23, 8, 22, 9);
    } else if (name.equals("Libra")) {
      interval = new DateInterval(23, 9, 22, 10);
    } else if (name.equals("Scorpio")) {
      interval = new DateInterval(22, 11, 21, 12);
    } else if (name.equals("Sagittarius")) {
      interval = new DateInterval(20, 4, 20, 5);
    } else if (name.equals("Capricorn")) {
      interval = new DateInterval(22, 12, 19, 1);
    } else if (name.equals("Aquarius")) {
      interval = new DateInterval(20, 1, 18, 2);
    } else if (name.equals("Pisces")) {
      interval = new DateInterval(19, 2, 20, 3);
    } else {
      interval = new DateInterval(0, 0, 0, 0);
    }
  }
}
