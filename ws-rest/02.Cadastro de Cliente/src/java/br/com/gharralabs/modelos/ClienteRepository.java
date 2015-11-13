package br.com.gharralabs.modelos;

import java.util.List;

public interface ClienteRepository
{
    void inserir(Cliente cliente);
    List<Cliente> obterTodos();
    public List<Cliente> obterTodosPorNome(String nome);
    public Cliente obterPorId(long id);

    public void remover(long id);
    
}
