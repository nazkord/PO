package pl.edu.agh.to.lab4;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrisonerDatabaseTest {

    private final PrisonersDatabase prisonersDatabase = new PrisonersDatabase();

    @Before
    public void setUp() {
        prisonersDatabase.addPrisoner("Wiezienie krakowskie", new Prisoner("Anita", "Wiercipieta", "84080452357", 2009, 3));
        prisonersDatabase.addPrisoner("Wiezienie krakowskie", new Prisoner("Janusz", "Zlowieszczy", "92080445657", 2001, 10));
        prisonersDatabase.addPrisoner("Wiezienie przedmiejskie", new Prisoner("Janusz", "Zamkniety", "802104543357", 2010, 5));
        prisonersDatabase.addPrisoner("Wiezienie centralne", new Prisoner("Janusz", "Podejrzany", "85121212456", 2012, 1));
    }

    @Test
    public void testThereAreThreeJails() {
        assertEquals(3, prisonersDatabase.findAll().keySet().size());
    }
}
