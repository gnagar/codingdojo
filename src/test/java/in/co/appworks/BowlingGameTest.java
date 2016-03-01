package in.co.appworks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

	private Game testGame;

	@Before
	public void setUp() {
		testGame = new Game();
	}

	@Test
	public void testGutterGameWhereNoPinsAreBrokenAfterAllTries()
			throws Exception {

		int totalRolls = 20;

		int pins = 0;

		for (int tries = 0; tries < totalRolls; tries++) {
			testGame.roll(pins);
		}

		assertEquals(0, testGame.score());
	}

	@Test
	public void testIfOnePinEachTryResultsInCorrectScore() throws Exception {
		for (int i = 0; i < 20; i++) {
			testGame.roll(1);
		}
		assertEquals(20, testGame.score());
	}

}
