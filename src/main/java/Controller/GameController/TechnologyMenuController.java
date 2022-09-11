package Controller.GameController;

import Models.Asset.civilizationAsset.CivilizationTechnologies;
import Models.Database.GameDataBase;
import Models.Technology.TechnologyType;

import java.util.Map;
import java.util.regex.Matcher;

public class TechnologyMenuController {


    public String showTechnologies() {
        StringBuilder technologies = new StringBuilder();
        technologies.append("*researched technologies*\n");
        for (TechnologyType technologyTypeResearched : GameDataBase.getCurrentCivilization().getTechnologies().getTechnologiesResearched()) {
            technologies.append("Technology: ").append(technologyTypeResearched.getName()).append("\n");
        }
        technologies.append("\n*available technologies*\n");
        for (Map.Entry<TechnologyType, Integer> technologyAvailable : GameDataBase.getCurrentCivilization().getTechnologies().getTechnologiesAvailable().entrySet()) {
            technologies.append("Technology: ").append(technologyAvailable.getKey().getName()).append("\t");
            technologies.append("- Cost: ").append(technologyAvailable.getValue()).append("    ");
            technologies.append("- Required techs:");
            for (TechnologyType technologyType : technologyAvailable.getKey().getRequirement()) {
                technologies.append(" ").append(technologyType.getName());
            }
            technologies.append("- Leads to techs:");
            for (TechnologyType technologyType : technologyAvailable.getKey().getTechnologyUnlocks()) {
                technologies.append(" ").append(technologyType.getName());
            }
            technologies.append("\t");
            technologies.append("- Unlocks:");
            for (Object unlocks : technologyAvailable.getKey().getUnlocks()) {
                technologies.append(" ").append(unlocks.toString().toLowerCase()); // TODO name
            }
            technologies.append("\n");
        }
        return String.valueOf(technologies);
    }

    public TechnologyType findTechnologyByName(String name) {
        for (TechnologyType technologyType : TechnologyType.getAllTechnologies()) {
            if (technologyType.getName().toLowerCase().equals(name)) {
                return technologyType;
            }
        }
        return null;
    }

    public String technologyTree() {
        return GameDataBase.getCurrentCivilization().
                getTechnologies().technologyTree();
    }


    public String chooseTechnology(String techname) {
        TechnologyType technologyType = findTechnologyByName(techname);
        if (technologyType == null) {
            return "invalid technology name!";
        }
        CivilizationTechnologies civilizationTechnologies = GameDataBase.getCurrentCivilization().getTechnologies();
        if (civilizationTechnologies.getTechnologiesResearched().contains(technologyType)) {
            return "technology is already researched!";
        }
        if (civilizationTechnologies.getTechnologiesUnavailable().contains(technologyType)) {
            return "technology is not available!";
        }
        civilizationTechnologies.startWorkingOnTechnology(technologyType, civilizationTechnologies.
                getTechnologiesAvailable().get(technologyType));
        GameDataBase.getCurrentCivilization().updateNotification("started working on technology " +
                technologyType.getName());
        return "technology is researching!";
    }
}
