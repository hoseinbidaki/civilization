package View.Regexes;

public class GameRegex {
    public static String Exit = "^menu exit$";
    public static String showCurrentMenu = "^menu show-current$";
    public static String goToMenu = "(menu){1}(\\s+)(enter){1}(\\s+)([a-zA-Z ]+)";
    public static String showMap = "^show map -x (?<x>-?[\\d]+) -y (?<y>-?[\\d]+)$";
    public static String showInfo = "^show info$";
    public static String selectCityByCoordinate =
            "^select city -x (?<x>-?[\\d]+) -y (?<y>-?[\\d]+)$";
    public static String selectCityByCoordinateType2 =
            "^select city -y (?<y>-?[\\d]+) -x (?<x>-?[\\d]+)$";
    public static String selectMilitaryUnit =
            "^select military unit -x (?<x>-?[\\d]+) -y (?<y>-?[\\d]+)$";
    public static String selectSettler =
            "^select settler -x (?<x>-?[\\d]+) -y (?<y>-?[\\d]+)$";
    public static String technologyMenu = "^technology menu$";
    public static String cheatMenu = "^cheat menu$";
    public static String selectWorker = "^select worker -x (?<x>-?[\\d]+) -y (?<y>-?[\\d]+)$";
    public static String nextTurn = "^next turn$";

}
