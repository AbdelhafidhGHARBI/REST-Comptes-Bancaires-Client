package tn.esprit.ressource;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Path("/authentification")
public class AuthentificationEndPoint {
    @Context
    private UriInfo uriInfo;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("username") String username,
                                     @FormParam("password") String password) {
        try {
            // Ici, on vérifie username/password (en dur ou en DB)
            authenticate(username, password);

            // Générer le token JWT
            String token = issueToken(username);

            // Retourner le token au client
            return Response.ok(token).build();
        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    private void authenticate(String username, String password) throws Exception {
        // Exemple basique : authentification statique (à adapter à ta logique)
        System.out.println("Reçu -> username: " + username + ", password: " + password);

        if (!"admin".equals(username) || !"admin123".equals(password)) {
            throw new Exception("Invalid credentials");
        }
    }

    private String issueToken(String username) {
        String keyString = "simplekey"; // clé secrète à protéger en prod
        Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");

        String jwtToken = Jwts.builder()
                .setSubject(username)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(LocalDateTime.now().plusMinutes(15L)
                        .atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();

        return jwtToken;
    }

}
