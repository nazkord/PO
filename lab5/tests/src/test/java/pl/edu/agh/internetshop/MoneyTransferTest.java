package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;


public class MoneyTransferTest {

	private static final BigInteger ACCOUNT_NUMBER = new BigInteger("27114020040000300201355387");
	private static final String OWNER_DETAILS = "example owner details";
	private static final String DESCRIPTION = "example description";
	private static final int AMOUNT = 5;
	
    @Test
    public void testCreation() {
    	// given

        // when
    	MoneyTransfer moneyTransfer = new MoneyTransfer(ACCOUNT_NUMBER, OWNER_DETAILS, DESCRIPTION, AMOUNT);
        
        // then
    	assertEquals(ACCOUNT_NUMBER, moneyTransfer.getAccountNumber());
    	assertEquals(OWNER_DETAILS, moneyTransfer.getOwnerDetails());
    	assertEquals(DESCRIPTION, moneyTransfer.getDescription());
    	assertEquals(AMOUNT, moneyTransfer.getAmount());
    }

    @Test
    public void testCheckCommitFlagWithoutCommitting() throws Exception {
    	// given
    	MoneyTransfer moneyTransfer = new MoneyTransfer(ACCOUNT_NUMBER, OWNER_DETAILS, DESCRIPTION, AMOUNT);
    	
    	// when
    	
    	
    	// then
    	assertFalse(moneyTransfer.isCommitted());
    }
    
    @Test
    public void testCheckCommitFlagWithCommitting() throws Exception {
    	// given
    	MoneyTransfer moneyTransfer = new MoneyTransfer(ACCOUNT_NUMBER, OWNER_DETAILS, DESCRIPTION, AMOUNT);
    	
    	// when
    	moneyTransfer.setCommitted(true);
    	
    	// then
    	assertTrue(moneyTransfer.isCommitted());
    }
}