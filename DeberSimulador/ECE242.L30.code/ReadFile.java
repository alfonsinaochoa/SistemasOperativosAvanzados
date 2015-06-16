/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alfonsina.ochoa
 */

import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class ReadFile {    
    public ArrayList<Double> tiempos = new ArrayList<Double>();
    public ArrayList<Double> tiempoTotal = new ArrayList<Double>();
    public FileReader leer;    
    public BufferedReader br;
    public Double total;
    
    public ReadFile(String nombre_archivo){
        try{
            String linea;            
            br = new BufferedReader(new FileReader(nombre_archivo));                        
            System.out.println(br.readLine());
            while ((linea = br.readLine()) != null) {                
                String[] parts = linea.split(":");                
                tiempos.add(Double.parseDouble(parts[1].toString()));                        
                //System.out.println(Integer.parseInt(parts[1].toString()));   
            }
        }        
        catch(Exception e)
        {
            System.out.println("Error al leer el archivo");
        }
    }
    
    public Double readFileTime(String nombre_archivo, String variable1, String variable2){
        
        Double tiempo;
        try{
            String linea;            
            br = new BufferedReader(new FileReader(nombre_archivo));                        
            System.out.println("Empieza a leer archivo");
            total = 0.0;
            tiempo = 0.0;
            while ((linea = br.readLine()) != null) {                
                String[] parts = linea.split(":");     
                if(parts[1].toString().equals(variable2)){
                    tiempo = Double.parseDouble(parts[0].toString());                    
                }
                if(parts[1].toString().equals(variable1)){                    
                    tiempoTotal.add(Double.parseDouble(parts[0].toString()) - tiempo); 
                    total = total + Double.parseDouble(parts[0].toString()) - tiempo;
                }                                
            }
            total = total / tiempoTotal.size();            
        }        
        catch(Exception e)
        {
            System.out.println("Error al leer el archivo");
        }
        return total;
    }
    
    
    public Integer nextIndex(Integer indice){
        try
        {
          if(tiempos.get(indice) == null)
            indice = 0;        
        }
        catch(Exception e)
        {
            indice = 0;        
        }       
        return indice;
       
    }
    
    
}

