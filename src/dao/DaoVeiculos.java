package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.BeanVeiculo;
import conexao.SingleConnection;

public class DaoVeiculos {
	
	private Connection connection;
	
	public DaoVeiculos() {
		
		connection = SingleConnection.getConnection();
	}
	
	/*Metodo inserir ou salvar no banco de dados*/
	
	public void salvar(BeanVeiculo veiculos) {
		
		try {
			
		String sql = "insert into veiculos(veiculo, placa, dataFormatada, horaAtual)values(?, ?, ?, ?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		
		insert.setString(1, veiculos.getVeiculo());
		insert.setString(2, veiculos.getPlaca());
		insert.setString(3, veiculos.getDataFormatada());
		insert.setString(4, veiculos.getHoraAtual());
		insert.execute();
		
		connection.commit();
		
		}catch(Exception e) {
			
			try {
				
				connection.rollback();
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
			
			e.printStackTrace();
		}
		
	}
	
	/*Metodo Listar*/
	
	public List<BeanVeiculo> listar() throws Exception {
		
		List<BeanVeiculo> listar = new ArrayList<BeanVeiculo>();
		
		String sql = "select * from veiculos";
		PreparedStatement select = connection.prepareStatement(sql);
		ResultSet resultSet = select.executeQuery();
		
		while(resultSet.next()) {
			
			BeanVeiculo beanVeiculo = new BeanVeiculo();
			
			beanVeiculo.setVeiculo(resultSet.getString("veiculo"));
			beanVeiculo.setPlaca(resultSet.getString("placa"));
			beanVeiculo.setDataFormatada(resultSet.getString("dataFormatada"));
			beanVeiculo.setHoraAtual(resultSet.getString("horaAtual"));
			
			listar.add(beanVeiculo);
		}
		
		return listar;
	}

	/*Metodo Excluir*/
	
	public void deletar(String placa) {
		
		try {
			
			String sql = "delete from veiculos where placa = '" + placa + "'";
			PreparedStatement delete = connection.prepareStatement(sql);
			delete.execute();
			
			connection.commit();
			
		}catch(Exception e) {
			
			try {
				
				connection.rollback();
				
			} catch (SQLException e1) {
			
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
	
		
	}

}
