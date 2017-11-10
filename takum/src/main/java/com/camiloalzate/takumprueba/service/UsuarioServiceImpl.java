package com.camiloalzate.takumprueba.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.camiloalzate.takumprueba.bo.UsuarioBO;
import com.camiloalzate.takumprueba.model.Usuario;

@Service("userService")
public class UsuarioServiceImpl implements UsuarioService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Usuario> users;
	
	private static ApplicationContext appContext = new ClassPathXmlApplicationContext(
			"config/BeanLocations.xml");
	
	private static UsuarioBO usuarioBo = (UsuarioBO) appContext.getBean("usuarioBo");
	
	static{
		users= populateDummyUsers();
	}

	public List<Usuario> findAllUsers() {
		return users;
	}
	
	public Usuario findById(long id) {
		for(Usuario user : users){
			if(user.getUsuacodi() == id){
				return user;
			}
		}
		return null;
	}
	
	public Usuario findByName(String name) {
		for(Usuario user : users){
			if(user.getUsuanomb().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(Usuario user) {
		//users.add(user);
		usuarioBo.save(user);
	}

	public void updateUser(Usuario user) {
		usuarioBo.update(user);
	}

	public void deleteUserById(long id) {
		
		for (Iterator<Usuario> iterator = users.iterator(); iterator.hasNext(); ) {
		    Usuario user = iterator.next();
		    if (user.getUsuacodi() == id) {
		        usuarioBo.delete(user);
		    }
		}
	}

	public boolean isUserExist(Usuario user) {
		return findByName(user.getUsuanomb())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

	private static List<Usuario> populateDummyUsers(){

		/** select **/
		List<Usuario> users = usuarioBo.findByAllUsers();

		return users;
	}

}
