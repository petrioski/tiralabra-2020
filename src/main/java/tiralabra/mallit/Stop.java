package tiralabra.mallit;
import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.base.MoreObjects.ToStringHelper;

@JsonRootName("data")
public class Stop implements Comparator<Pysakki> {
    private String gtfsId;
    private String name;
    private String code;
    private String vehicleMode;
    private Double lat;
    private Double lon;
    private String stop;

    public Stop(String gtfsId, String name, String code, String vehicleMode, Double lat, Double lon) {
        this.gtfsId = gtfsId;
        this.name = name;
        this.code = code;
        this.vehicleMode = vehicleMode;
        this.lat = lat;
        this.lon = lon;
    }

    public void setGtfsId(String gtfsId) {
        this.gtfsId = gtfsId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setVehicleMode(String vehicleMode) {
        this.vehicleMode = vehicleMode;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public Stop() {

    }

    public String toString() {
        return "{" +this.gtfsId + "\n"
                + this.name + "\n"
                + this.code + "\n"
                + this.vehicleMode + "\n"
                + this.lat + "\n"
                + this.lon + "}";
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
