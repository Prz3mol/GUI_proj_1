import java.util.Date;

public class Trener extends Pracownik{
    String specjalizacja;

    public Trener(String imie, String nazwisko, Date dataUrodzenia, DzialPracownikow dzialPracownikow, String specjalizacja) {
        super(imie, nazwisko, dataUrodzenia, dzialPracownikow);
        this.specjalizacja = specjalizacja;
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    @Override
    public String toString() {
        return  " [ "+ this.getId()+ " " + getImie()+ " " + getNazwisko() + " " +  getSpecjalizacja()  + " ]   ";
    }
}
