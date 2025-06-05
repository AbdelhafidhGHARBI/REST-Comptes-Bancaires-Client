package tn.esprit.ressource;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import tn.esprit.entities.Compte;
import tn.esprit.service.CompteService;
import java.util.List;

@Path("/comptes")
public class CompteRessource {    CompteService service = new CompteService();
    // 5 usages
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Compte> getAll() {
        return service.getAll();    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Compte getById(@PathParam("id") int id) {
        return service.getById(id);    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @SecurityRolesAllowed("admin") // Remplacez "ADMIN" par le rôle approprié
    public Compte create(Compte c) {
        return service.add(c);    }

    @PUT
    @Path("/comptes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Compte update(@PathParam("id") int id, Compte c) {
        return service.update(id, c);    }

    @DELETE
    @Path("/comptes/{id}")
    public void delete(@PathParam("id") int id) {
        service.delete(id);    }

}