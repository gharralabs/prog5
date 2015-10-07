package br.gharralabs.services;

import javax.jws.WebService;

@WebService
public class HelloServiceImpl implements HelloService {

    @Override
    public String cumprimentar(String nome)
    {
        return "Olá, " + nome;
    }
}
