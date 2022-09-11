package View.SubGameMenu;

import Controller.GameController.GameViewController;
import Models.Database.GameDataBase;
import View.Menu;
import View.Regexes.SelectWorkerRegex;

import java.util.regex.Matcher;

public class SelectWorkerMenu {
    public static void run(Matcher matcher) {
        GameViewController gameViewController = GameViewController.getInstance();
        int x = Integer.parseInt(matcher.group("x"));
        int y = Integer.parseInt(matcher.group("y"));
        System.out.println(gameViewController.selectCivilianUnit(x, y));
        if (GameDataBase.getSelected() == null)
            return;
        String state = "workerMenu";
        while (state.equals("workerMenu"))
        {
            String cmd = Menu.input();
            if (Menu.checkMatching(SelectWorkerRegex.back, cmd))
            {
                state = "NULL";
            }
            else if (Menu.checkMatching(SelectWorkerRegex.sleep, cmd))
            {
                System.out.println(gameViewController.getUnitController().sleep());
            }
            else if (Menu.checkMatching(SelectWorkerRegex.buildLumberMil, cmd))
            {
                System.out.println(gameViewController.getUnitController().buildLumberMill());
            }
            else if (Menu.checkMatching(SelectWorkerRegex.BuildMine, cmd))
            {
                System.out.println(gameViewController.getUnitController().buildMine());
            }
            else if (Menu.checkMatching(SelectWorkerRegex.BuildTraidingPost, cmd))
            {
                System.out.println(gameViewController.getUnitController().buildTradingPost());
            }
            else if (Menu.checkMatching(SelectWorkerRegex.buidFarm, cmd))
            {
                System.out.println(gameViewController.getUnitController().buildFarm());
            }
            else if (Menu.checkMatching(SelectWorkerRegex.showInfo, cmd))
            {
                System.out.println(gameViewController.getUnitController().showWorkerInfo());
            }
            else if (Menu.checkMatching(SelectWorkerRegex.buildRoad, cmd))
            {
                System.out.println(gameViewController.getUnitController().buildRoad());
            }
            else if (Menu.checkMatching(SelectWorkerRegex.nothing, cmd))
            {
                System.out.println(gameViewController.getUnitController().doNothing());
            }
            else if (Menu.checkMatching(SelectWorkerRegex.wake, cmd))
            {
                System.out.println(gameViewController.getUnitController().wake());
            }
            else if (Menu.checkMatching(SelectWorkerRegex.moveunit, cmd))
            {
                int x1 = Integer.parseInt(Menu.getMatcher().group("x")),
                        y1 = Integer.parseInt(Menu.getMatcher().group("y"));
                System.out.println(gameViewController.getUnitController().moveUnit(x1, y1));
            }
            else if (Menu.checkMatching(SelectWorkerRegex.delete, cmd))
            {
                System.out.println(gameViewController.getUnitController().delete());
            }
            else if (Menu.checkMatching(SelectWorkerRegex.repair, cmd))
            {
                System.out.println(gameViewController.getUnitController().repair());
            }
            else if (Menu.checkMatching(SelectWorkerRegex.build_camp, cmd))
            {
                System.out.println(gameViewController.getUnitController().buildCamp());
            }
            else if (Menu.checkMatching(SelectWorkerRegex.build_pasture, cmd))
            {
                System.out.println(gameViewController.getUnitController().buildPasture());
            }
            else if (Menu.checkMatching(SelectWorkerRegex.build_quarry, cmd))
            {
                System.out.println(gameViewController.getUnitController().buildQuarry());
            }
            else if (Menu.checkMatching(SelectWorkerRegex.remove_marsh, cmd))
            {
                System.out.println(gameViewController.getUnitController().removeMarsh());
            }
            else if (Menu.checkMatching(SelectWorkerRegex.remove_forest, cmd))
            {
                System.out.println(gameViewController.getUnitController().removeForest());
            }
            else if (Menu.checkMatching(SelectWorkerRegex.remove_route, cmd))
            {
                System.out.println(gameViewController.getUnitController().removeRoute());
            }
            else if (Menu.checkMatching(SelectWorkerRegex.remove_jungle, cmd))
            {
                System.out.println(gameViewController.getUnitController().removeJungle());
            }
            else if (Menu.checkMatching(SelectWorkerRegex.build_plantation, cmd))
            {
                System.out.println(gameViewController.getUnitController().buildPlantation());
            }
            else {
                System.out.println(gameViewController.invalidMessage());
            }
        }
    }
}
