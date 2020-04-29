package pl.edu.agh.to.lab4;

import java.time.LocalDate;

public class Prisoner extends Suspect{

    private final int judgementYear;
    private final int sentenceDuration;
    private final String pesel;

    public Prisoner(String name, String surname, String pesel, int judgementYear, int sentenceDuration) {
        super(name, surname);
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.sentenceDuration = sentenceDuration;
    }

    @Override
    public boolean canBeAccused() {
        return !IsJailedNow();
    }

    public boolean IsJailedNow() {
        return judgementYear + sentenceDuration >= getCurrentYear();
    }

    private int getCurrentYear() {
        return LocalDate.now().getYear();
    }
}
