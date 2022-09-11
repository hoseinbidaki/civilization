package View.SubGameMenu;

import Controller.GameController.GameViewController;
import Models.Database.GameDataBase;
import View.Menu;
import View.Regexes.selectSettlerMenuRegex;

import java.util.regex.Matcher;

public class SelectSettlerMenu {
    public static void run(Matcher matcher) {
        GameViewController gameViewController = GameViewController.getInstance();
        int x = Integer.parseInt(matcher.group("x"));
        int y = Integer.parseInt(matcher.group("y"));
        System.out.println(gameViewController.selectCivilianUnit(x, y));
        if (GameDataBase.getSelected() == null) {
            System.out.println("please select smt");
            return;
        }
        String state = "settlerMenu";
        while (state.equals("settlerMenu")) {
            String cmd = Menu.input();
            if (Menu.checkMatching(selectSettlerMenuRegex.back, cmd)) {
                state = "NULL";
                GameDataBase.setSelected(null);
            }
            else if (Menu.checkMatching(selectSettlerMenuRegex.Sleep, cmd)) {
                System.out.println(gameViewController.getUnitController().sleep());
            }
            else if (Menu.checkMatching(selectSettlerMenuRegex.wakeup, cmd)) {
                System.out.println(gameViewController.getUnitController().wake());
            }
            else if (Menu.checkMatching(selectSettlerMenuRegex.moveUnit, cmd)) {
                int x1 = Integer.parseInt(Menu.getMatcher().group("x")),
                        y1 = Integer.parseInt(Menu.getMatcher().group("y"));
                System.out.println(gameViewController.getUnitController().moveUnit(x1, y1));
            }
            else if (Menu.checkMatching(selectSettlerMenuRegex.skip, cmd)) {
                System.out.println(gameViewController.getUnitController().doNothing());
            }
            else if (Menu.checkMatching(selectSettlerMenuRegex.remove, cmd )) {
                System.out.println(gameViewController.getUnitController().delete());
            }
            else if (Menu.checkMatching(selectSettlerMenuRegex.found, cmd )) {
                System.out.println(gameViewController.getUnitController().foundCity());
            }
            else {
                System.out.println(gameViewController.invalidMessage());
            }
        }
    }
}
