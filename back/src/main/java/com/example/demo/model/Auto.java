/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.*;



/**
 *
 * @author Byron
 */
@Entity
@Table(name = "auto")
public class Auto {
    private int id;
    private String marca;
    private String modelo;
    private Date fecha_ingreso;
    
    public Auto() {
        
    }
    
    public Auto(int id, String marca, String modelo, Date fecha_ingreso) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.fecha_ingreso = fecha_ingreso;
        
    }
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
    
    
    
}
