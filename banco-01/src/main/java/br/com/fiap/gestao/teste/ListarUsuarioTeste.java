package br.com.fiap.gestao.teste;

import java.time.LocalDate;
import java.util.List;
import br.com.fiap.gestao.resource.*;
import br.com.fiap.gestao.model.User;
import br.com.fiap.gestao.service.UsuarioService;

public class ListarUsuarioTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
//		
//		criar instancia do sevice 	
			UsuarioService service = new UsuarioService();
			
			List<User> lista = service.listar();
			
			
			for(User user :lista) {
				System.out.println(user.getNome());
				System.out.println(user.getDataNascimento());
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
