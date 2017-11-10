package com.camiloalzate.takumprueba.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.camiloalzate.takumprueba.bo.ProductosBO;
import com.camiloalzate.takumprueba.model.Productos;
import com.camiloalzate.takumprueba.model.Usuario;

@Service("productosService")
public class ProductosServiceImpl implements ProductosService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Productos> productos;
	
	private static ApplicationContext appContext = new ClassPathXmlApplicationContext(
			"config/BeanLocations.xml");
	
	/*private static ProductosBO productosBo = (ProductosBO) appContext.getBean("productosBo");
	
	static{
		productos= populateDummyProductos();
	}

	public List<Productos> findAllProductos() {
		return productos;
	}
	
	public Productos findById(long id) {
		for(Productos productos : productos){
			if(productos.getProdcodi() == id){
				return productos;
			}
		}
		return null;
	}
	
	
	public void saveProductos(Productos productos) {
		productosBo.save(productos);
	}

	public void updateProductos(Productos productos) {
		productosBo.update(productos);
	}

	public void deleteProductosById(long id) {
		
		for (Iterator<Productos> iterator = productos.iterator(); iterator.hasNext(); ) {
		    Productos productos = iterator.next();
		    if (productos.getProdcodi() == id) {
		    	productosBo.delete(productos);
		    }
		}
	}
	

	private static List<Productos> populateDummyProductos(){

		
		List<Productos> productoss = productosBo.findByAllproductos();

		return productoss;
	}

	@Override
	public boolean isProductExist(Productos productos) {
		// TODO Auto-generated method stub
		return findByName(productos.getProdnomb())!=null;
	}

	@Override
	public Productos findByName(String name) {
		for(Productos productos : productos){
			if(productos.getProdnomb().equalsIgnoreCase(name)){
				return productos;
			}
		}
		return null;
	}*/


}
