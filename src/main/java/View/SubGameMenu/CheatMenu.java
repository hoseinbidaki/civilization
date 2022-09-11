package View.SubGameMenu;

import Controller.GameController.GameViewController;
import View.Menu;
import View.Regexes.CheatRegex;

import java.util.regex.Matcher;

public class CheatMenu {
    public static void run(Matcher matcher) {
        GameViewController gameViewController = GameViewController.getInstance();
        String state = "cheatMenu";
        while (state.equals("cheatMenu"))
        {
            String cmd = Menu.input();
            if (Menu.checkMatching(CheatRegex.back, cmd))
            {
                state = "NULL";
            }
            else if (Menu.checkMatching(CheatRegex.increase_gold, cmd))
            {
                int n = Integer.parseInt(Menu.getMatcher().group("n"));
                System.out.println(gameViewController.getCheatController().increaseGold(n));
            }
            else if (Menu.checkMatching(CheatRegex.increase_turn, cmd))
            {
                int n = Integer.parseInt(Menu.getMatcher().group("n"));
                System.out.println(gameViewController.getCheatController().increaseTurn(n));
            }
            else if (Menu.checkMatching(CheatRegex.incrase_happiness, cmd))
            {
                int n = Integer.parseInt(Menu.getMatcher().group("n"));
                System.out.println(gameViewController.getCheatController().increaseHappiness(n));
            }
            else if (Menu.checkMatching(CheatRegex.increase_science, cmd))
            {
                int n = Integer.parseInt(Menu.getMatcher().group("n"));
                System.out.println(gameViewController.getCheatController().increaseScience(n));
            }
            else if (Menu.checkMatching(CheatRegex.set_archer, cmd))
            {
                int x = Integer.parseInt(Menu.getMatcher().group("x"));
                int y = Integer.parseInt(Menu.getMatcher().group("y"));
                System.out.println(gameViewController.getCheatController().setArcher(x, y));
            }
            else if (Menu.checkMatching(CheatRegex.set_settler, cmd))
            {
                int x = Integer.parseInt(Menu.getMatcher().group("x"));
                int y = Integer.parseInt(Menu.getMatcher().group("y"));
                System.out.println(gameViewController.getCheatController().setSettler(x, y));
            }
            else if (Menu.checkMatching(CheatRegex.set_lancer, cmd))
            {
                int x = Integer.parseInt(Menu.getMatcher().group("x"));
                int y = Integer.parseInt(Menu.getMatcher().group("y"));
                System.out.println(gameViewController.getCheatController().setLancer(x, y));
            }
            else if (Menu.checkMatching(CheatRegex.set_cannon, cmd))
            {
                int x = Integer.parseInt(Menu.getMatcher().group("x"));
                int y = Integer.parseInt(Menu.getMatcher().group("y"));
                System.out.println(gameViewController.getCheatController().setCannon(x, y));
            }
            else if (Menu.checkMatching(CheatRegex.set_tank, cmd))
            {
                int x = Integer.parseInt(Menu.getMatcher().group("x"));
                int y = Integer.parseInt(Menu.getMatcher().group("y"));
                System.out.println(gameViewController.getCheatController().setTank(x, y));
            }
            else if (Menu.checkMatching(CheatRegex.open_allTechnology, cmd))
            {
                System.out.println(gameViewController.getCheatController().openTechnologies());
            }
            else if (Menu.checkMatching(CheatRegex.set_artilery, cmd))
            {
                int x = Integer.parseInt(Menu.getMatcher().group("x"));
                int y = Integer.parseInt(Menu.getMatcher().group("y"));
                System.out.println(gameViewController.getCheatController().setArtillery(x, y));
            }
            else if (Menu.checkMatching(CheatRegex.reset_unit, cmd))
            {
                System.out.println(gameViewController.getCheatController().resetUnit());
            }
            else
            {
                System.out.println(gameViewController.invalidMessage());
            }
        }
    }
}
