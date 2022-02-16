/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;
import com.example.demo.service.AutoService;



import com.example.demo.model.Auto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


/**
 *
 * @author Byron
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping( "autos" )
public class AutoController {
	
    @Autowired
    public AutoService autoService;
    
    @GetMapping("/getAll")
    public List<Auto> list() {
        return autoService.getAll();
    }
    
    @PostMapping("/reqPost")
    public void add( @RequestBody Auto auto) {
    	int cont = 0;
    	try {
    		if(auto.getMarca() == "") {
    			++cont;
    		}
        	if(auto.getModelo() == "") {
        		++cont;
        	}
        	if(cont>0) {
            	System.out.println("Error al ingresar");
        	}else {
                autoService.saveAuto(auto);
//                JsonObject json = Json.createObjectBuilder().add(auto, id).build();
//                return auto;
                System.out.println("Se guarda el auto con exito.");
        	}	
    	}catch(Exception ex) {
            System.out.println(ex);
    	}
    }
    
//    @PutMapping(value ="/reqPost/{id}")
//    public updateAnuncio(@PathVariable ("id") Long id @Valid @RequestBody) {
//    	
//    	
//    }
    
    @DeleteMapping(value="/reqPost/{id}" )
    public void delete(@PathVariable("id") int id) {
    	autoService.deleteAuto(id);
    	System.out.println("Se elimino correctamente.");
    }
    

}
