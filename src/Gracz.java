public class Gracz {
    private String nazwa;
    private int liczbaPunktow;
    private int liczbaPozostałychProb;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getLiczbaPunktow() {
        return liczbaPunktow;
    }

    public void setLiczbaPunktow(int liczbaPunktow) {
        this.liczbaPunktow = liczbaPunktow;
    }

    public int getLiczbaPozostałychProb() {
        return liczbaPozostałychProb;
    }

    public void setLiczbaPozostałychProb(int liczbaPozostałychProb) {
        this.liczbaPozostałychProb = liczbaPozostałychProb;
    }

    public Gracz(String nazwa) {
        this.nazwa = nazwa;
    }

    public void aktaulizacjaLiczbyPunktow() {
        this.liczbaPunktow -= 1;
    }
}
