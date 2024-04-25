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

    @Override
    public void run() {
        // Logika wykonania zadania
    }

    @Override
    public String toString() {
        return "Zadanie{" +
                "nazwa='" + nazwa + '\'' +
                ", opis='" + opis + '\'' +
                ", stan=" + stan +
                ", dataUtworzenia=" + dataUtworzenia +
                ", dataZakonczenia=" + dataZakonczenia +
                ", czasWykonania=" + czasWykonania +
                '}';
    }
}