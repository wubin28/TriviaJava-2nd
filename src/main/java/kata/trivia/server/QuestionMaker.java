package kata.trivia.server;

/**
 * Created by ben on 14-2-19.
 */
public class QuestionMaker {
    public void askQuestion() {
        if (currentCategory() == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (currentCategory() == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (currentCategory() == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (currentCategory() == "Rock")
            System.out.println(rockQuestions.removeFirst());

    }

    private String currentCategory(Game game) {
        if (game.places[game.currentPlayer] == 0) return "Pop";
        if (game.places[game.currentPlayer] == 4) return "Pop";
        if (game.places[game.currentPlayer] == 8) return "Pop";
        if (game.places[game.currentPlayer] == 1) return "Science";
        if (game.places[game.currentPlayer] == 5) return "Science";
        if (game.places[game.currentPlayer] == 9) return "Science";
        if (game.places[game.currentPlayer] == 2) return "Sports";
        if (game.places[game.currentPlayer] == 6) return "Sports";
        if (game.places[game.currentPlayer] == 10) return "Sports";
        return "Rock";
    }
}
