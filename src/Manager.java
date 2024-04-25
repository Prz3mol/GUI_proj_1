import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manager extends Recepcjonista{
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
}

