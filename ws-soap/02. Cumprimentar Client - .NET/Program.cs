using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using _02.Cumprimentar_Client__.NET.br.gharralabs.services;

namespace _02.Cumprimentar_Client__.NET
{
    class Program
    {
        static void Main(string[] args)
        {
            HelloServiceImplClient cliente;
            cliente = new HelloServiceImplClient();

            String nome, resposta;

            Console.WriteLine("Informe o seu nome:");
            nome = Console.ReadLine();

            resposta = cliente.cumprimentar(nome);
            Console.WriteLine(resposta);
            Console.ReadKey();
        }
    }
}
