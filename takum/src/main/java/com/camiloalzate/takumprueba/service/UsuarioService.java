package com.camiloalzate.takumprueba.service;

import java.util.List;

import com.camiloalzate.takumprueba.model.Usuario;



public interface UsuarioService {
	
	Usuario findById(long id);
	
	Usuario findByName(String name);
	
	void saveUser(Usuario user);
	
	void updateUser(Usuario user);
	
	void deleteUserById(long id);

	List<Usuario> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(Usuario user);
	
}
