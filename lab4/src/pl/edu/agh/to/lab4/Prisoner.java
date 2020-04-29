package pl.edu.agh.to.lab4;

import java.time.LocalDate;
import java.util.Calendar;

public class Prisoner {

    private final int judgementYear;
    private final int sentenceDuration;
    private final String pesel;
    private final String name;
    private final String surname;

    public Prisoner(String name, String surname, String pesel, int judgementYear, int sentenceDuration) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.sentenceDuration = sentenceDuration;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean IsJailedNow() {
        return judgementYear + sentenceDuration >= getCurrentYear();
    }

    public String display() {
        return name + " " + surname;
    }

    private int getCurrentYear() {
        return LocalDate.now().getYear();
    }
}
