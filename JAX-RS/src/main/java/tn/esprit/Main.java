package tn.esprit;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jsonb.JsonBindingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import java.net.URI;

public class Main {

    public static final String BASE_URI = "http://localhost:8080/api/";
    public static HttpServer startServer() {
// Crée un objet ResourceConfig qui enregistre les packages à scanner
        final ResourceConfig rc = new ResourceConfig()
                .packages("tn.esprit") // <-- à adapter à ton package
                .register(JsonBindingFeature.class); // <-- enregistrement du support JSON

        return GrizzlyHttpServerFactory.createHttpServer (URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) {
        final HttpServer server = startServer();
        System.out.printf("Serveur démarré sur %s%n",BASE_URI);
    }
}