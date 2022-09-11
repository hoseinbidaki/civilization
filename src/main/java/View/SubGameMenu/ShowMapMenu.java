package View.SubGameMenu;

import Controller.GameController.MapController;
import Models.Database.GameDataBase;
import View.Menu;
import View.Regexes.MapMenuRegex;

import java.util.regex.Matcher;

public class ShowMapMenu {
    public static void run(Matcher matcher) {
        GameDataBase.getCurrentCivilization().getMap().updateExploration();
        int xPos = Integer.parseInt(matcher.group("x")),
                yPos = Integer.parseInt(matcher.group("y"));
        MapController mc = getMapController();

        String state = "mapMenu";
        while (state.equals("mapMenu"))
        {
            System.out.println(mc.showMap(xPos, yPos));
            String cmd = Menu.input();
            if (Menu.checkMatching(MapMenuRegex.back, cmd)) {
                state = "NULL";
            }
            else if (Menu.checkMatching(MapMenuRegex.move, cmd)) {
                int n = Integer.parseInt(Menu.getMatcher().group("n"));
                String d = Menu.getMatcher().group("direction");
                if (d.equals("up")) {
                    yPos -= n;
                }
                else if (d.equals("down")) {
                    yPos += n;
                }
                else if (d.equals("left")) {
                    xPos += n;
                }
                else {
                    xPos -= n;
                }
            }
            else if (Menu.checkMatching(MapMenuRegex.show_details, cmd)) {
                int x = Integer.parseInt(Menu.getMatcher().group("x"));
                int y = Integer.parseInt(Menu.getMatcher().group("y"));
                System.out.println(mc.showDetails(x, y));
            }
        }
    }
    private static MapController getMapController() {
        return new MapController(GameDataBase.getMainMap().getTerrains(),
                GameDataBase.getCurrentCivilization().getMap().getTerrainStates());
    }
}
