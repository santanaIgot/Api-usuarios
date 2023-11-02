package br.com.fiap.gestao.teste;

import java.time.LocalDate;

import br.com.fiap.gestao.model.User;
import br.com.fiap.gestao.service.UsuarioService;

public class Cadastrar {
	public static void main(String[] args) {
		try {
//			Connection conexao = ConnectionFactory.getConnection();
			
			UsuarioService service = new UsuarioService();
			
			User usuario = new User("Luqinhas","luquinhas03@gmail.comjsdsj","21487474212",LocalDate.of(2003, 05, 20));
			
			service.Cadastrar(usuario);
			
			System.out.println(usuario.getId());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
