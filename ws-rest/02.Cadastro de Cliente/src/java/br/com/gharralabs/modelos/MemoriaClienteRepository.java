package br.com.gharralabs.modelos;

import br.com.gharralabs.modelos.Cliente;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class MemoriaClienteRepository implements ClienteRepository {
    
    private static final List<Cliente> clientes = new ArrayList<>();
    
    static
    {
        
        clientes.add(new Cliente());
        clientes.get(0).setId(1L);
        clientes.get(0).setNome("Joaquim José da Silva Xavier");
        clientes.get(0).setSalario(1000.0f);
           
        clientes.add(new Cliente());
        clientes.get(1).setId(2L);
        clientes.get(1).setNome("Maria del Barrio");
        clientes.get(1).setSalario(9999.0f);
        
        clientes.add(new Cliente());
        clientes.get(2).setId(3L);
        clientes.get(2).setNome("Dom Pedro");
        clientes.get(2).setSalario(780.0f);  
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
}
