package View.Regexes;

public class CheatRegex {

    public static String back = "^back$";

    public static String increase_gold = "^increase gold -n (?<n>\\d+)$";
    public static String increase_turn = "^increase turn -n (?<n>\\d+)$";
    public static String incrase_happiness = "^increase happiness -n (?<n>\\d+)$";
    public static String increase_science = "^increase science -n (?<n>\\d+)$";
    public static String set_archer = "^set archer to -x (?<x>-?\\d+) -y (?<y>-?\\d+)$";
    public static String set_settler = "^set settler to -x (?<x>-?\\d+) -y (?<y>-?\\d+)$";
    public static String set_lancer = "^set lancer to -x (?<x>-?\\d+) -y (?<y>-?\\d+)$";
    public static String set_cannon = "^set cannon to -x (?<x>-?\\d+) -y (?<y>-?\\d+)$";
    public static String set_tank = "^set tank to -x (?<x>-?\\d+) -y (?<y>-?\\d+)$";
    public static String set_artilery = "^set artillery to -x (?<x>-?\\d+) -y (?<y>-?\\d+)$";
    public static String reset_unit = "^reset unit$";
    public static String open_allTechnology = "^open all technology$";
}
