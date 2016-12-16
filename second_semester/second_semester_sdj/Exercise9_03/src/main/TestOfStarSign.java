package main;

import starsign.Person;
import starsign.StarSign;

public class TestOfStarSign {

  public static void main(String[] args) {
    String[] legalStarSignNames = StarSign.LEGAL_NAMES;

    System.out.println("Legal star sign names:");

    for (int i = 0; i < legalStarSignNames.length; i++) {
      System.out.println(legalStarSignNames[i]);
    }

    System.out.println();

    Person[] list = new Person[10];
    list[0] = new Person("Allan","Leo");
    list[1] = new Person("Bob","Scorpio");
    list[2] = new Person("Carl","Leo");
    list[3] = new Person("Dennis","Sagittarius");
    list[4] = new Person("Eric","Leo");
    list[5] = new Person("Franc","Leo");
    list[6] = new Person("Graham","Sagittarius");
    list[7] = new Person("Hans","Leo");
    list[8] = new Person("Igor","Virgo");
    list[9] = new Person("Jens", legalStarSignNames[8]);

    System.out.println("Person objects:");
    for (int i = 0; i < list.length; i++) {
      System.out.printf("%-40s %d\n", list[i], list[i].getStarSign().hashCode());
    }
    /* OUTPUT: (note hash codes could be different)
    Legal star sign names:
    Aries
    Taurus
    Gemini
    Cancer
    Leo
    Virgo
    Libra
    Scorpio
    Sagittarius
    Capricorn
    Aquarius
    Pisces

    Person objects:
    Allan, Leo (23/7 - 22/8)                 1641745
    Bob, Scorpio (22/11 - 21/12)             9023134
    Carl, Leo (23/7 - 22/8)                  19336051
    Dennis, Sagittarius (30/11 - 30/11)      6336176
    Eric, Leo (23/7 - 22/8)                  23899971
    Franc, Leo (23/7 - 22/8)                 6718604
    Graham, Sagittarius (20/4 - 20/5)        8918002
    Hans, Leo (23/7 - 22/8)                  30771886
    Igor, Virgo (23/8 - 22/9)                8637543
    Jens, Sagittarius (20/4 - 20/5)          14718739
    */
}
}

