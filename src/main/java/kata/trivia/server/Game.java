package kata.trivia.server;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<Player>();

    private int currentPlayerIndex = 0;
    private boolean isGettingOutOfPenaltyBox;
    private QuestionMaker questionMaker = new QuestionMaker();

    public void add(String playerName) {
        players.add(new Player(playerName));

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
    }

    /**
     * Choose one of following as the next step of the current player according to the dice rolling number.
     * 1) moving forward and being asked a question
     * 2) getting out of the penalty box, moving forward and being asked a question
     * 3) staying in the penalty box
     *
     * @param rollingNumber
     */
    public void roll(int rollingNumber) {
        System.out.println(players.get(currentPlayerIndex).getPlayerName() + " is the current player");
        System.out.println("They have rolled a " + rollingNumber);

        if (players.get(currentPlayerIndex).isInPenaltyBox()) {
            if (rollingNumber % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                System.out.println(players.get(currentPlayerIndex) + " is getting out of the penalty box");
                playerMoveForwardAndBeAskedQuestion(rollingNumber);
            } else {
                System.out.println(players.get(currentPlayerIndex) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {

            playerMoveForwardAndBeAskedQuestion(rollingNumber);
        }

    }

    private void playerMoveForwardAndBeAskedQuestion(int roll) {
        players.get(currentPlayerIndex).moveForward(roll);

        System.out.println(players.get(currentPlayerIndex)
                + "'s new location is "
                + players.get(currentPlayerIndex).getPlace());
        System.out.println("The category is " + questionMaker.currentCategory(players.get(currentPlayerIndex)));
        questionMaker.askQuestion(players.get(currentPlayerIndex));
    }

    /**
     * Present a gold coin to the current player who answers the question correctly,
     * find next player, and determine if the game will continue.
     *
     * @return
     */
    public boolean wasCorrectlyAnswered() {
        if (players.get(currentPlayerIndex).isInPenaltyBox()) {
            if (isGettingOutOfPenaltyBox) {
                return winGoldCoinAndFindNextPlayer();
            } else {
                nextPlayer();
                return true;
            }


        } else {

            return winGoldCoinAndFindNextPlayer();
        }
    }

    private boolean winGoldCoinAndFindNextPlayer() {
        System.out.println("Answer was correct!!!!");
        players.get(currentPlayerIndex).winGoldCoin();
        System.out.println(players.get(currentPlayerIndex)
                + " now has "
                + players.get(currentPlayerIndex).getNumberOfGoldCoins()
                + " Gold Coins.");

        boolean willContinue = willGameContinue();
        nextPlayer();

        return willContinue;
    }

    /**
     * Send the current play to the penalty box who answers the question wrongly, find
     * next player, and determine if the game will continue.
     *
     * @return
     */
    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(players.get(currentPlayerIndex) + " was sent to the penalty box");
        players.get(currentPlayerIndex).sendToPenaltyBox();

        nextPlayer();
        return true;
    }

    private void nextPlayer() {
        currentPlayerIndex++;
        if (currentPlayerIndex == players.size()) currentPlayerIndex = 0;
    }


    private boolean willGameContinue() {
        return !(players.get(currentPlayerIndex).getNumberOfGoldCoins() == 6);
    }
}
