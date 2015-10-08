package br.gharralabs.controllers;

import br.gharralabs.services.HelloServiceImpl;
import br.gharralabs.services.HelloServiceImplService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CumprimentarServlet", 
            urlPatterns = { "/cumprimentar.go", "/"  })
public class CumprimentarServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("WEB-INF/views/CumprimentarForm.jsp");
        rd.forward(request, response);   
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        HelloServiceImplService fábrica;
        fábrica = new HelloServiceImplService();
        HelloServiceImpl serviço;
        serviço = fábrica.getHelloServiceImplPort();
        
        String nome;
        nome = request.getParameter("nome");
        
        String resposta;
        resposta = serviço.cumprimentar(nome);
        
        request.setAttribute("resposta", resposta);        
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("WEB-INF/views/CumprimentarForm.jsp");
        rd.forward(request, response);
        
    }
}
