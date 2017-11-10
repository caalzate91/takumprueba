package com.camiloalzate.takumprueba.bo;

import java.util.List;

import com.camiloalzate.takumprueba.model.Productos;

public interface ProductosBO {

	void save(Productos productos);

	void update(Productos productos);

	void delete(Productos productos);

	Productos findByProductos(String prodcodi);

	List<Productos> findByAllproductos();

}
