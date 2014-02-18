package kata.trivia;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void GIVEN_one_player_WHEN_she_answered_correctly_THEN_game_will_continue() {
        Game aGame = new Game();

        aGame.add("Chet");

        aGame.roll(1);
        boolean willContinue = aGame.wasCorrectlyAnswered();

        assertEquals(true, willContinue);
    }
}
