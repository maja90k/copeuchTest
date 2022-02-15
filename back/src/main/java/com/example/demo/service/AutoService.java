/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.repository.AutoRepository;

import com.example.demo.model.Auto;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.*;
import java.util.Date;


/**
 *
 * @author Byron
 * Actua como intermediario entre el repository y controlador
 */
@Service
@Transactional
public class AutoService {
    
    @Autowired
    private AutoRepository autoRepository;
    
    public List<Auto> getAll() {
        return autoRepository.findAll();
    }
    
    public void saveAuto( Auto auto ) {
        auto.setFecha_ingreso(new Date());
    	autoRepository.save(auto);
    }
    
    public void deleteAuto(int id) {
    	autoRepository.deleteById(id);
    }
    
}
