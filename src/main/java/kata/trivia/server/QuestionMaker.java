package kata.trivia.server;

import java.util.LinkedList;

/**
 * Created by ben on 14-2-19.
 */
public class QuestionMaker {

    private LinkedList popQuestions = new LinkedList();
    private LinkedList scienceQuestions = new LinkedList();
    private LinkedList sportsQuestions = new LinkedList();
    private LinkedList rockQuestions = new LinkedList();

    public QuestionMaker() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast("Rock Question " + i);
        }
    }

    public void askQuestion(Player currentPlayer) {
        if (currentCategory(currentPlayer) == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (currentCategory(currentPlayer) == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (currentCategory(currentPlayer) == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (currentCategory(currentPlayer) == "Rock")
            System.out.println(rockQuestions.removeFirst());

    }

    public String currentCategory(Player currentPlayer) {
        if (currentPlayer.getPlace() == 0) return "Pop";
        if (currentPlayer.getPlace() == 8) return "Pop";
        if (currentPlayer.getPlace() == 1) return "Science";
        if (currentPlayer.getPlace() == 5) return "Science";
        if (currentPlayer.getPlace() == 9) return "Science";
        if (currentPlayer.getPlace() == 2) return "Sports";
        if (currentPlayer.getPlace() == 6) return "Sports";
        if (currentPlayer.getPlace() == 10) return "Sports";
        return "Rock";
    }
}
