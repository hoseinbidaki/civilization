package View.SubGameMenu;

import Controller.GameController.GameViewController;
import Models.Civilization.Civilization;
import Models.Database.GameDataBase;
import View.Menu;
import View.Regexes.InfoGameRegex;

import java.util.regex.Matcher;

public class ShowInfoMenu {
    public static void run(Matcher matcher) {
        GameViewController gameViewController = GameViewController.getInstance();
        Civilization current = getCurrentCivilization(); current.updateData();
        System.out.println("info menu"); System.out.println(current.getInformation());

        String State = "Info";
        while (State.equals("Info")) {
            String cmd = Menu.input();
            if (Menu.checkMatching(InfoGameRegex.back, cmd)) {
                State = "NULL";
            }
            else if (Menu.checkMatching(InfoGameRegex.show_units, cmd))
            {
                System.out.println(gameViewController.getInfoController().showUnits());
            }
            else if (Menu.checkMatching(InfoGameRegex.show_city, cmd))
            {
                System.out.println(gameViewController.getInfoController().showCities());
            }
            else if (Menu.checkMatching(InfoGameRegex.show_reshearch_info, cmd))
            {
                System.out.println(gameViewController.getInfoController().showResearch());
            }
            else if (Menu.checkMatching(InfoGameRegex.show_deals, cmd))
            {
                System.out.println(gameViewController.getInfoController().showDeals());
            }
            else if (Menu.checkMatching(InfoGameRegex.show_victory_info, cmd))
            {
                System.out.println(gameViewController.getInfoController().showVictory());
            }
            else if (Menu.checkMatching(InfoGameRegex.show_diplomacy_info, cmd))
            {
                System.out.println(gameViewController.getInfoController().showDiplomacy());
            }
            else if (Menu.checkMatching(InfoGameRegex.show_demographic_info, cmd))
            {
                System.out.println(gameViewController.getInfoController().showDemographics());
            }
            else if (Menu.checkMatching(InfoGameRegex.show_notification, cmd))
            {
                System.out.println(gameViewController.getInfoController().showNotification());
            }
            else if (Menu.checkMatching(InfoGameRegex.reset_notifications, cmd))
            {
                System.out.println(gameViewController.getInfoController().resetNotification());

            }
            else if (Menu.checkMatching(InfoGameRegex.show_economic_info, cmd))
            {
                System.out.println(gameViewController.getInfoController().showEconomy());
            }
            else if (Menu.checkMatching(InfoGameRegex.show_diplomatic_info, cmd))
            {
                System.out.println(gameViewController.getInfoController().showDiplomatics());
            }
            else if (Menu.checkMatching(InfoGameRegex.show_military_info, cmd))
            {
                System.out.println(gameViewController.getInfoController().showMilitary());
            }
            else {
                System.out.println(gameViewController.invalidMessage());
            }
        }
    }

    private static Civilization getCurrentCivilization() {
        return GameDataBase.getCurrentCivilization();
    }
}
