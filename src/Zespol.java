import java.util.ArrayList;
import java.util.List;

public class Zespol {
    int id;
    String nazwa;
    Manager manager;
    List<Pracownik> pracownicy;

    public Zespol(String nazwa, Manager manager, List<Pracownik> pracownicy) {
        this.id = id++;
        this.nazwa = nazwa;
        this.manager = manager;
        this.pracownicy = new ArrayList<>();
    }


    public Zespol(String nazwa) {
        this.nazwa = nazwa;
        this.pracownicy = new ArrayList<>();
    }

    public void dodajPracownika(Pracownik pracownik) {
        if (!(pracownik instanceof Manager)) {
            pracownicy.add(pracownik);
        }
    }

    public void dodajPracownikow(List<Pracownik> pracownicy) {
        for (Pracownik pracownik : pracownicy) {
            dodajPracownika(pracownik);
        }
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Pracownik> getPracownicy() {
        return pracownicy;
    }

    @Override
    public String toString() {
        return "Zespol{" +
                "nazwa='" + nazwa + '\'' +
                ", manager=" + manager +
                ", pracownicy=" + pracownicy +
                '}';
    }
}
