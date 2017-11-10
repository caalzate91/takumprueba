package com.camiloalzate.takumprueba.bo;

import java.util.List;

import com.camiloalzate.takumprueba.dao.ProductosDAO;
import com.camiloalzate.takumprueba.model.Productos;

public class ProductosBOImpl implements ProductosBO {
	
	ProductosDAO productosDao;
	
	public void setProductosDao(ProductosDAO productosDao) {
		this.productosDao = productosDao;
	}

	@Override
	public void save(Productos user) {
		// TODO Auto-generated method stub
		productosDao.save(user);
	}

	@Override
	public void update(Productos user) {
		// TODO Auto-generated method stub
		productosDao.update(user);
	}

	@Override
	public void delete(Productos user) {
		// TODO Auto-generated method stub
		productosDao.delete(user);
	}

	@Override
	public Productos findByProductos(String prodcodi) {
		// TODO Auto-generated method stub
		return productosDao.findByProdcodi(prodcodi);
	}

	@Override
	public List<Productos> findByAllproductos() {
		// TODO Auto-generated method stub
		return productosDao.findByAllproductos();
	}

}
