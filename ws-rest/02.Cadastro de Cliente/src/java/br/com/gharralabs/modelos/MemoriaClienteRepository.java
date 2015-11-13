package br.com.gharralabs.modelos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class MemoriaClienteRepository implements ClienteRepository {
    
    private static final List<Cliente> clientes = new ArrayList<>();
    
    static
    {
        
        clientes.add(new Cliente());
        clientes.get(0).setId(1L);
        clientes.get(0).setNome("Joaquim José da Silva Xavier");
        clientes.get(0).setSalario(1000.0f);
        clientes.get(0).setEnderecos(new ArrayList<>());
        clientes.get(0).getEnderecos().add(new Endereco());
        clientes.get(0).getEnderecos().get(0).setLogradouro("Avenida Affonso Penna");
        clientes.get(0).getEnderecos().get(0).setNumero(297);
        clientes.get(0).getEnderecos().get(0).setBairro("Tarumã");
        clientes.get(0).getEnderecos().get(0).setMunicipio("Curitiba");
        clientes.get(0).getEnderecos().get(0).setUF("PR");
        clientes.get(0).getEnderecos().get(0).setCEP(82530280);
        
        clientes.get(0).getEnderecos().add(new Endereco());
        clientes.get(0).getEnderecos().get(1).setLogradouro("Rua Itupava");
        clientes.get(0).getEnderecos().get(1).setNumero(737);
        clientes.get(0).getEnderecos().get(1).setBairro("Juvevê");
        clientes.get(0).getEnderecos().get(1).setMunicipio("Curitiba");
        clientes.get(0).getEnderecos().get(1).setUF("PR");
        clientes.get(0).getEnderecos().get(1).setCEP(80040134);        
        
        
        
           
        clientes.add(new Cliente());
        clientes.get(1).setId(2L);
        clientes.get(1).setNome("Maria del Barrio");
        clientes.get(1).setSalario(9999.0f);
        
        clientes.get(1).setEnderecos(new ArrayList<>());
        clientes.get(1).getEnderecos().add(new Endereco());
        clientes.get(1).getEnderecos().get(0).setLogradouro("Rua Dr. Pedrosa");
        clientes.get(1).getEnderecos().get(0).setNumero(123);
        clientes.get(1).getEnderecos().get(0).setBairro("Centro");
        clientes.get(1).getEnderecos().get(0).setMunicipio("Curitiba");
        clientes.get(1).getEnderecos().get(0).setUF("PR");
        clientes.get(1).getEnderecos().get(0).setCEP(80420120);
        
        
        clientes.add(new Cliente());jon
        clientes.get(2).setId(3L);
        clientes.get(2).setNome("Dom Pedro");
        clientes.get(2).setSalario(780.0f);  
        
        clientes.get(2).setEnderecos(new ArrayList<>());
        clientes.get(2).getEnderecos().add(new Endereco());
        clientes.get(2).getEnderecos().get(0).setLogradouro("Rua Miguel Bertolino Pizatto");
        clientes.get(2).getEnderecos().get(0).setNumero(1901);
        clientes.get(2).getEnderecos().get(0).setBairro("Jardim Iguaçu");
        clientes.get(2).getEnderecos().get(0).setMunicipio("Araucária");
        clientes.get(2).getEnderecos().get(0).setUF("PR");
        clientes.get(2).getEnderecos().get(0).setCEP(83701050);
    }
    
    
    @Override
    public List<Cliente> obterTodos()
    {
        return clientes;
    }

    @Override
    public void inserir(Cliente cliente)
    {
        long id = clientes.stream()
                          .max(Comparator.comparing(p -> p.getId()))
                          .get()
                          .getId() + 1L;
        
        cliente.setId(id);
        clientes.add(cliente);
    }

    @Override
    public List<Cliente> obterTodosPorNome(String nome)
    {
        return clientes.stream()
                       .filter(c -> c.getNome().contains(nome) == true)
                       .collect(Collectors.toList());
    }

    @Override
    public Cliente obterPorId(long id)
    {
        List<Cliente> clis = clientes.stream()  
                .filter(c -> c.getId() == id)
                .collect(Collectors.toList());
        
        Cliente cliente = null;
        
        if(!clis.isEmpty())
            cliente = clis.get(0);
            
        return cliente;
           
    }

    @Override
    public void remover(long id)
    {
        Cliente cliente;
        cliente = obterPorId(id);
        
        if(cliente != null)
            clientes.remove(cliente);
    }
}
