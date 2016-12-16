package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import main.BalanceChecker;

import org.junit.Before;
import org.junit.Test;

public class BalanceCheckerTest {
	BalanceChecker balanceChecker;

	@Before
	public void setUp() throws Exception {
		balanceChecker = new BalanceChecker();
	}

	@Test
	public void shouldIdentifyUnevenBraces() {
		assertFalse(balanceChecker.check("{{}"));
		assertFalse(balanceChecker.check("[[]"));
		assertFalse(balanceChecker.check("(()"));
		assertFalse(balanceChecker.check("{}}"));
		assertFalse(balanceChecker.check("[]]"));
		assertFalse(balanceChecker.check("())"));
	}
	
	@Test
	public void shouldIdentifyEvenBraces() {
		assertTrue(balanceChecker.check("{{}}"));
		assertTrue(balanceChecker.check("[[]]"));
		assertTrue(balanceChecker.check("(())"));
	}

}
