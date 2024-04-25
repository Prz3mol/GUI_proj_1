import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manager extends Recepcjonista {
    private List<Zespol> zespoly;
    private List<Zadanie> zadania;


    public Manager(String imie, String nazwisko, Date dataUrodzenia, DzialPracownikow dzialPracownikow, String login, String haslo) {
        super(imie, nazwisko, dataUrodzenia, dzialPracownikow, login, haslo);
        this.zespoly = new ArrayList<>();
        this.zadania = new ArrayList<>();
    }

    public List<Zespol> getZespoly() {
        return zespoly;
    }

    public List<Zadanie> getZadania() {
        return zadania;
    }

    // Metoda dodająca zespół, jeśli menadżer nie jest już przypisany do niego
    public void dodajZespol(Zespol zespol) {
        if (!zespol.getPracownicy().contains(this)) {
            zespoly.add(zespol);
            zespol.setManager(this);
        }
    }

    // Metoda usuwająca zespół, jeśli menadżer jest przypisany do niego
    public void usunZespol(Zespol zespol) {
        if (zespoly.contains(zespol)) {
            zespoly.remove(zespol);
            zespol.setManager(null);
        }
    }

    // Metoda dodająca zadanie do listy zadań menadżera
    public void dodajZadanie(Zadanie zadanie) {
        zadania.add(zadanie);
    }

    // Metoda usuwająca zadanie z listy zadań menadżera
    public void usunZadanie(Zadanie zadanie) {
        zadania.remove(zadanie);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "imie='" + getImie() + '\'' +
                ", nazwisko='" + getNazwisko() + '\'' +
                ", zespoly=" + zespoly +
                ", zadania=" + zadania +
                '}';
    }
}

