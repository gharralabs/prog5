package app;

import br.gharralabs.services.*;
import java.util.Scanner;


public class Program {

    public static void main(String[] args) {

        HelloServiceImplService fábrica;
        fábrica = new HelloServiceImplService();
        
        HelloServiceImpl serviço;
        serviço = fábrica.getHelloServiceImplPort();
        
        String nome, resposta;
        
        System.out.println("Informe o seu nome:");
        Scanner scanner;
        scanner = new Scanner(System.in);
        nome = scanner.nextLine();
        
        resposta = serviço.cumprimentar(nome);
        
        System.out.println(resposta);
    }
}
