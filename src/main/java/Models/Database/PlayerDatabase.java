package Models.Database;

import com.google.gson.Gson;
import java.io.*;
import java.util.ArrayList;
import com.google.gson.reflect.TypeToken;
import Models.General.User;
public class PlayerDatabase {
    private ArrayList<User> users;
    private User loggedInUser = null;

    private static PlayerDatabase playerDatabase = null;
    public static PlayerDatabase getPlayerDatabase() {
        if (playerDatabase == null) {
            playerDatabase = new PlayerDatabase();
        }
        return playerDatabase;
    }

    public PlayerDatabase() {
        loadData();
        loggedInUser = null;
    }

    public void loadData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("users.json"));
            users = new Gson().fromJson(br, new TypeToken<ArrayList<User>>(){}.getType());
            br.close();
        }
        catch (Exception ex) {
            users = new ArrayList<>();
            saveData();
        }

    }

    public void saveData() {
        try {
            FileWriter writer = new FileWriter("users.json");
            writer.write(new Gson().toJson(users));
            writer.close();
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(String username) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return users.get(i);
            }
        }
        return null;
    }

    public User getUserByNickname(String nickname) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getNickname().equals(nickname)) {
                return users.get(i);
            }
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void Logout() {
        setLoggedInUser(null);
    }

    public void Login(User user) {
        setLoggedInUser(user);
    }
}