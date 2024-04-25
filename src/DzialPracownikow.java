import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class DzialPracownikow {

    private String nazwa;
    private static Map<String, DzialPracownikow> dzialy = new HashMap<>();
    private List<String> pracownicy;

    private DzialPracownikow(String nazwa) {
        this.nazwa = nazwa;
        this.pracownicy = new ArrayList<>();

    }
    public String pobierzNazwe() {
        return nazwa;
    }

    public static DzialPracownikow createDzial(String nazwa) throws NotUniqueNameException {
        try {
            if (dzialy.containsKey(nazwa)) {
                throw new NotUniqueNameException("Nazwa dzialu musi być unikalna");
            }
            DzialPracownikow nowyDzial = new DzialPracownikow(nazwa);
            dzialy.put(nazwa, nowyDzial);
            return nowyDzial;
        }catch (NotUniqueNameException e){
            System.out.println("Blad" + e.getMessage());
        }
        return null;
    }

    public void dodajPracownika(String nazwa, String nazwisko){
        pracownicy.add(nazwa);
    }

    public List<String> getPracownicy() {
        return pracownicy;
    }
    public static Map<String, DzialPracownikow> getDzialy() {
        return dzialy;
    }
    public static  DzialPracownikow pobierzDzial(String klucz){
        return dzialy.get(klucz);
    }

    @Override
    public String toString() {
        return "DzialPracownikow{" +
                "nazwa='" + nazwa + '\'' +
                ", pracownicy=" + pracownicy +
                '}';
    }
}