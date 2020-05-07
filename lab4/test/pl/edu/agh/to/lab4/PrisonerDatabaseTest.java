package pl.edu.agh.to.lab4;

import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.to.lab4.model.Prisoner;
import pl.edu.agh.to.lab4.dataProvider.PrisonersDatabase;

import static org.junit.Assert.assertEquals;

public class PrisonerDatabaseTest {

    private final PrisonersDatabase prisonersDatabase = new PrisonersDatabase();

    @Before
    public void setUp() {
        prisonersDatabase.addPrisoner("Wiezienie krakowskie", new Prisoner("Anita", "Wiercipieta",31, "84080452357", 2009, 3));
        prisonersDatabase.addPrisoner("Wiezienie krakowskie", new Prisoner("Janusz", "Zlowieszczy",45, "92080445657", 2001, 10));
        prisonersDatabase.addPrisoner("Wiezienie przedmiejskie", new Prisoner("Janusz", "Zamkniety",67, "802104543357", 2010, 5));
        prisonersDatabase.addPrisoner("Wiezienie centralne", new Prisoner("Janusz", "Podejrzany", 80,"85121212456", 2012, 1));
    }

    @Test
    public void testThereAreThreeJails() {
        assertEquals(3, prisonersDatabase.findAll().keySet().size());
    }
}
