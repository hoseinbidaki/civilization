package View.SubGameMenu;

import Controller.GameController.GameViewController;
import View.Menu;
import View.Regexes.TechnologyRegex;

import java.util.regex.Matcher;

public class TechnologyMenu {
    public static void run(Matcher matcher) {
        GameViewController gameViewController = GameViewController.getInstance();
        System.out.println(gameViewController.
                getTechnologyMenuController().showTechnologies());

        String state = "TechnologyMenu";
        while (state.equals("TechnologyMenu"))
        {
            String cmd = Menu.input();
            if (Menu.checkMatching(TechnologyRegex.back, cmd))
            {
                state = "NULL";
            }
            else if (Menu.checkMatching(TechnologyRegex.technologyChoice, cmd))
            {
                System.out.println(
                        gameViewController.getTechnologyMenuController().chooseTechnology(
                                matcher.group("technology").toLowerCase()
                        )
                );
            }
            else if (Menu.checkMatching(TechnologyRegex.showTechInfo, cmd))
            {
                System.out.println(gameViewController.getTechnologyMenuController()
                        .technologyTree());
            }
            else
            {
                System.out.println(gameViewController.invalidMessage());
            }
        }
    }
}
