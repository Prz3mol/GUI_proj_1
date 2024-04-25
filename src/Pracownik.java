import java.util.*;

public abstract class Pracownik implements Comparable<Pracownik>{
    private static List<Pracownik> listaPracownikow = new ArrayList<>();

    private int id;
    private static int idCounter = 0;
    private String imie, nazwisko;
    private Date dataUrodzenia;
    private DzialPracownikow dzialPracownikow;
    private boolean czyZdrowy=true;
    private static KryteriumSortowania kryteriumSortowania = KryteriumSortowania.IMIE;

    public Pracownik(String imie, String nazwisko, Date dataUrodzenia, DzialPracownikow dzialPracownikow) {
        this.id = ++idCounter;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.dzialPracownikow = dzialPracownikow;
        this.czyZdrowy = true;
        dzialPracownikow.dodajPracownika(imie, nazwisko);
        listaPracownikow.add(this);
    }

    public static List<Pracownik> getListaPracownikow() {
        return listaPracownikow;
    }

    public int getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public DzialPracownikow getDzialPracownikow() {
        return dzialPracownikow;
    }

    public boolean CzyZdrowy() {
        return czyZdrowy;
    }

    public void setCzyZdrowy(boolean czyZdrowy) {
        this.czyZdrowy = czyZdrowy;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public static void sortujListe(){
        Collections.sort(listaPracownikow);

    }
    public enum KryteriumSortowania {
        IMIE,DZIAL,ID,NAZWISKO
    }
    public static void ustawKryteriumSortowania(KryteriumSortowania kryterium){
        kryteriumSortowania = kryterium;
    }

    @Override
    public int compareTo(Pracownik o) {
        switch (kryteriumSortowania) {
            case IMIE:
                int i = this.imie.compareTo(o.imie);
                if (i != 0) {
                    return i;
                }
                return this.nazwisko.compareTo(o.nazwisko);

            case NAZWISKO:
                int result = this.nazwisko.compareTo(o.nazwisko);
                if (result != 0){
                    return result;
                }
                return this.imie.compareTo(o.imie);
            case  DZIAL:
                return this.dzialPracownikow.pobierzNazwe().compareTo(o.dzialPracownikow.pobierzNazwe());
            case  ID:
                return this.id - o.id;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                " id " + id + '\'' +
                " imie= '" + imie + '\'' +
                ", nazwisko= '" + nazwisko + '\'' +
                ", dataUrodzenia= " + dataUrodzenia +
                ", dzialPracownikow =" + dzialPracownikow +
                ", czyZdrowy =" + czyZdrowy +
                '}';
    }
}