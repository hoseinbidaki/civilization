package Models.Asset.civilizationAsset;

import Models.Civilization.Civilization;
import Models.Database.GameDataBase;

public class CivilizationScience {
    private double additionScience;
    private double addedFromCheat;

    public double getAddedFromCheat() {
        return addedFromCheat;
    }

    public void setAddedFromCheat(double addedFromCheat) {
        this.addedFromCheat = addedFromCheat;
    }

    public void add(double number) {
        additionScience += number;
    }

    public double getAdditionScience() {
        return additionScience;
    }

    public void setAdditionScience(double additionScience) {
        this.additionScience = additionScience;
    }

    public Civilization getCivilization() {
        for (Civilization civilization : GameDataBase.getCivilizations()) {
            if (civilization.getScience() == this)
                return civilization;
        }
        return null;
    }
}
