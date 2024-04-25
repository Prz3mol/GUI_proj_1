import java.util.ArrayList;
import java.util.List;

public class Zespol {
    int id;
    String nazwa;
    Manager manager;
    List<Pracownik> listaPracownikow;

    public Zespol(String nazwa, Manager manager, List<Pracownik> listaPracownikow) {
        this.id = id++;
        this.nazwa = nazwa;
        this.manager = manager;
        this.listaPracownikow = new ArrayList<>();
    }


    public void dodajPracownika(Pracownik pracownik){
        if (pracownik instanceof Manager)
            System.out.println("Manager nie może zostać dodany jako pracownik zespołu");
        listaPracownikow.add(pracownik);
    }
    public void dodajPracownikow(List<Pracownik> listaPracownikow){
        for (Pracownik pracownik : listaPracownikow){
            dodajPracownika(pracownik);
        }
    }


    @Override
    public String toString() {
        return "Zespol: " + nazwa + " Manager: " + manager + " Pracownicy" + listaPracownikow.toArray();

    }
}
