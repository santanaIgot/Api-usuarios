package br.com.fiap.gestao.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.gestao.dao.UsuarioDao;
import br.com.fiap.gestao.exception.BadInfoException;
import br.com.fiap.gestao.exception.IdNotFoundException;
import br.com.fiap.gestao.factory.ConnectionFactory;
import br.com.fiap.gestao.model.User;
import br.com.fiap.gestao.util.StringUtils;
import jakarta.ws.rs.core.Response.ResponseBuilder;

public class UsuarioService {
	private UsuarioDao dao;
	
	
	public UsuarioService() throws ClassNotFoundException, SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		
		dao = new UsuarioDao(conexao);
		
	}
	
	public void remover(int id) throws SQLException {
		dao.remover(id);
	}
	
	public void atualizar(User user) throws SQLException, IdNotFoundException, BadInfoException{
		validar(user);
		dao.atualizar(user);
	}
	
	public void Cadastrar(User user) throws SQLException, BadInfoException {
		//validacoes
		validar(user);
		dao.cadastrar(user);
	}

	private void validar(User usuario) throws BadInfoException {
		if(StringUtils.isNullOrEmptyOrHasMoreThan(usuario.getNome(), 100)) {
			throw new BadInfoException("Nome invalido");
		}
		if(StringUtils.isNullOrEmptyOrHasMoreThan(usuario.getEmail(), 100))
			throw new BadInfoException("Email invalido");
		
		if(StringUtils.isNullOrEmpty(usuario.getCpf()) ||!StringUtils.has(usuario.getCpf(), 11))
			throw new BadInfoException("cpf invalido");
	}


	public User pesquisar(int id) throws SQLException, IdNotFoundException {
		
		return dao.pesquisar(id);
	}
	
	
	public List<User> listar() throws SQLException {
		
		return dao.Listar();
	}




}
