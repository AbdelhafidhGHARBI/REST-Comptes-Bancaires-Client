package tn.esprit;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class Main {
    public static void main(String[] args) {
        String baseUrl = "http://localhost:8080/api/comptes";
        Client client = ClientBuilder.newClient();

        // GET all
        System.out.println("Liste des comptes :");
        String all = client.target(baseUrl).request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(all);

        // POST un nouveau compte
        String newCompte = "{\"id\":3,\"proprietaire\":\"Mohamed\",\"solde\":2000000.0}";
        Response response = client.target(baseUrl)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(newCompte, MediaType.APPLICATION_JSON));
        System.out.println("Création: " + response.getStatus());
        System.out.println(response.readEntity(String.class));}
}