package com.camiloalzate.takumprueba.bo;

import java.util.List;

import com.camiloalzate.takumprueba.dao.UsuarioDAO;
import com.camiloalzate.takumprueba.model.Usuario;

public class UsuarioBOImpl implements UsuarioBO {
	
	UsuarioDAO usuarioDao;
	
	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Override
	public void save(Usuario user) {
		// TODO Auto-generated method stub
		usuarioDao.save(user);
	}

	@Override
	public void update(Usuario user) {
		// TODO Auto-generated method stub
		usuarioDao.update(user);
	}

	@Override
	public void delete(Usuario user) {
		// TODO Auto-generated method stub
		usuarioDao.delete(user);
	}

	@Override
	public Usuario findByUSUACODI(String USUACODI) {
		// TODO Auto-generated method stub
		return usuarioDao.findByUSUACODI(USUACODI);
	}

	@Override
	public List<Usuario> findByAllUsers() {
		// TODO Auto-generated method stub
		return usuarioDao.findByAllUsers();
	}

}
