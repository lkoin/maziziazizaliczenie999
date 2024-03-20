import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gracz gracz1 = new Gracz("Edumnd");
        List<String> najlepsiGracze = FileMenager.wczytajNajlepszychGraczy();
        System.out.println("Najlepsi gracze:");
        for (String gracz : najlepsiGracze) {
            System.out.println(gracz);
        }
        boolean rozgrywkaIsTrue = true;
        while (rozgrywkaIsTrue == true) {
            Widok.wyswietlMenu();
            int number = scanner.nextInt();
            switch (number) {
                case 1 -> {
                    gra(1000, Rozgrywka.PoziomTrudnosci.LATWY);
                }
                case 2 -> {
                    gra(2000,Rozgrywka.PoziomTrudnosci.SREDNI);
                }
                case 3 -> {
                    gra(5000,Rozgrywka.PoziomTrudnosci.TRUDNY);
                }
                case 4 -> {
                    rozgrywkaIsTrue = false;
                    break;
                }

            }
        }

    }

    public static void gra(int punkty, Rozgrywka.PoziomTrudnosci poziomTrudnosci){
        Scanner scanner = new Scanner(System.in);
        Gracz gracz = new Gracz("Gracz");
        Rozgrywka rozgrywka = new Rozgrywka(poziomTrudnosci);
        int liczbaDoZgadniecia = rozgrywka.losujLiczbe(rozgrywka.ustalZakres());
        int proby = 10;
        while (true) {
            Widok.wyswietlPodpowiedzi("Podaj swoją propozycję liczby:");
            int zgadywanaLiczba = scanner.nextInt();
            rozgrywka.sprawdz(zgadywanaLiczba,liczbaDoZgadniecia);
            if (zgadywanaLiczba == liczbaDoZgadniecia) {
                Widok.wyswietlWynik("Gratulacje! Wygrałeś!", punkty);
                FileMenager.write("Punkty: ",punkty);
                System.out.println("Zapisano tekst do pliku.");
                FileMenager.write(gracz.getNazwa(), punkty,"najlepsi-gracze.txt");
                break;
            } else {
                punkty = rozgrywka.aktualizacjaPunktow(punkty);
                rozgrywka.aktualizacjaLiczbProb();
                System.out.println(liczbaDoZgadniecia);
                if(proby == 0) {
                    Widok.wyswietlWynik("Przegrałeś", 0);
                    Widok.wyswietlWynik("Gratulacje! Wygrałeś!", punkty);
                    FileMenager.write("Punkty: ",punkty);
                    System.out.println("Zapisano tekst do pliku.");
                    break;
                }
                else proby--;
            }
        }
    }
}
