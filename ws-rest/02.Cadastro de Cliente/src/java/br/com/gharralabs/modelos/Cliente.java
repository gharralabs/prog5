package br.com.gharralabs.modelos;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cliente 
{
    private long Id;
    private String nome;
    private float salario;
    private List<Endereco> enderecos;

    public List<Endereco> getEnderecos()
    {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos)
    {
        this.enderecos = enderecos;
    }
    
    public long getId()
    {
        return Id;
    }

    public void setId(long Id)
    {
        this.Id = Id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public float getSalario()
    {
        return salario;
    }

    public void setSalario(float salario)
    {
        this.salario = salario;
    }

}
