package com.camiloalzate.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.camiloalzate.takumprueba.bo.UsuarioBO;
import com.camiloalzate.takumprueba.model.Usuario;

public class PruebaBD {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"spring/config/BeanLocations.xml");

		UsuarioBO usuarioBo = (UsuarioBO) appContext.getBean("usuarioBo");

		/** select **/
		Usuario user = usuarioBo.findByUSUACODI("1");
		System.out.println(user);

		/** update **/
		user.setUsuaterc(5845200);
		usuarioBo.update(user);

		System.out.println("Done");
	}

}
