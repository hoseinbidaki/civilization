package Models.War;

import Models.Civilization.Civilization;
import Models.Database.GameDataBase;

public class War {
    private String nameOfCivilization;

    public War(String nameOfCivilization) {
        this.nameOfCivilization = nameOfCivilization;
    }

    public War(Civilization civilization) {
        this.nameOfCivilization = civilization.getName();
    }

    public String getNameOfCivilization() {
        return nameOfCivilization;
    }

    public Civilization getCivilization() {
        for (Civilization civilization : GameDataBase.getCivilizations()) {
            if (civilization.getName().equals(nameOfCivilization))
                return civilization;
        }
        return null;
    }



    public void setNameOfCivilization(String nameOfCivilization) {
        this.nameOfCivilization = nameOfCivilization;
    }
}