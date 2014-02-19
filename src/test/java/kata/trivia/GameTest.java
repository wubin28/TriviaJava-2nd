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

    @Test
    public void GIVEN_one_player_WHEN_she_answered_correctly_for_6_times_THEN_game_will_not_continue() {
        Game aGame = new Game();

        aGame.add("Chet");

        aGame.roll(1);
        boolean willContinue = aGame.wasCorrectlyAnswered();
        assertEquals(true, willContinue);

        aGame.roll(1);
        willContinue = aGame.wasCorrectlyAnswered();
        assertEquals(true, willContinue);

        aGame.roll(1);
        willContinue = aGame.wasCorrectlyAnswered();
        assertEquals(true, willContinue);

        aGame.roll(1);
        willContinue = aGame.wasCorrectlyAnswered();
        assertEquals(true, willContinue);

        aGame.roll(1);
        willContinue = aGame.wasCorrectlyAnswered();
        assertEquals(true, willContinue);

        aGame.roll(1);
        willContinue = aGame.wasCorrectlyAnswered();
        assertEquals(false, willContinue);
    }

    @Test
    public void GIVEN_one_player_WHEN_she_answered_wrongly_for_1_time_but_correctly_for_6_times_THEN_game_will_not_continue() {
        Game aGame = new Game();

        aGame.add("Chet");

        aGame.roll(1);
        boolean willContinue = aGame.wasCorrectlyAnswered();
        assertEquals(true, willContinue);

        aGame.roll(1);
        willContinue = aGame.wrongAnswer();
        assertEquals(true, willContinue);

        aGame.roll(1);
        willContinue = aGame.wasCorrectlyAnswered();
        assertEquals(true, willContinue);

        aGame.roll(1);
        willContinue = aGame.wasCorrectlyAnswered();
        assertEquals(true, willContinue);

        aGame.roll(1);
        willContinue = aGame.wasCorrectlyAnswered();
        assertEquals(true, willContinue);

        aGame.roll(1);
        willContinue = aGame.wasCorrectlyAnswered();
        assertEquals(true, willContinue);

        aGame.roll(1);
        willContinue = aGame.wasCorrectlyAnswered();
        assertEquals(false, willContinue);
    }
}
