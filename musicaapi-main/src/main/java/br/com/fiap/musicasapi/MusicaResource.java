package br.com.fiap.musicasapi;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.musicas.model.Musica;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.MusicaService;

@Path("musica")
public class MusicaResource {
	
	private MusicaService service = new MusicaService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Musica> listAll() throws SQLException {
        return service.findAll(); 
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) throws SQLException {
    	var serie = service.findById(id);
    	    	
    	if (serie == null) {
    		return Response.status(404).build();
    	}
    	
    	return Response.ok(serie).build();
    }
    
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) throws SQLException {
    	var musica = service.findById(id);
    	
    	if(musica == null)
    		return Response.status(404).build();
    	
    	service.delete(musica);
    	return Response.status(Response.Status.NO_CONTENT).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(Musica musica){
    	if (!service.save(musica)) {
    		return Response.status(Response.Status.BAD_REQUEST).build();
    	}
    	
    	return Response.ok(musica).build();
    	
    }
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@PathParam("id") Long id, Musica musica) throws SQLException {
    	var musicaEncontrada = service.findById(id);
    	
    	if(musicaEncontrada == null)
    		return Response.status(Response.Status.NOT_FOUND).build();
    			
    			
    	if (!service.update(musica))
    		return Response.status(Response.Status.BAD_REQUEST).build();
    	
    	return Response.ok(musica).build();
    	
    }
    
    
    
    
    
    
    
    
    
    
}
