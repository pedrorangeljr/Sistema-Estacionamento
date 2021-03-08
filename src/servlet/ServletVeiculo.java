package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BeanVeiculo;
import dao.DaoVeiculos;

/**
 * Servlet implementation class ServletVeiculo
 */
@WebServlet("/cadastrarVeiculos")
public class ServletVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DaoVeiculos daoVeiculos = new DaoVeiculos();
    
    public ServletVeiculo() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String acao = request.getParameter("acao");
		String veiculo = request.getParameter("veiculo");
		
		try {
			
			if(acao.equalsIgnoreCase("delete")) { // Deletar 
				
				daoVeiculos.deletar(veiculo);
				
				RequestDispatcher view = request.getRequestDispatcher("index.jsp");
				request.setAttribute("veiculos", daoVeiculos.listar());
				view.forward(request, response);
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String veiculo = request.getParameter("modeloCarro");
		String placa = request.getParameter("placaCarro");
		
		BeanVeiculo beanVeiculo = new BeanVeiculo();
		
	
		beanVeiculo.setVeiculo(veiculo);
		beanVeiculo.setPlaca(placa);
		
	        daoVeiculos.salvar(beanVeiculo); // salva carro no sistema	
		
		try {
			
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			request.setAttribute("veiculos", daoVeiculos.listar());
			view.forward(request, response);
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
