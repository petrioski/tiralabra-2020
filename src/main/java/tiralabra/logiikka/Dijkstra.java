package tiralabra.logiikka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import tiralabra.mallit.Pysakki;

public class Dijkstra {
    private HashSet<Integer> tarkastetut;
    private PriorityQueue<Pysakki> pysakitPQ;
    private HashMap<Integer, Integer> etaisyydet;
    private Integer pysakkienMaara;
    private ArrayList<ArrayList<Pysakki>> kartta;

    public Dijkstra(int pysakkienMaara) {
        this.pysakkienMaara = pysakkienMaara;
        this.etaisyydet = new HashMap<>();
        this.tarkastetut = new HashSet<Integer>();
        this.pysakitPQ = new PriorityQueue<Pysakki>(this.pysakkienMaara, new Pysakki());
    }

    public void etsiPolut(ArrayList<ArrayList<Pysakki>> kartta, int lahtoId, int maaliId) {
        this.kartta = kartta;
        pysakitPQ.add(new Pysakki(lahtoId, 0));

        etaisyydet.put(lahtoId, 0);

        var perilla = false;
        while (!perilla) {
            if (pysakitPQ.size() > 0) {
                var seuraava = pysakitPQ.poll();
                tarkastetut.add(seuraava.getPysakinId());

                if (seuraava.getPysakinId() == maaliId) {
                    break;
                }

                this.vertaile(seuraava.getPysakinId());
            } else {
                System.out.println("Reittiä ei löytynyt");;
                break;
            }

        }
    }

    private void vertaile(int nykyinen) {
        int uusiEtaisyys = -1;
        int ISO_LUKU = 1_000_000;
        for (int i = 0; i < kartta.get(nykyinen).size(); i++) { // naapyreiden määrä
            Pysakki naapuri = kartta.get(nykyinen).get(i); // seuraava naapuyripysakki

            if (!tarkastetut.contains(naapuri.getPysakinId())) {      // onko jo tarkastettu, jos ei niin jatkoon
                uusiEtaisyys = etaisyydet.get(nykyinen) + naapuri.getMatka();         // hae matka
                int vanhaEtaisyys = etaisyydet.getOrDefault(naapuri.getPysakinId(), ISO_LUKU);

                if (uusiEtaisyys < vanhaEtaisyys) {
                    etaisyydet.put(naapuri.getPysakinId(), uusiEtaisyys);
                }
                this.pysakitPQ.add(new Pysakki(naapuri.getPysakinId(), etaisyydet.get(naapuri.getPysakinId())));
            }
        }
    }

    public HashMap<Integer, Integer> tulos() {
        return this.etaisyydet;
    }
}
