import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileMenager {

    public static void write(String text, int punkty) {
        try {
            FileWriter writer = new FileWriter("zapis.txt");
            writer.write(text + punkty);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public static void write(String text,int punkty,String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(text + " "+ punkty "");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public static List<String> wczytajNajlepszychGraczy() {
        List<String> najlepsiGracze = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("najlepsi-gracze.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                najlepsiGracze.add(line);
            }
        } catch (IOException e) {
            System.out.println("Błąd podczas wczytywania najlepszych graczy.");
            e.printStackTrace();
        }
        return najlepsiGracze;
    }
}