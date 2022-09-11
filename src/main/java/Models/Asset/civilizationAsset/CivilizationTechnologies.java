package Models.Asset.civilizationAsset;


import Models.Civilization.Civilization;
import Models.Database.GameDataBase;
import Models.Technology.TechnologyType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CivilizationTechnologies {
    private ArrayList<TechnologyType> technologiesResearched;
    private TechnologyType technologyTypeCurrentlyResearching;
    private HashMap<TechnologyType, Integer> technologiesAvailable;
    private ArrayList<TechnologyType> technologiesUnavailable;
    private int remainCost;

    public CivilizationTechnologies() {
        technologiesUnavailable = TechnologyType.getAllTechnologies();
        technologiesAvailable = new HashMap<>();
        technologiesResearched = new ArrayList<>();
        lookingForAvailable();
    }

    public void lookingForAvailable() {
        boolean isAvalable;
        TechnologyType technologyType;
        for (int i = technologiesUnavailable.size() - 1; i >= 0; i--) {
            technologyType = technologiesUnavailable.get(i);
            isAvalable = true;
            for (TechnologyType requirement : technologyType.getRequirement()) {
                if (!technologiesResearched.contains(requirement)) {
                    isAvalable = false;
                    break;
                }
            }
            if (isAvalable) {
                technologiesAvailable.put(technologyType, technologyType.getCost());
                technologiesUnavailable.remove(technologyType);
            }
        }
    }

    public void startWorkingOnTechnology(TechnologyType newTechnologyType, int cost) {
        if (technologyTypeCurrentlyResearching != null) {
            technologiesAvailable.put(technologyTypeCurrentlyResearching, remainCost);
        }
        technologiesAvailable.remove(newTechnologyType);//checkBeshe
        technologyTypeCurrentlyResearching = newTechnologyType;
        remainCost = cost;
        checkTechnologyCurrentlyResearching();
    }

    public void checkTechnologyCurrentlyResearching() {
        if (technologyTypeCurrentlyResearching != null) {
            remainCost -= GameDataBase.getCurrentCivilization().getScience().getAdditionScience();
            if (remainCost <= 0) {
                technologiesResearched.add(technologyTypeCurrentlyResearching);
                remainCost = 0;
                technologyTypeCurrentlyResearching = null;
                GameDataBase.getCurrentCivilization().getScience().setAdditionScience(0);
                lookingForAvailable();
            }
        }
    }

    public ArrayList<TechnologyType> getTechnologiesResearched() {
        return technologiesResearched;
    }

    public void setTechnologiesResearched(ArrayList<TechnologyType> technologiesResearched) {
        this.technologiesResearched = technologiesResearched;
    }

    public TechnologyType getTechnologyCurrentlyResearching() {
        return technologyTypeCurrentlyResearching;
    }

    public void setTechnologyCurrentlyResearching(TechnologyType technologyTypeCurrentlyResearching) {
        this.technologyTypeCurrentlyResearching = technologyTypeCurrentlyResearching;
    }

    public HashMap<TechnologyType, Integer> getTechnologiesAvailable() {
        return technologiesAvailable;
    }

    public void setTechnologiesAvailable(HashMap<TechnologyType, Integer> technologiesAvailable) {
        this.technologiesAvailable = technologiesAvailable;
    }

    public ArrayList<TechnologyType> getTechnologiesUnavailable() {
        return technologiesUnavailable;
    }

    public void setTechnologiesUnavailable(ArrayList<TechnologyType> technologiesUnavailable) {
        this.technologiesUnavailable = technologiesUnavailable;
    }

    public Civilization getCivilization() {
        for (Civilization civilization : GameDataBase.getCivilizations()) {
            if (civilization.getTechnologies() == this)
                return civilization;
        }
        return null;
    }

    public String technologyTree() {
        StringBuilder map = new StringBuilder();
        map.append("*Researched*\n");
        for (TechnologyType technologyTypeResearched : GameDataBase.getCurrentCivilization().getTechnologies().getTechnologiesResearched()) {
            map.append(technologyTypeResearched.getName()).append("\n");
        }
        map.append("\n*Available*\n");
        for (Map.Entry<TechnologyType, Integer> technologyAvailable : GameDataBase.getCurrentCivilization().getTechnologies().getTechnologiesAvailable().entrySet()) {
            map.append(technologyAvailable.getKey().getName()).append("\n");
        }
        map.append("\n*Unavailable*\n");
        for (TechnologyType technologyTypeUnavailable : GameDataBase.getCurrentCivilization().getTechnologies().getTechnologiesUnavailable()) {
            map.append(technologyTypeUnavailable.getName()).append(" - requirements:");
            for (TechnologyType technologyType : technologyTypeUnavailable.getRequirement()) {
                if (technologyType != null)
                    map.append(" ").append(technologyType.getName());
                else
                    map.append(" null");
            }
            map.append("\n");
        }
        return String.valueOf(map);
    }

    public void setRemainCost(int remainCost) {
        this.remainCost = remainCost;
    }
}
