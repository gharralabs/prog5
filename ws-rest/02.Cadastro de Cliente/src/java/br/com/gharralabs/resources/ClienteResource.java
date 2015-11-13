package br.com.gharralabs.resources;

import br.com.gharralabs.modelos.*;
import java.net.URI;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

// RFC7231 
@Path("/v1/clientes")
public class ClienteResource {

    ClienteRepository repositório = new MemoriaClienteRepository();
    
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> obter(@QueryParam("nome") String nome)
    {

        List<Cliente> c;
        
        if( nome == null )
            c = repositório.obterTodos();
        else
            c = repositório.obterTodosPorNome(nome);
        
        return c;
    }
    
    
    @GET
    @Path("{id}/enderecos")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Endereco> obterEnderecosPorCliente(@PathParam("id") long id)
    {
        Cliente cliente;
        cliente = repositório.obterPorId(id);
        
        if(cliente == null )
            throw new WebApplicationException(404);
        
        List<Endereco> enderecos;
        enderecos = cliente.getEnderecos();
        
        return enderecos;
    }
    
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response inserir(Cliente cliente)
    {
        repositório.inserir(cliente);

        URI uri = URI.create("/cliente/" + cliente.getId());
        
        return Response.created(uri)
                       .entity(cliente)
                       .build();
    }
    
    
    @PUT
    public void atualizar(Cliente c)
    {
        Cliente cliente;
        cliente = repositório.obterPorId(c.getId());
        if(cliente == null)
            throw new WebApplicationException("Não foi possível atualizar o cliente. Id inválido");
        
        cliente.setNome(c.getNome());
        cliente.setSalario(c.getSalario());
    }
    
    
    @DELETE
    @Path("{id}")
    public void apagar(@PathParam("id") long id)
    {
        /*
        If a DELETE method is successfully applied, the origin server SHOULD
        send a 202 (Accepted) status code if the action will likely succeed
        but has not yet been enacted, a 204 (No Content) status code if the
        action has been enacted and no further information is to be supplied,
        or a 200 (OK) status code if the action has been enacted and the
        response message includes a representation describing the status.
        */
        
        
        repositório.remover(id);
    }
    
}
