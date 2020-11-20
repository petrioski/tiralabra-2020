package tiralabra.mallit;
import java.util.Comparator;

public class Pysakki implements Comparator<Pysakki> {
    private Integer matka;
    private Integer pysakinId;
    private String code;
    private Double lat;
    private Double lon;

    public Pysakki(int id, int matka) {
        this.matka = matka;
        this.pysakinId = id;
    }

    public Pysakki() {

    }

    public Integer getMatka() {
        return matka;
    }

    public Integer getPysakinId() {
        return pysakinId;
    }

    @Override
    public int compare(Pysakki tama, Pysakki toinen) {
        int tamaMatka = tama.getMatka();
        int toinenMatka = toinen.getMatka();
        if (tamaMatka < toinenMatka) {
            return -1;
        } else if (tamaMatka == toinenMatka) {
            return 0;
        } else {
            return 1;
        }
    }
}
