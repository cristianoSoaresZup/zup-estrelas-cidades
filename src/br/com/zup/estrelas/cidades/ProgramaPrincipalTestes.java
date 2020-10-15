package br.com.zup.estrelas.cidades;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.zup.estrelas.cidades.connectionFactory.ConnectionFactory;

public class ProgramaPrincipalTestes {

	public static void main(String[] args) throws SQLException {

		Connection conexao = new ConnectionFactory().getConnection();

		System.out.println("conectado");

		conexao.close();

	}

}
