package View;

import Controller.GameController.GameViewController;
import View.Regexes.*;
import View.SubGameMenu.*;

public class GameView {
    public void run() {
        while (Menu.getMenu() == Menu.GAME) {
            String cmd = Menu.input();
            if (Menu.checkMatching(GameRegex.Exit, cmd)) {
                System.out.println(
                        GameViewController.getInstance().exitGameMenu());
            }
            else if (Menu.checkMatching(GameRegex.showCurrentMenu, cmd)) {
                System.out.println(
                        GameViewController.getInstance().showCurrentMenu());
            }
            else if (Menu.checkMatching(GameRegex.goToMenu, cmd)) {
                System.out.println(
                        GameViewController.getInstance().goToNextMenu());
            }
            else if (Menu.checkMatching(GameRegex.showMap, cmd)) {
                System.out.println("You are in map menu");
                ShowMapMenu.run(Menu.getMatcher());
            }
            else if (Menu.checkMatching(GameRegex.showInfo, cmd))
            {
                System.out.println("You are in info menu");
                ShowInfoMenu.run(Menu.getMatcher());
            }
            else if (Menu.checkMatching(GameRegex.selectCityByCoordinate, cmd)) {
                SelectCityMenu.run(Menu.getMatcher());
            }
            else if (Menu.checkMatching(GameRegex.selectCityByCoordinateType2, cmd)) {
                SelectCityMenu.run(Menu.getMatcher());
            }
            else if (Menu.checkMatching(GameRegex.selectMilitaryUnit, cmd)) {
                SelectMilitaryUnit.run(Menu.getMatcher());
            }
            else if (Menu.checkMatching(GameRegex.selectSettler, cmd)) {
                SelectSettlerMenu.run(Menu.getMatcher());
            }
            else if (Menu.checkMatching(GameRegex.selectWorker, cmd)) {
                SelectWorkerMenu.run(Menu.getMatcher());
            }
            else if (Menu.checkMatching(GameRegex.technologyMenu, cmd)) {
                System.out.println("you are now in technology menu");
                TechnologyMenu.run(Menu.getMatcher());
            }
            else if (Menu.checkMatching(GameRegex.cheatMenu, cmd)) {
                System.out.println("you are now in cheat menu");
                CheatMenu.run(Menu.getMatcher());
            }
            else if (Menu.checkMatching(GameRegex.nextTurn, cmd)) {
                System.out.println(
                        GameViewController.getInstance().nextTurn());
            }
            else {
                System.out.println(GameViewController.getInstance().invalidMessage());
            }
        }
    }
}