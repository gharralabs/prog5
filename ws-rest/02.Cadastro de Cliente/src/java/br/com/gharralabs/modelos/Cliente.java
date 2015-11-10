package br.com.gharralabs.modelos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cliente 
{
    private long Id;
    private String nome;
    private float salario;
    
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
