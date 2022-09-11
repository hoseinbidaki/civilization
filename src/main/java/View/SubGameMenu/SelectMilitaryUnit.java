package View.SubGameMenu;

import Controller.GameController.GameViewController;
import Models.Database.GameDataBase;
import View.Menu;
import View.Regexes.selectMilitaryUnitRegex;

import java.util.regex.Matcher;

public class SelectMilitaryUnit {
    public static void run(Matcher matcher) {
        GameViewController gameViewController = GameViewController.getInstance();
        int x = Integer.parseInt(matcher.group("x"));
        int y = Integer.parseInt(matcher.group("y"));
        System.out.println(gameViewController.selectMilitaryUnit(x, y));
        if (GameDataBase.getSelected() == null) {
            System.out.println("please select smt");
            return;
        }
        String state = "militaryMenu";
        while (state.equals("militaryMenu"))
        {
            String cmd = Menu.input();
            if (Menu.checkMatching(selectMilitaryUnitRegex.back, cmd))
            {
                state = "NULL";
            }
            else if (Menu.checkMatching(selectMilitaryUnitRegex.wake, cmd)) {
                System.out.println(gameViewController.getUnitController().wake());
            }
            else if (Menu.checkMatching(selectMilitaryUnitRegex.sleep, cmd)) {
                System.out.println(gameViewController.getUnitController().sleep());
            }
            else if (Menu.checkMatching(selectMilitaryUnitRegex.setup, cmd)) {
                System.out.println(gameViewController.getUnitController().setUp());
            }
            else if (Menu.checkMatching(selectMilitaryUnitRegex.delete, cmd)) {
                System.out.println(gameViewController.getUnitController().delete());
            }
            else if (Menu.checkMatching(selectMilitaryUnitRegex.move_unit, cmd)) {
                int x1 = Integer.parseInt(Menu.getMatcher().group("x")),
                        y1 = Integer.parseInt(Menu.getMatcher().group("y"));
                System.out.println(gameViewController.
                        getUnitController().moveUnit(x1, y1));
            }
            else if (Menu.checkMatching(selectMilitaryUnitRegex.fortify, cmd)) {
                System.out.println(gameViewController.getUnitController().fortify());
            }
            else if (Menu.checkMatching(selectMilitaryUnitRegex.fortify_heal, cmd)) {
                System.out.println(gameViewController.getUnitController().fortifyHeal());
            }
            else if (Menu.checkMatching(selectMilitaryUnitRegex.alert, cmd)) {
                System.out.println(gameViewController.getUnitController().alert());
            }
            else if (Menu.checkMatching(selectMilitaryUnitRegex.garrison, cmd)) {
                System.out.println(gameViewController.getUnitController().garrison());
            }
            else if (Menu.checkMatching(selectMilitaryUnitRegex.attack, cmd)) {
                System.out.println(gameViewController.getUnitController().militaryAttack());
            }
            else if (Menu.checkMatching(selectMilitaryUnitRegex.pillage, cmd)) {
                System.out.println(gameViewController.getUnitController().pillage());
            }
            else if (Menu.checkMatching(selectMilitaryUnitRegex.do_nothing, cmd)) {
                System.out.println(gameViewController.getUnitController().doNothing());
            }
            else {
                System.out.println(gameViewController.invalidMessage());
            }
        }
    }
}
