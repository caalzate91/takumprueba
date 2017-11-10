package com.camiloalzate.takumprueba.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.camiloalzate.takumprueba.model.Usuario;

public class UsuarioDAOImpl extends HibernateDaoSupport implements UsuarioDAO {

	@Override
	public void save(Usuario user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(user);
	}

	@Override
	public void update(Usuario user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(user);
	}

	@Override
	public void delete(Usuario user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(user);
	}

	@Override
	public Usuario findByUSUACODI(String USUACODI) {
		// TODO Auto-generated method stub
		List<?> list = getHibernateTemplate().find(
				"from USUARIO where USUACODI=?", USUACODI);
		return (Usuario) list.get(0);
	}

	@Override
	public List<Usuario> findByAllUsers() {
		// TODO Auto-generated method stub
		List<Usuario> list = getHibernateTemplate().find("from Usuario");
		return list;
	}

}