package cmesapp.cmes_app;

/**
 * Created by ASUS on 3/7/2018.
 */

public class MyAccount {

    private static int id = 0;
    private static String user = "";
    private static int science_score = 0;
    private static int english_score = 0;
    private static int filipino_score = 0;
    private static int random_score = 0;
    private static String level = "0";

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public int getScience_score() {
        return science_score;
    }

    public void setScience_score(int science_score) {
        this.science_score = science_score;
    }

    public int getEnglish_score() {
        return english_score;
    }

    public void setEnglish_score(int english_score) {
        this.english_score = english_score;
    }

    public int getFilipino_score() {
        return filipino_score;
    }

    public void setFilipino_score(int filipino_score) {
        this.filipino_score = filipino_score;
    }

    public int getRandom_score() {
        return random_score;
    }

    public void setRandom_score(int random_score) {
        this.random_score = random_score;
    }



}
