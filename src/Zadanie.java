import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class Zadanie extends Thread{

    private static int nextId = 1;
    private int id;
    private String nazwa;
    private String opis;
    private Stan stan;
    private LocalDateTime dataUtworzenia;
    private LocalDateTime dataZakonczenia;
    private int czasWykonania;

    public Zadanie(String nazwa, String opis) {
        this.id = nextId++;
        this.nazwa = nazwa;
        this.opis = opis;
        this.stan = Stan.UTWORZONE;
        this.dataUtworzenia = LocalDateTime.now();
        this.dataZakonczenia = null; // brak zakończenia
        this.czasWykonania = losujCzasWykonania();
    }

    public Zadanie(String nazwa, String opis, boolean zatwierdzenie) {
        this(nazwa, opis);
        if (zatwierdzenie) {
            this.stan = Stan.ROZPOCZETE;
        } else {
            // Niezatwierdzone zadanie
            this.stan = Stan.UTWORZONE;
        }
    }

    private int losujCzasWykonania() {
        Random random = new Random();
        return random.nextInt(6) + 3; // losowa wartość od 3 do 8
    }

    public Stan getStan() {
        return stan;
    }

    // Metoda uruchamiająca zadanie
    @Override
    public void run() {
        // Sprawdzanie czy wszystkie osoby w zespole są zdrowe
        boolean wszyscyZdrowi = true;
        for (Pracownik pracownik : getZespol().getListaPracownikow()) {
            if (!pracownik.CzyZdrowy()) {
                wszyscyZdrowi = false;
                break;
            }
        }

        if (wszyscyZdrowi) {
            // Rozpoczęcie zadania
            stan = Stan.ROZPOCZETE;
            System.out.println("Zadanie " + nazwa + " zostało rozpoczęte.");

            // Symulacja pracy
            try {
                Thread.sleep(czasWykonania * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Zakończenie zadania
            stan = Stan.ZAKONCZONE;
            dataZakonczenia = LocalDateTime.now();
            System.out.println("Zadanie " + nazwa + " zostało zakończone.");
        } else {
            // Nie można rozpocząć zadania, przynajmniej jeden pracownik jest chory
            System.out.println("Nie można rozpocząć zadania " + nazwa + ". Przynajmniej jeden pracownik jest chory.");
        }
    }

    // Metoda zwracająca czas wykonywania zadania
    public int getCzasWykonania() {
        return czasWykonania;
    }

    // Metoda zwracająca zespół, w którym znajduje się zadanie
    public Zespol getZespol() {
        // Implementacja zależy od Twojej struktury danych
        // Załóżmy, że zadanie jest przypisane bezpośrednio do zespołu
        return null;
    }

    @Override
    public String toString() {
        return "Zadanie{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", opis='" + opis + '\'' +
                ", stan=" + stan +
                ", dataUtworzenia=" + dataUtworzenia +
                ", dataZakonczenia=" + dataZakonczenia +
                ", czasWykonania=" + czasWykonania +
                '}';
    }
}