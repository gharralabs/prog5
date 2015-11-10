package br.com.gharralabs.resources;

import br.com.gharralabs.modelos.*;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/v1/cliente")
public class ClienteResource {

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> obterTodosPorNome(@QueryParam("nome") String nome)
    {
        ClienteRepository repo;
        repo = new MemoriaClienteRepository();
        List<Cliente> c;
        
        if( nome == null )
            c = repo.obterTodos();
        else
            c = repo.obterTodosPorNome(nome);
        
        return c;
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response salvar(Cliente cliente)
    {
        ClienteRepository repo;
        repo = new MemoriaClienteRepository();       
        repo.inserir(cliente);

        URI uri = URI.create("/cliente/" + cliente.getId());
        
        return Response.created(uri)
                       .entity(cliente)
                       .build();
    }
    
}
