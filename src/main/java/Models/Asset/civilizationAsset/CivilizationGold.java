package Models.Asset.civilizationAsset;

import Models.Civilization.Civilization;
import Models.Database.GameDataBase;

public class CivilizationGold {
    private double additionGold;
    private double currentGold;

    private double addedFromCheat;

    public double getAddedFromCheat() {
        return addedFromCheat;
    }

    public void setAddedFromCheat(double addedFromCheat) {
        this.addedFromCheat = addedFromCheat;
    }

    public void addAdditionGold(double number) {
        additionGold += number;
    }

    public void addCurrentGold(double number) {
        currentGold += number;
    }

    public double getAdditionGold() {
        return additionGold;
    }

    public void setAdditionGold(double additionGold) {
        this.additionGold = additionGold;
    }

    public double getCurrentGold() {
        return currentGold;
    }

    public void setCurrentGold(double currentGold) {
        this.currentGold = currentGold;
    }

    public Civilization getCivilization() {
        for (Civilization civilization : GameDataBase.getCivilizations()) {
            if (civilization.getGold() == this)
                return civilization;
        }
        return null;
    }
}
