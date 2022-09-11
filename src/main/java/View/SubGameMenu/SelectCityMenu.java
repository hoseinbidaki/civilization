package View.SubGameMenu;

import Controller.GameController.GameViewController;
import View.Menu;
import View.Regexes.SelectCityRegex;

import java.util.regex.Matcher;

public class SelectCityMenu {

    public static void run(Matcher matcher) {
        GameViewController gameViewController = GameViewController.getInstance();
        int x = Integer.parseInt(matcher.group("x")),
                y = Integer.parseInt(matcher.group("y"));
        System.out.println(gameViewController.selectCityByPosition(x, y));
        String state = "selectCity";
        while (state.equals("selectCity"))
        {
            String cmd = Menu.input();
            if (Menu.checkMatching(SelectCityRegex.back, cmd))
            {
                state = "NULL";
                System.out.println("you are taken to game menu");
            }
            else if (Menu.checkMatching(SelectCityRegex.showCityInfo, cmd))
            {
                System.out.println(gameViewController.getCityController().showCityInfo());
            }
            else if (Menu.checkMatching(SelectCityRegex.build_menu, cmd))
            {
                buildMenu(Menu.getMatcher());
            }
            else if (Menu.checkMatching(SelectCityRegex.deleteCity, cmd))
            {
                System.out.println(gameViewController.getCityController().delete());
                state = "deleted";
            }
            else if (Menu.checkMatching(SelectCityRegex.moveCitizen, cmd))
            {
                int x1 = Integer.parseInt(Menu.getMatcher().group("x1")),
                        y1 = Integer.parseInt(Menu.getMatcher().group("y1")),
                        x2 = Integer.parseInt(Menu.getMatcher().group("x2")),
                        y2 = Integer.parseInt(Menu.getMatcher().group("y2"));
                System.out.println(
                        gameViewController.getCityController().moveCitizen(x1, y1, x2, y2));
            }
            else if (Menu.checkMatching(SelectCityRegex.setCitizen, cmd))
            {
                int x1 = Integer.parseInt(Menu.getMatcher().group("x")),
                        y1 = Integer.parseInt(Menu.getMatcher().group("y"));
                System.out.println(gameViewController.getCityController().setCitizen(x1, y1));
            }
            else if (Menu.checkMatching(SelectCityRegex.removeCitizen, cmd))
            {
                int x1 = Integer.parseInt(Menu.getMatcher().group("x")),
                        y1 = Integer.parseInt(Menu.getMatcher().group("y"));
                System.out.println(
                        gameViewController.getCityController().removeCitizen(x1, y1));
            }
            else if (Menu.checkMatching(SelectCityRegex.buyTile, cmd))
            {
                int x1 = Integer.parseInt(Menu.getMatcher().group("x")),
                        y1 = Integer.parseInt(Menu.getMatcher().group("y"));
                System.out.println(gameViewController.getCityController().buyTerrain(x1, y1));
            }
            else if (Menu.checkMatching(SelectCityRegex.attack, cmd))
            {
                int x1 = Integer.parseInt(Menu.getMatcher().group("x")),
                        y1 = Integer.parseInt(Menu.getMatcher().group("y"));
                System.out.println(gameViewController.getCityController().attack(x1, y1));
            }
            else {
                System.out.println(gameViewController.invalidMessage());
            }
        }
    }
    private static void buildMenu(Matcher matcher) {
        GameViewController gameViewController = GameViewController.getInstance();

        System.out.println("you can select a building or unit");

        System.out.println("list of buildings: ");
        System.out.println(gameViewController.getCityController().showBuildings());

        System.out.println("list of units: ");
        System.out.println(gameViewController.getCityController().showUnits());

        String state = "buildMenu";
        while (state.equals("buildMenu"))
        {
            String cmd = Menu.input();
            if (Menu.checkMatching(SelectCityRegex.back, cmd))
            {
                state = "NULL";
                System.out.println("you are taken to previous menu");
            }
            else if (Menu.checkMatching(SelectCityRegex.buildBuilding, cmd))
            {
                int n = Integer.parseInt(Menu.getMatcher().group("n"));
                System.out.println(gameViewController.getCityController().buildBuilding(n));
            }
            else if (Menu.checkMatching(SelectCityRegex.buildUnit, cmd))
            {
                int n = Integer.parseInt(Menu.getMatcher().group("n"));
                System.out.println(gameViewController.getCityController().buildUnit(n));

            }
            else if (Menu.checkMatching(SelectCityRegex.buildBuildingGold, cmd))
            {
                int n = Integer.parseInt(Menu.getMatcher().group("n"));
                System.out.println(gameViewController.getCityController().buildBuildingWithGold(n));
            }
            else if (Menu.checkMatching(SelectCityRegex.buildUnitGold, cmd))
            {
                int n = Integer.parseInt(Menu.getMatcher().group("n"));
                System.out.println(gameViewController.getCityController().buildUnitWithGold(n));
            }
            else
            {

                System.out.println(gameViewController.invalidMessage());
            }
        }
    }
}
