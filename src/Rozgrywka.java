import java.util.Random;

public class Rozgrywka extends Widok {
    public enum PoziomTrudnosci { LATWY, SREDNI, TRUDNY }
    private PoziomTrudnosci poziomTrudnosci;

    private int[] zakresLiczb;
    private int liczbaDoZgadniecia;
    private int maksymalnaLiczbaProb;
    private int maksymalnaLiczbaPunktow;
    private int aktualnaLiczbaProb;

    public Rozgrywka(PoziomTrudnosci poziomTrudnosci) {
        this.poziomTrudnosci = poziomTrudnosci;
        this.aktualnaLiczbaProb = 0;
        losujLiczbe(ustalZakres());

    }

    public int getLiczbaDoZgadniecia() {
        return liczbaDoZgadniecia;
    }

    public static int losujLiczbe(int zakres[]) {
        Random random = new Random();
        return random.nextInt(zakres[0],zakres[1]);
    }

    public void sprawdz(int liczba, int liczbaDoZgadniecia) {
        this.liczbaDoZgadniecia = liczbaDoZgadniecia;
        if (liczba == liczbaDoZgadniecia) {
            wyswietlPodpowiedzi("Liczba jest liczba do zgadniecia");
        }
        else if (liczba > liczbaDoZgadniecia) {
            wyswietlPodpowiedzi("Liczba jest wieksza od liczby do zgadniecia");
        }
        else wyswietlPodpowiedzi("Liczba jest mniejsza od liczby do zgadniecia");

    }
    public int[] ustalZakres() {
        switch (poziomTrudnosci) {
            case LATWY:
                return zakresLiczb = new int[] {1, 500};
            case SREDNI:
                return zakresLiczb = new int[] {1, 100};
            case TRUDNY:
                return zakresLiczb = new int[] {1, 2000};
            default:
                throw new IllegalArgumentException("Nieprawidłowy poziom trudności");
        }
    }

    public static int aktualizacjaPunktow(int liczbaPunktow) {
        return liczbaPunktow -= (liczbaPunktow * 0.1);

    }
    public void aktualizacjaLiczbProb(){
        this.aktualnaLiczbaProb = aktualnaLiczbaProb-1;
    }


}
