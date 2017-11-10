package com.camiloalzate.takumprueba.dao;

import java.util.List;

import com.camiloalzate.takumprueba.model.Usuario;

public interface UsuarioDAO {

	void save(Usuario user);

	void update(Usuario user);

	void delete(Usuario user);

	Usuario findByUSUACODI(String USUACODI);

	List<Usuario> findByAllUsers();

}
