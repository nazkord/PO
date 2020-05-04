package pl.edu.agh.to.lab4;

public class Application {

    public static void main(String[] args) {
        PersonDataProvider personDataProvider = new PersonDataProvider();
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Jan", "Kowalski", 30));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Janusz", "Krakowski", 30));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Janusz", "Mlodociany", 10));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Kasia", "Kosinska", 19));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Piotr", "Zgredek", 29));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Tomek", "Gimbus", 14));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Janusz", "Gimbus", 15));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Alicja", "Zaczarowana", 22));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Janusz", "Programista", 77));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Pawel", "Pawlowicz", 32));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Krzysztof", "Mendel", 30));
        PrisonersDatabase prisonersDatabase = new PrisonersDatabase();
        prisonersDatabase.addPrisoner("Wiezienie krakowskie", new Prisoner("Jan", "Kowalski", "87080452357", 2005, 7));
        prisonersDatabase.addPrisoner("Wiezienie krakowskie", new Prisoner("Anita", "Wiercipieta", "84080452357", 2009, 3));
        prisonersDatabase.addPrisoner("Wiezienie krakowskie", new Prisoner("Janusz", "Zlowieszczy", "92080445657", 2001, 10));
        prisonersDatabase.addPrisoner("Wiezienie przedmiejskie", new Prisoner("Janusz", "Zamkniety", "802104543357", 2010, 5));
        prisonersDatabase.addPrisoner("Wiezienie przedmiejskie", new Prisoner("Adam", "Future", "880216043357", 2020, 5));
        prisonersDatabase.addPrisoner("Wiezienie przedmiejskie", new Prisoner("Zbigniew", "Nienajedzony", "90051452335", 2011, 1));
        prisonersDatabase.addPrisoner("Wiezienie centralne", new Prisoner("Jan", "Przedziwny", "91103145223", 2009, 4));
        prisonersDatabase.addPrisoner("Wiezienie centralne", new Prisoner("Janusz", "Podejrzany", "85121212456", 2012, 1));
        Finder suspects = new Finder(personDataProvider, prisonersDatabase);
        suspects.displayAllSuspectsWithName("Jan");
    }
}