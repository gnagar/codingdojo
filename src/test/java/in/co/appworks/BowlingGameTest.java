package in.co.appworks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
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

		rollMany(20, 0);

		assertEquals(0, testGame.score());
	}
	@Test
	public void testOnePinEachTry() throws Exception {

		rollMany(20, 1);

		assertEquals(20, testGame.score());
	}
	
	@Test
	public void testOneSpare() throws Exception {
		rollSpare();
		testGame.roll(3);		
		rollMany(17, 0);
		
		assertEquals(16, testGame.score());
	}
	
	@Test
	public void testTwoSpares() throws Exception {
		rollSpare();
		testGame.roll(5);
		testGame.roll(0);
		rollSpare();
		testGame.roll(3);
		rollMany(13, 0);
		
		assertEquals(36, testGame.score());
		
	}
	
	@Test
	public void testAStrike() throws Exception {
		rollStrike();
		testGame.roll(1);
		testGame.roll(6);
		rollMany(16, 0);
		
		assertEquals(24, testGame.score());
		
	}
	
	@Test
	public void testPerfectGame() throws Exception {
		rollMany(12, 10);
		assertEquals(300, testGame.score());
	}
	
	@Test
	@Ignore
	public void anExampleOfIgnoredTest() throws Exception {
		rollMany(12, 10);
		assertEquals(300, testGame.score());
	}

	private void rollStrike() {
		testGame.roll(10);
	}

	private void rollSpare() {
		testGame.roll(5);
		testGame.roll(5);
	}

	private void rollMany(int totalRolls, int pins) {
		for (int tries = 0; tries < totalRolls; tries++) {
			testGame.roll(pins);
		}
	}
	
}
