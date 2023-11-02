package br.com.fiap.gestao.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.fiap.gestao.model.*;

public class UsuarioDao {
	private Connection conexao;
	
	
	public  UsuarioDao(Connection conexao) {
		this.conexao = conexao;
	}
	public void cadastrar(User user) throws SQLException {
		PreparedStatement stm = conexao.prepareStatement("Insert into tb_usuario(cd_usuario, nm_usuario,dt_cadastro,dt_nascimento,"
				+ "ds_email,"
				+ "nr_cpf) "
				+ "values(sq_tb_usuario.nextval,?,sysdate,?,?,?)", new String[] {"cd_usuario"});
		
		
		stm.setString(1, user.getNome());
//		user.setDataCadastro(LocalDateTime.now());//Cria objjeto com data atual
//		stm.setDate(2,Date.valueOf(user.getDataCadastro().toLocalDate()));
		stm.setObject(2, user.getDataNascimento());
		stm.setString(3, user.getEmail());
		stm.setString(4, user.getCpf());
		
		stm.executeUpdate();
		
		//Recupera valor gerado pela sequence , o cod do usuario cd_usuario
		
		ResultSet result = stm.getGeneratedKeys();
		result.next();
		int codigo = result.getInt(1);
		
		user.setId(codigo);
	}
}
