package Controller.GameController;

import Models.City.City;
import Models.Civilization.Civilization;
import Models.Database.GameDataBase;
import Models.Units.Unit;
import Models.Units.UnitType;

import java.util.Objects;

public class InfoController {
    public String showResearch() {
        return GameDataBase.getCurrentCivilization()
                .getTechnologies().technologyTree();
    }

    public String showHappines() {
        Civilization civilization = GameDataBase.getCurrentCivilization();
        return "happines : " + civilization.getHappiness().getAdditionHappiness();
    }

    public String showUnits() {
        Civilization civilization = GameDataBase.getCurrentCivilization();
        StringBuilder units = new StringBuilder();
        for (Unit unit : civilization.getUnits()) {
            units.append(unit.showInfo());
        }
        return String.valueOf(units);
    }

    public String showCities() {
        Civilization civilization = GameDataBase.getCurrentCivilization();
        StringBuilder cities = new StringBuilder();
        for (City city : civilization.getCities()) {
            cities.append(city.getDetails()).append("\n");
        }
        return String.valueOf(cities);
    }

    public String showDiplomacy() {
        return null;
    }

    public String showVictory() {
        return "victory nadarim hanooz";
        // TODO...
    }

    public String showDemographics() {
        return GameDataBase.getCurrentCivilization().getDemographics();
    }

    public String showMilitary() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Unit unit : GameDataBase.getCurrentCivilization().getUnits()) {
            if (UnitType.getSiegeMilitaryUnit().contains(unit.getMyType()))
                stringBuilder.append(unit.showInfo());
        }
        return String.valueOf(stringBuilder);
    }

    public String showEconomy() {
        StringBuilder economy = new StringBuilder();
        economy.append(GameDataBase.getCurrentCivilization().getInformation());
        for (City city : GameDataBase.getCurrentCivilization().getCities()) {
            economy.append("\n").append(city.getDetails());
        }
        return String.valueOf(economy);
    }

    public String showDiplomatics() {
        return null;
    }

    public String showDeals() {
        return "you don't have any deal!";
    }

    public String showNotification() {
        String notif = GameDataBase.getCurrentCivilization().getNotification();
        if (Objects.equals("", notif))
            return "you don't have any notification!";
        else
            return notif;
    }

    public String resetNotification() {
        GameDataBase.getCurrentCivilization().resetNotification();
        return "notification has been reset successfully";
    }
}
