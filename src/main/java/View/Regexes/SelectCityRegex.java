package View.Regexes;

public class SelectCityRegex {
    public static String back = "^back$";
    public static String showCityInfo = "^show city info$";
    public static String deleteCity = "^delete city$";
    public static String moveCitizen =
            "^move citizen -x (?<x1>-?\\d+) -y (?<y1>-?\\d+) to -x (?<x2>-?\\d+) -y (?<y2>-?\\d+)$";
    public static String setCitizen =
            "^set citizen to -x (?<x>-?\\d+) -y (?<y>-?\\d+)$";
    public static String removeCitizen =
            "^remove citizen -x (?<x>-?\\d+) -y (?<y>-?\\d+)$";
    public static String buyTile =
            "^buy terrain -x (?<x>-?\\d+) -y (?<y>-?\\d+)$";
    public static String attack =
            "^attack (--coordinates|-c) -x (?<x>-?[\\d]+) -y (?<y>-?[\\d]+)$";
    public static String build_menu = "^build menu$";


//    Build Menu
    public static String buildBuilding = "^build building -n (?<n>\\d+)$";
    public static String buildUnit = "^build unit -n (?<n>\\d+)$";
    public static String buildBuildingGold = "^build building with gold -n (?<n>\\d+)$";
    public static String buildUnitGold = "^build unit with gold -n (?<n>\\d+)$";;
}
