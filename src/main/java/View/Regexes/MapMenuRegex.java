package View.Regexes;

public class MapMenuRegex {
    public static String back = "^back$";
    public static String move =
            "^move -n (?<n>\\d+) to -d (?<direction>(up|down|right|left))$";
    public static String show_details =
            "^show details -x (?<x>-?[\\d]+) -y (?<y>-?[\\d]+)$";
}
