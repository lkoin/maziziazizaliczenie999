public class Widok {
    public static void wyswietlPodpowiedzi (String podpowiedz) {
        System.out.println(podpowiedz);
    }

    public static void wyswietlMenu() {
        System.out.println("Wybierz poziom trudności:");
        System.out.println("1. Łatwy (1-500)");
        System.out.println("2. Średni (1-1000)");
        System.out.println("3. Trudny (1-2000)");
        System.out.println("4. Wyjscie");
    }

    public static void wyswietlWynik(String wynik, int aktualnaLiczbaPunktow) {
        System.out.println(wynik);
        System.out.println("Uzyskane punkty: " + aktualnaLiczbaPunktow);
    }
}
