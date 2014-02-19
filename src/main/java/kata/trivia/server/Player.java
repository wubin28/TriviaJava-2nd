package kata.trivia.server;

/**
 * Created by ben on 14-2-19.
 */
public class Player {
    private final String name;
    private int place;

    public Player(String playerName) {
        this.name = playerName;
    }

    public int getPlace() {
        return place;
    }
}
