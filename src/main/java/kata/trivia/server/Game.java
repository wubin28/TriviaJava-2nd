package kata.trivia.server;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<Player>();
    private boolean[] inPenaltyBox = new boolean[6];

    private int currentPlayerInt = 0;
    private boolean isGettingOutOfPenaltyBox;
    private QuestionMaker questionMaker = new QuestionMaker();
    private Player currentPlayer;

    public void add(String playerName) {
        players.add(new Player(playerName));
        inPenaltyBox[players.size()] = false;

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
        System.out.println(players.get(currentPlayerInt) + " is the current player");
        System.out.println("They have rolled a " + rollingNumber);

        if (inPenaltyBox[currentPlayerInt]) {
            if (rollingNumber % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                System.out.println(players.get(currentPlayerInt) + " is getting out of the penalty box");
                playerMoveForwardAndBeAskedQuestion(rollingNumber);
            } else {
                System.out.println(players.get(currentPlayerInt) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {

            playerMoveForwardAndBeAskedQuestion(rollingNumber);
        }

    }

    private void playerMoveForwardAndBeAskedQuestion(int roll) {
        currentPlayer.moveForward(roll);

        System.out.println(players.get(currentPlayerInt)
                + "'s new location is "
                + currentPlayer.getPlace());
        System.out.println("The category is " + questionMaker.currentCategory(currentPlayer));
        questionMaker.askQuestion(currentPlayer);
    }

    /**
     * Present a gold coin to the current player who answers the question correctly,
     * find next player, and determine if the game will continue.
     *
     * @return
     */
    public boolean wasCorrectlyAnswered() {
        if (inPenaltyBox[currentPlayerInt]) {
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
        currentPlayer.winGoldCoin();
        System.out.println(players.get(currentPlayerInt)
                + " now has "
                + currentPlayer.getNumberOfGoldCoins（）
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
        System.out.println(players.get(currentPlayerInt) + " was sent to the penalty box");
        inPenaltyBox[currentPlayerInt] = true;

        nextPlayer();
        return true;
    }

    private void nextPlayer() {
        currentPlayerInt++;
        if (currentPlayerInt == players.size()) currentPlayerInt = 0;
    }


    private boolean willGameContinue() {
        return !(currentPlayer.getNumberOfGoldCoins() == 6);
    }
}
