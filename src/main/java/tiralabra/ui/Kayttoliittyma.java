package tiralabra.ui;
import java.util.Scanner;

public class Kayttoliittyma {
    private Scanner lukija;
    private String viesti;

    public Kayttoliittyma() {
        this.lukija = new Scanner(System.in);
        this.viesti = "";
    }

    public void kaynnista() {
        while (!viesti.equals("lopeta")) {
            System.out.println("Syöta pysäkki, \"lopeta\" lopettaa");
            this.viesti = this.lukija.nextLine();
            System.out.println("Syotit " + this.viesti);
        }
    }
}
