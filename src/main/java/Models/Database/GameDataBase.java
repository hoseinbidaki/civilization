package Models.Database;

import Models.City.City;
import Models.Civilization.Civilization;
import Models.General.Coordination;
import Models.Interfaces.Selectable;
import Models.General.User;
import Models.Map.MainMap;
import Models.Terrains.Terrain;
import Models.Terrains.TerrainType;
import Models.Units.Settler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GameDataBase {
    static private int turn;
    static private MainMap mainMap;
    static private ArrayList<User> players;
    static private User currentUser;
    static private Civilization currentCivilization;
    static private HashMap<User, Civilization> civilizations;

    static private Selectable selected;

    public static void runGameForFirstTime(ArrayList<User> players) {
        GameDataBase.civilizations = new HashMap<>();
        GameDataBase.players = players;
        setGameDataBase();
    }

    private static void setGameDataBase() {
        for (User player : players) {
            civilizations.put(player, new Civilization(player.getUsername()));
        }
        currentUser = players.get(0);
        currentCivilization = civilizations.get(players.get(0));
        turn = 0;
        mainMap = new MainMap();
        Random random = new Random();
        for (Civilization civilization : GameDataBase.getCivilizations()) {
            Coordination coordination = mainMap.getDrought().get(random.nextInt(mainMap.getDrought().size()));
            while (coordination.getTerrain().getType() == TerrainType.MOUNTAIN ||
                    coordination.getTerrain().getCivilization()!=null)
                coordination = mainMap.getDrought().get(random.nextInt(mainMap.getDrought().size()));
            Terrain terrain = GameDataBase.getMainMap().getTerrain(coordination.getX(), coordination.getY());
//            System.out.println("setller created in " + terrain.getXPosition() + " " + terrain.getYPosition());
            new Settler(terrain, civilization);
        }
        GameDataBase.getCurrentCivilization().getMap().updateExploration();
    }

    public static ArrayList<Civilization> getCivilizations() {
        ArrayList<Civilization> civs = new ArrayList<>();
        for (User player : players) {
            civs.add(civilizations.get(player));
        }
        return civs;
    }

    public static void setCivilizations(HashMap<User, Civilization> civilizations) {
        GameDataBase.civilizations = civilizations;
    }

    public static MainMap getMainMap() {
        return mainMap;
    }

    public static void setMainMap(MainMap mainMap) {
        GameDataBase.mainMap = mainMap;
    }

    public static int getTurn() {
        return turn;
    }

    public static void setTurn(int turn) {
        GameDataBase.turn = turn;
    }

    public static ArrayList<User> getPlayers() {
        return players;
    }

    public static void setPlayers(ArrayList<User> players) {
        GameDataBase.players = players;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        GameDataBase.currentUser = currentUser;
    }

    public static Civilization getCurrentCivilization() {
        return currentCivilization;
    }

    public static void setCurrentCivilization(Civilization currentCivilization) {
        GameDataBase.currentCivilization = currentCivilization;
    }

    public static City getCityByName(String name) {
        for (User player : players) {
            for (City city : civilizations.get(player).getCities()) {
                if (city.getName().equals(name)) {
                    return city;
                }
            }
        }
        return null;
    }

    public static Selectable getSelected() {
        return selected;
    }

    public static void setSelected(Selectable selected) {
        GameDataBase.selected = selected;
    }

    public static void nextTurn() {
        turn++;
        setCurrentCivilization(getCivilizations().get(turn % getCivilizations().size()));
    }
}
