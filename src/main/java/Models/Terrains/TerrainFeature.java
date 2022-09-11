package Models.Terrains;

import Models.Resources.Resource;
import Models.Interfaces.TerrainTypeOrTerrainFeatureType;

import java.util.ArrayList;

public enum TerrainFeature implements TerrainTypeOrTerrainFeatureType {
    FLOODPLAINS(2, 0, 0, -33, 1, new ArrayList<Resource>() {
        {
            add(Resource.WHEAT);
            add(Resource.SUGAR);
        }
    }),
    FOREST(1, 1, 0, 25, 2, new ArrayList<Resource>() {
        {
            add(Resource.DEER);
            add(Resource.FURS);
            add(Resource.DYES);
            add(Resource.SILK);
        }
    }),
    ICE(0, 0, 0, 0, Integer.MAX_VALUE, new ArrayList<>()),
    JUNGLE(1, -1, 0, 25, 2, new ArrayList<Resource>() {
        {
            add(Resource.BANANA);
            add(Resource.GEMS);
            add(Resource.DYES);
        }
    }),
    MARSH(-1, 0, 0, -33, 2, new ArrayList<Resource>() {
        {
            add(Resource.SUGAR);
        }
    }),
    OASIS(3, 0, 1, -33, 1, new ArrayList<>()),
    RIVER(0, 0, 1, 0, 0, new ArrayList<>());

    TerrainFeature(int food, int product, int gold, int combatModifier, int MP, ArrayList<Resource> possibleResources) {
        this.food = food;
        this.product = product;
        this.gold = gold;
        this.MP = MP;
        this.combatModifier = combatModifier;
        this.possibleResources = possibleResources;
    }

    final int food;
    final int product;
    final int gold;
    final int MP;
    final int combatModifier;
    final ArrayList<Resource> possibleResources;

    public ArrayList<Resource> getPossibleResources() {
        return possibleResources;
    }

    public int getFood() {
        return food;
    }

    public int getProduct() {
        return product;
    }

    public int getGold() {
        return gold;
    }

    public int getMP() {
        return MP;
    }

    public int getCombatModifier() {
        return combatModifier;
    }
}
