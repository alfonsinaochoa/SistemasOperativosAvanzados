/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alfonsina.ochoa
 */
/*Clase que permite escribir en un archivo de texto*/

//Importamos clases que se usaran
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;

public class WriteFile
{
    public ArrayList texto = new ArrayList();    
    public FileWriter escribir;
    public File archivo;
    public BufferedWriter bw;
    

    public WriteFile(){
        try
        {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor            
            archivo=new File("simuladorTiempo.txt");
            //Si existe el fichero lo elimina  
           if(archivo.exists()){  
               archivo.delete();                
           }              
            archivo.createNewFile();                
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            escribir=new FileWriter(archivo,true);                    
        }

        //Si existe un problema al crear imprime la excepción
        catch(Exception e)
        {
            System.out.println("Error al crear el archivo");
        }
    }
    public void escribirArchivo(){        
        for(int k = 0;k<texto.size();k++){            
            try
            {
                //Escribimos en el archivo con el metodo write 
                escribir.write(this.texto.get(k).toString());                                    
            }
            catch(Exception e)
            {
                System.out.println("Error al escribir en el archivo");
            }
        }
        
        try
        {
            this.escribir.close();              
        }
        catch(Exception e)
        {
            System.out.println("Error al cerrar el archivo");
        }
    }
          
    
    public void llenarArreglo(String cadena){
        texto.add(cadena + "\n");
    }
    
    public void escribir(String cadena)
    {        
        try
        {            
            escribir.append(cadena + "\n");                        
        }

        //Si existe un problema al escribir imprime la excepción
        catch(Exception e)
        {
            System.out.println("Error al escribir");
        }
    }
}
