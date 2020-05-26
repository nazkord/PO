package pl.edu.agh.to.lab4;

import org.junit.Test;
import pl.edu.agh.to.lab4.model.Prisoner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrisonerTest {
    @Test
    public void testPrisonerIsInJail() {
        Prisoner news = new Prisoner("Jan", "Kowalski",29, "802104543357", 2015, 5);
        assertTrue(news.IsJailedNow());
    }

    @Test
    public void testPrisonerHasBeenReleasedFromJail() {
        Prisoner news = new Prisoner("Jan", "Kowalski",60, "802104543357", 2008, 5);
        assertFalse(news.IsJailedNow());
    }
}
