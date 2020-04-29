package pl.edu.agh.to.lab4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrisonerDatabaseTest {

    private final PrisonersDatabase prisonersDatabase = new PrisonersDatabase();

    @Test
    public void testThereAreThreeJails() {
        assertEquals(3, prisonersDatabase.findAll().keySet().size());
    }
}
