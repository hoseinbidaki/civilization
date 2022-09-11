package Controller.GameController;

import Models.Asset.civilizationAsset.CivilizationTechnologies;
import Models.Database.GameDataBase;
import Models.General.Coordination;
import Models.Units.MilitaryUnit;
import Models.Units.Settler;
import Models.Units.Unit;
import Models.Units.UnitType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;

public class CheatController {
    public String increaseScience(int number) {
        GameDataBase.getCurrentCivilization().getScience().setAddedFromCheat(
                GameDataBase.getCurrentCivilization().getScience().getAddedFromCheat() + number
        );
        return "added. your current science was : " + GameDataBase.getCurrentCivilization().getScience().getAdditionScience();
    }

    public String increaseGold(int number) {
        GameDataBase.getCurrentCivilization().getGold().setAddedFromCheat(
                GameDataBase.getCurrentCivilization().getGold().getAddedFromCheat() + number
        );
        return "cash added. your current gold was : " + GameDataBase.getCurrentCivilization().getGold().getCurrentGold();

    }

    public String resetUnit() {
        for (Unit unit : GameDataBase.getCurrentCivilization().getUnits()) {
            unit.nextTurn();
        }
        return "all units reset";

    }

    public String increaseHappiness(int number) {
        GameDataBase.getCurrentCivilization().getHappiness().setAddedFromCheat(
                GameDataBase.getCurrentCivilization().getHappiness().getAddedFromCheat() + number
        );
        return "added. your current science was : " + GameDataBase.getCurrentCivilization().getScience().getAdditionScience();

    }

    public String increaseTurn(int number) {
        for (int i = 0; i < number; i++) {
            new GameViewController().doNextTurn();
        }
        return "done";

    }

    public String setArcher(int x, int y) {
        new MilitaryUnit(UnitType.ARCHER,
                new Coordination(x, y).getTerrain(),
                GameDataBase.getCurrentCivilization());
        return "archer added";
    }

    public String setTank(int x, int y) {
        new MilitaryUnit(UnitType.TANK,
                new Coordination(x, y).getTerrain(),
                GameDataBase.getCurrentCivilization());
        return "tank added";
    }

    public String setArtillery(int x, int y) {
        new MilitaryUnit(UnitType.ARTILLERY,
                new Coordination(x, y).getTerrain(),
                GameDataBase.getCurrentCivilization());
        return "artillery added";
    }

    public String setCannon(int x, int y) {
        new MilitaryUnit(UnitType.CANON,
                new Coordination(x, y).getTerrain(),
                GameDataBase.getCurrentCivilization());
        return "cannon added";
    }

    public String setLancer(int x, int y) {
        new MilitaryUnit(UnitType.LANCER,
                new Coordination(x, y).getTerrain(),
                GameDataBase.getCurrentCivilization());
        return "lancer added";
    }

    public String setSettler(int x, int y) {
        new Settler(
                new Coordination(x, y).getTerrain(),
                GameDataBase.getCurrentCivilization());
        return "setller added";
    }

    public String openTechnologies() {
        CivilizationTechnologies technologies = GameDataBase.getCurrentCivilization().getTechnologies();
        technologies.getTechnologiesResearched().addAll(technologies.getTechnologiesUnavailable());
        technologies.getTechnologiesResearched().addAll(technologies.getTechnologiesAvailable().keySet());
        if (technologies.getTechnologyCurrentlyResearching() != null)
            technologies.getTechnologiesResearched().add(technologies.getTechnologyCurrentlyResearching());
        technologies.setTechnologiesAvailable(new HashMap<>());
        technologies.setTechnologiesUnavailable(new ArrayList<>());
        technologies.setTechnologyCurrentlyResearching(null);
        technologies.setRemainCost(0);
        return "all technologies were opened!";
    }
}
