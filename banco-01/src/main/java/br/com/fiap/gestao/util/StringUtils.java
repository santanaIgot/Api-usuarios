package br.com.fiap.gestao.util;

public class StringUtils {
	public static boolean isNullOrEmpty(String valor) {
		return(valor == null || valor.isEmpty());
	
	}
	public static boolean hasMoreThan(String valor,int caracteres) {
		return valor.length()> caracteres;
		
	}
	public static boolean isNullOrEmptyOrHasMoreThan(String valor,int caracteres) {
		return isNullOrEmpty(valor) || hasMoreThan(valor, caracteres);
		
	}
	
	public static boolean has(String valor, int caracteres) {
		return valor.length() == caracteres;
		
	}
	
}
