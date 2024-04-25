import java.util.Date;

public class Recepcjonista extends Pracownik{
    String login, haslo;
    String initial;

    public Recepcjonista(String imie, String nazwisko, Date dataUrodzenia, DzialPracownikow dzialPracownikow, String login, String haslo) {
        super(imie, nazwisko, dataUrodzenia, dzialPracownikow);
        this.login = login;
        this.haslo = haslo;
    }

    private String getLogin() {
        return login;
    }

    private String getHaslo() {
        return haslo;
    }

    public String getInitial() {
        return initial;
    }

    public void setImie(String imie) {
        super.setImie(imie);
        this.initial = generujInitial(imie, getNazwisko());
    }

    public void setNazwisko(String nazwisko) {
        super.setNazwisko(nazwisko);
        this.initial = generujInitial(getImie(), nazwisko);
    }
    private static String generujInitial(String imie, String nazwisko){
        return Character.toString(imie.charAt(0)) + Character.toString(nazwisko.charAt(0));
    }
}
