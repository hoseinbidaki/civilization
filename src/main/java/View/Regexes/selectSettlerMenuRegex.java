package View.Regexes;

public class selectSettlerMenuRegex {
    public static String back = "^back$";
    public static String Sleep = "^sleep unit$";
    public static String moveUnit = "^move unit to -x (?<x>-?[\\d]+) -y (?<y>-?[\\d]+)$";
    public static String wakeup = "^wake unit$";
    public static String skip = "^do nothing$";
    public static String remove = "^delete unit$";
    public static String found = "^found city$";
}
