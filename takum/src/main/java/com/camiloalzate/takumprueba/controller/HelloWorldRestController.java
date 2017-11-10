package com.camiloalzate.takumprueba.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.camiloalzate.takumprueba.model.Usuario;
import com.camiloalzate.takumprueba.service.UsuarioService;
 
@RestController
public class HelloWorldRestController {
 
    @Autowired
    UsuarioService userService;  
    
    @Autowired
    //ProductosService productosService;
 
    
    //-------------------Retrieve All Users--------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> listAllUsers() {
        List<Usuario> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Usuario>>(users, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single User--------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        Usuario user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Usuario>(user, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a User--------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Usuario user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getUsuanomb());
 
        if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getUsuanomb() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        userService.saveUser(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUsuacodi()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Usuario> updateUser(@PathVariable("id") long id, @RequestBody Usuario user) {
        System.out.println("Updating User " + id);
         
        Usuario currentUser = userService.findById(id);
         
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
 
        currentUser.setUsuanomb(user.getUsuanomb());
        currentUser.setUsuadire(user.getUsuadire());
        currentUser.setUsuacodi(user.getUsuacodi());
        currentUser.setUsuaemai(user.getUsuaemai());
         
        userService.updateUser(currentUser);
        return new ResponseEntity<Usuario>(currentUser, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);
 
        Usuario user = userService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
 
        userService.deleteUserById(id);
        return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
    }
 
     
   /*
    
  //-------------------Retrieve All Productos--------------------------------------------------------
    
    @RequestMapping(value = "/productos/", method = RequestMethod.GET)
    public ResponseEntity<List<Productos>> listAllProductos() {
        List<Productos> productos = productosService.findAllProductos();
        if(productos.isEmpty()){
            return new ResponseEntity<List<Productos>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Productos>>(productos, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single Producto--------------------------------------------------------
     
    @RequestMapping(value = "/productos/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Productos> getProductos(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        Productos productos = productosService.findById(id);
        if (productos == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Productos>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Productos>(productos, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a User--------------------------------------------------------
     
    @RequestMapping(value = "/productos/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Productos productos,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + productos.getProdnomb());
 
        if (productosService.isProductExist(productos)) {
            System.out.println("A User with name " + productos.getProdnomb() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        productosService.saveProductos(productos);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(productos.getProdcodi()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a User --------------------------------------------------------
     
    @RequestMapping(value = "/productos/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Productos> updateProductos(@PathVariable("id") long id, @RequestBody Productos productos) {
        System.out.println("Updating User " + id);
         
        Productos currentproducto = productosService.findById(id);
         
        if (currentproducto==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Productos>(HttpStatus.NOT_FOUND);
        }
 
        currentproducto.setProdnomb(productos.getProdnomb());
        currentproducto.setProdcapr(productos.getProdcapr());
        currentproducto.setProdcodi(productos.getProdcodi());
        currentproducto.setProdcost(productos.getProdcost());
        currentproducto.setProddesc(productos.getProddesc());
        currentproducto.setProdusua(productos.getProdusua());
         
        productosService.updateProductos(currentproducto);
        return new ResponseEntity<Productos>(currentproducto, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a User --------------------------------------------------------
     
    @RequestMapping(value = "/productos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Productos> deleteProductos(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);
 
        Productos productos = productosService.findById(id);
        if (productos == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<Productos>(HttpStatus.NOT_FOUND);
        }
 
        productosService.deleteProductosById(id);
        return new ResponseEntity<Productos>(HttpStatus.NO_CONTENT);
    }
 
    */
 
}