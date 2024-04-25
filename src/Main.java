import java.util.ArrayList;
import java.util.Map;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws NotUniqueNameException{
        System.out.println("Hello world!");
        System.out.println();
        Date birthdate = new Date();

        System.out.println("-----------------------------------------------------------");
        DzialPracownikow dzial1 = DzialPracownikow.createDzial("Sprzedaz");
        DzialPracownikow dzial2 = DzialPracownikow.createDzial("Marketing");

        Trener trener = new Trener("Tomek", "Abc",  birthdate, dzial1, "Sprzedaz");
        Trener trener2 = new Trener("Adam", "Dac",  birthdate, dzial2, "Marketing");



        System.out.println("Pracownicy działu 'Sprzedaż': " + dzial1.getPracownicy());
        System.out.println("Pracownicy działu 'Marketing': " + dzial2.getPracownicy());


        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(DzialPracownikow.pobierzDzial("Sprzedaz"));
        System.out.println(DzialPracownikow.pobierzDzial("Marketing"));
        System.out.println();

        for (Map.Entry<String, DzialPracownikow> entry : DzialPracownikow.getDzialy().entrySet()) {
            String nazwaDzialu = entry.getKey();
            DzialPracownikow dzial = entry.getValue();
            System.out.println("Nazwa działu: " + nazwaDzialu);
            System.out.println("Pracownicy działu: " + dzial.getPracownicy());
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println(Pracownik.getListaPracownikow());
        Pracownik.ustawKryteriumSortowania(Pracownik.KryteriumSortowania.DZIAL);
        Pracownik.sortujListe();
        System.out.println(Pracownik.getListaPracownikow());
        Pracownik.ustawKryteriumSortowania(Pracownik.KryteriumSortowania.NAZWISKO);
        Pracownik.sortujListe();
        System.out.println(Pracownik.getListaPracownikow());

    }
}