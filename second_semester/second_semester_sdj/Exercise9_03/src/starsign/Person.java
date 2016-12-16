package starsign;

public class Person {
  private String name;
  private StarSign starSign;

  public Person(String name, String starSignName) {
    this.name = name;
    this.starSign = StarSignFactory.getStarSign(starSignName);
  }

  public String getName() {
    return name;
  }

  public StarSign getStarSign() {
    return starSign;
  }

  public String toString() {
    return name + ", " + starSign;
  }
}
