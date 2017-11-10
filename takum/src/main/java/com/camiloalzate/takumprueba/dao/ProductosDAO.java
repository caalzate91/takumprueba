package com.camiloalzate.takumprueba.dao;

import java.util.List;

import com.camiloalzate.takumprueba.model.Productos;

public interface ProductosDAO {

	void save(Productos productos);

	void update(Productos productos);

	void delete(Productos productos);

	Productos findByProdcodi(String Prodcodi);

	List<Productos> findByAllproductos();

}
