package Controller.GameController;

import Models.City.City;
import Models.Civilization.Civilization;
import Models.Database.GameDataBase;
import Models.General.Coordination;
import Models.Units.Unit;
import View.Menu;

import java.util.regex.Matcher;

public class GameViewController {
    private static GameViewController gameViewController = new GameViewController();
    public static GameViewController getInstance() {
        return gameViewController;
    }
    private InfoController infoController = new InfoController();
    private CityController cityController = new CityController();
    private UnitController unitController = new UnitController();
    private CheatController cheatController = new CheatController();
    private TechnologyMenuController technologyMenuController = new TechnologyMenuController();
    public TechnologyMenuController getTechnologyMenuController() {
        return technologyMenuController;
    }

    public String exitGameMenu() {
        Menu.goToMenu(Menu.MAIN);
        return "You are taken to the Main Menu";
    }

    public String showCurrentMenu() {
        return "Game Menu";
    }

    public String goToNextMenu() {
        return "menu navigation is not possible";
    }

    public String nextTurn() {
        for (Unit unit : GameDataBase.getCurrentCivilization().getUnits()) {
            if (!unit.isWorkDone()) {
                return "a unit didn't work done yet";
            }
        }
        GameDataBase.nextTurn();
        Civilization curr = GameDataBase.getCurrentCivilization();
        for (City city : curr.getCities()) {
            city.nextTurn();
        }
        curr.nextTurn();
        return "next turn was done!";
    }

    public String invalidMessage() {
        return "invalid command";
    }

    public InfoController getInfoController() {
        return infoController;
    }

    public CityController getCityController() {
        return cityController;
    }

    public UnitController getUnitController() {
        return unitController;
    }

    public CheatController getCheatController() {
        return cheatController;
    }

    public String selectCityByPosition(int x, int y) {
        Coordination coordinate = new Coordination(x, y);
        City city = null;
        if (!coordinate.isValidCoordination()) {
            return "Coordinate is not valid!";
        }
        if (coordinate.getTerrain() instanceof City) {
            city = (City) coordinate.getTerrain();
        }
        if (city == null) {
            return "There is no city in this place!" + "(" + x + ", " + y + ")";
        }
        if (city.getCivilization() != GameDataBase.getCurrentCivilization()) {
            return "This is not your city";
        }
        GameDataBase.setSelected(city);
        return "City selected successfully!";
    }

    public String selectMilitaryUnit(int x, int y) {
        Coordination coordinate = new Coordination(x, y);
        Unit unit = coordinate.getTerrain().getMilitaryUnit();
        if (!coordinate.isValidCoordination()) {
            return "Coordinate is not valid!";
        }
        if (unit == null) {
            return "There is no military unit in this place!";
        }
        if (unit.getCivilization() != GameDataBase.getCurrentCivilization()) {
            return "This is not your unit";
        }
        GameDataBase.setSelected(unit);
        return "Unit selected successfully!";
    }

    public String selectCivilianUnit(int x, int y) {
        Coordination coordinate = new Coordination(x, y);
        Unit unit = coordinate.getTerrain().getCivilianUnit();
        if (!coordinate.isValidCoordination()) {
            return "Coordinate is not valid!";
        }
        if (unit == null) {
            return "There is no civilian unit in this place!";
        }
        if (unit.getCivilization() != GameDataBase.getCurrentCivilization()) {
            return "This is not your unit";
        }
        GameDataBase.setSelected(unit);
        return "Unit selected successfully!";
    }

    public void doNextTurn() {
        GameDataBase.nextTurn();
        Civilization civilization = GameDataBase.getCurrentCivilization();
        for (City city : civilization.getCities()) {
            city.nextTurn();
        }
        civilization.nextTurn();
        for (Unit unit : civilization.getUnits()) {
            unit.nextTurn();
        }
    }
}
