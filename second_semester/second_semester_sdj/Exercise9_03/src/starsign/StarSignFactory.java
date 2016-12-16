package starsign;

import java.util.HashMap;

public class StarSignFactory {

  private static HashMap<String, StarSign> starSigns = new HashMap<String, StarSign>();

  private StarSignFactory() {}

  public static StarSign getStarSign(String name) {
    StarSign sign = starSigns.get(name);

    if (sign == null) {
      sign = new StarSign(name);
      starSigns.put(name, sign);
    }

    return sign;
  }

}
