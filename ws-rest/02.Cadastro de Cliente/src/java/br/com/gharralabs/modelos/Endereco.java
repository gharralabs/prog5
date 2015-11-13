package br.com.gharralabs.modelos;


public class Endereco {

    private long id;
    private String logradouro;
    private int numero;
    private String complemento;
    private String municipio;
    private String bairro;
    private String UF;
    private int CEP;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getLogradouro()
    {
        return logradouro;
    }

    public void setLogradouro(String logradouro)
    {
        this.logradouro = logradouro;
    }

    public int getNumero()
    {
        return numero;
    }

    public void setNumero(int numero)
    {
        this.numero = numero;
    }

    public String getComplemento()
    {
        return complemento;
    }

    public void setComplemento(String complemento)
    {
        this.complemento = complemento;
    }

    public String getMunicipio()
    {
        return municipio;
    }

    public void setMunicipio(String municipio)
    {
        this.municipio = municipio;
    }

    public String getBairro()
    {
        return bairro;
    }

    public void setBairro(String bairro)
    {
        this.bairro = bairro;
    }

    public String getUF()
    {
        return UF;
    }

    public void setUF(String UF)
    {
        this.UF = UF;
    }

    public int getCEP()
    {
        return CEP;
    }

    public void setCEP(int CEP)
    {
        this.CEP = CEP;
    }
}
