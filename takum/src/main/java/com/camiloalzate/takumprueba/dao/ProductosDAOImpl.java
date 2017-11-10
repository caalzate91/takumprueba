package com.camiloalzate.takumprueba.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.camiloalzate.takumprueba.model.Productos;

public class ProductosDAOImpl extends HibernateDaoSupport implements
		ProductosDAO {

	@Override
	public void save(Productos productos) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(productos);
	}

	@Override
	public void update(Productos productos) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(productos);
	}

	@Override
	public void delete(Productos productos) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(productos);
	}

	@Override
	public Productos findByProdcodi(String prodcodi) {
		// TODO Auto-generated method stub
		List<?> list = getHibernateTemplate().find(
				"from PRODUCTOS where PRODCODI=?", prodcodi);
		return (Productos) list.get(0);
	}

	@Override
	public List<Productos> findByAllproductos() {
		// TODO Auto-generated method stub
		List<Productos> list = getHibernateTemplate().find("from Productos");
		return list;
	}

}