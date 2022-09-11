package View.Regexes;

public class selectMilitaryUnitRegex {
    public static String back = "^back$";
    public static String wake = "^wake unit$";
    public static String sleep = "^sleep unit$";
    public static String do_nothing = "^do nothing$";
    public static String alert = "^alert unit$";
    public static String setup = "^setup ranged$";
    public static String delete = "^delete unit$";
    public static String move_unit =
            "^move unit to -x (?<x>-?[\\d]+) -y (?<y>-?[\\d]+)$";
    public static String fortify = "^fortify unit$";
    public static String fortify_heal = "^fortify heal$";
    public static String garrison = "^garrison unit$";
    public static String attack = "^attack -x (?<x>-?[\\d]+) -y (?<y>-?[\\d]+)$";
    public static String pillage = "^pillage$";
}
