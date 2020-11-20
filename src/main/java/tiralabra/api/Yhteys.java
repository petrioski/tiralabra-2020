package tiralabra.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.net.HttpHeaders;


import tiralabra.mallit.Stop;


public class Yhteys {
    HttpClient client;
    // HttpRequest request;

    public Yhteys() {
        this.client = HttpClient.newHttpClient();
    }

    public void teePyynto(String osoite, String kysely) throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                                .uri(URI.create(osoite))
                                .setHeader(HttpHeaders.CONTENT_TYPE, "application/graphql")
                                .POST(HttpRequest.BodyPublishers.ofString(kysely))
                                .build();
        HttpResponse<String> vastaus = this.client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(vastaus.body());

        JsonNode json = new ObjectMapper().readTree(vastaus.body());
        System.out.println("json luku");
        var stop = json.get("data").get("stop");
        System.out.println("eka jsonin purku");
        System.out.println(stop);

        var p = new Stop();
        System.out.println("kokeilu osista");
        p.setGtfsId(stop.get("gtfsId").asText());
        p.setName(stop.get("name").asText());
        p.setCode(stop.get("code").asText());
        p.setVehicleMode(stop.get("vehicleMode").asText());
        p.setLat(stop.get("lat").asDouble());
        p.setLon(stop.get("lon").asDouble());

        System.out.println("osista luettu");
        System.out.println(p);





    }

}
