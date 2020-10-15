package br.com.zup.estrelas.cidades.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.zup.estrelas.cidades.POJO.CidadePOJO;
import br.com.zup.estrelas.cidades.connectionFactory.ConnectionFactory;

public class CidadesDAO {
	
	private Connection conexao;
	
	public CidadesDAO() {
		this.conexao = new ConnectionFactory().getConnection();
	}

//	private static void whilePadraoBusca(Resultset rs, List<CidadePOJO> cidades)  {
//		
//		while (rs.next()) {
//			CidadePOJO cidade = new CidadePOJO();
//			
//			cidade.setNome(rs.getString("nome"));
//			cidade.setCep(rs.getString("cep"));
//			cidade.setNumeroHabitantes(rs.getFloat("numero_habitantes"));
//			cidade.setEhCapital(rs.getBoolean("capital"));
//			cidade.setEstado(rs.getString("estado"));
//			cidade.setRendaPerCapta(rs.getFloat("renda_per_capita"));
//			cidade.setData(rs.getString("data_fundacao"));
//			
//			cidades.add(cidade);
//			
//		}
//		
//	}
	
 	public boolean insereCidade(CidadePOJO cidade) throws Exception {
		String sql = "insert into estrelas.cidade"
				+ "(nome, cep, numero_habitantes, capital, estado, renda_per_capita, data_fundacao)"
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cidade.getNome());
			stmt.setString(2, cidade.getCep());
			stmt.setFloat(3, cidade.getNumeroHabitantes());
			stmt.setBoolean(4, cidade.getEhCapital());
			stmt.setString(5, cidade.getEstado());
			stmt.setFloat(6, cidade.getRendaPerCapta());
			stmt.setString(7, cidade.getDataFundacao());
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			System.err.println("erro ao inserir cidades");
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	public List<CidadePOJO> listaCidades () {
		List<CidadePOJO> cidades = new ArrayList<> ();
		
		String sql = "SELECT * FROM estrelas.cidade";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				CidadePOJO cidade = new CidadePOJO();
				
				cidade.setNome(rs.getString("nome"));
				cidade.setCep(rs.getString("cep"));
				cidade.setNumeroHabitantes(rs.getFloat("numero_habitantes"));
				cidade.setEhCapital(rs.getBoolean("capital"));
				cidade.setEstado(rs.getString("estado"));
				cidade.setRendaPerCapta(rs.getFloat("renda_per_capita"));
				cidade.setData(rs.getString("data_fundacao"));
				
				cidades.add(cidade);
				
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			System.err.println("Erro ao listar cidades");
			System.err.println(e.getMessage());
		}
		
		return cidades;
	}
	
	public boolean removeCidade(String cep) throws Exception {
		String sql = "DELETE  FROM estrelas.cidade"
				+ "WHERE cep = ?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cep);
			stmt.execute();
			stmt.close();
			} catch (SQLException e) {
			System.out.println("Erro ao deletar cidade");
			System.out.println(e.getMessage());
			return false;
			}
		
		
		return true;
	}
	
	public List<CidadePOJO> verCidade(String cep) throws Exception {
		
		List<CidadePOJO> cidades = new ArrayList<> ();
		String sql = "SELECT c.*"
				+ "FROM estrelas.cidade c"
				+ "WHERE p.cep IN (?) ";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				CidadePOJO cidade = new CidadePOJO();
				
				cidade.setNome(rs.getString("nome"));
				cidade.setCep(rs.getString("cep"));
				cidade.setNumeroHabitantes(rs.getFloat("numero_habitantes"));
				cidade.setEhCapital(rs.getBoolean("capital"));
				cidade.setEstado(rs.getString("estado"));
				cidade.setRendaPerCapta(rs.getFloat("renda_per_capita"));
				cidade.setData(rs.getString("data_fundacao"));
				
				cidades.add(cidade);
				
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			System.err.println("Erro ao listar cidades");
			System.err.println(e.getMessage());
		}
		
		return cidades;	
	}

	
}

	