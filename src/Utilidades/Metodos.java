/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HP
 */
public class Metodos {
    private String nombre;
    private String cuerpo;
    private Map<String, Object> atributos = new HashMap();
    
    public Metodos(){
        //atributos = new HashMap();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Map<String, Object> getAtributos() {
        return atributos;
    }

    public void setAtributos(Map<String, Object> atributos) {
        this.atributos = atributos;
    }

    @Override
    public String toString() {
        return "Metodo: " + nombre + ", cuerpo: " +cuerpo + ", Parametros: " +atributos + ", tamanio: "+atributos.size(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
}
