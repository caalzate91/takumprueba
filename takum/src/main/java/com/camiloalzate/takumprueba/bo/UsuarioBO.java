package com.camiloalzate.takumprueba.bo;

import java.util.List;

import com.camiloalzate.takumprueba.model.Usuario;

public interface UsuarioBO {

	void save(Usuario User);

	void update(Usuario User);

	void delete(Usuario User);

	Usuario findByUSUACODI(String USUACODI);

	List<Usuario> findByAllUsers();

}
