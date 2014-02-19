package kata.trivia.server;

/**
 * Created by ben on 14-2-19.
 */
public class Player {
    private final String name;
    private int place = 0;
    private int numberOfGoldCoins = 0;
    private boolean inPenaltyBox = false;

    public Player(String playerName) {
        this.name = playerName;
    }

    public int getPlace() {
        return place;
    }

    public void moveForward(int roll) {
        place += roll;
        if (place > 11) place -= 12;
    }

    public void winGoldCoin() {
        numberOfGoldCoins++;
    }

    public int getNumberOfGoldCoins() {
        return numberOfGoldCoins;
    }

    public boolean isInPenaltyBox() {
        return this.inPenaltyBox;
    }

    public void sendToPenaltyBox() {
        this.inPenaltyBox = true;
    }
}
