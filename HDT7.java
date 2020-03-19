/*
Universidad del Valle de Guatemala
Algoritmos y Estructuras de Datos
Autor: Diana Sosa 18842  -Fecha: 18/03/2020
 */
package hdt7;

import java.util.*;
import java.io.*;
import java.lang.*;

public class HDT7 {

    public static void main(String[] args) {
        
        Asociacion<String,String> asociacion = new Asociacion<String,String>();
        BinaryTree binaryT = new BinaryTree();
        
        String FILENAME = "dictionary.txt";
        
        BufferedReader br = null;
        FileReader fr = null;
        String output = "";
        
        Scanner scan = new Scanner(System.in);
        int resp = 0;
        
        System.out.println("   *** Menu *** ");
        System.out.println(" 1. Diccionario de palabras");
        System.out.println(" 2. Traducir un texto ");
        System.out.println(" 3. Salir  ");
        System.out.println(" -- Ingrese el número de la opción que desea escoger: ");
        
        try{
            resp = scan.nextInt();
            scan.nextLine();
        } catch (InputMismatchException e){
            scan.nextLine();
            System.out.println(" ## No ingreso un número! ##");
        }
         
        while (resp < 1 || resp >3){
            System.out.println(" ## No ingreso una opción valida! ## ");
            System.out.println(" -- Ingrese la opcion desea elegir: ");
            
            try{
                resp = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e){ 
                scan.nextLine();
                System.out.println(" ## No ingreso un número! ##");
            }
        }
        
        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            while ((output = br.readLine()) != null) {
		
                String[] outputArray = output.split(" ");
		
                asociacion.put(outputArray[0], outputArray[1]);
            
            }
            
        } catch (IOException e) {
                e.printStackTrace();

            } finally {
                try {
                    if (br != null)
                        br.close();
                    
                    if (fr != null)
			fr.close();

		} catch (IOException ex) {
                    
                    ex.printStackTrace();
	
                    }
	}
    
        
        if (resp == 1){
            int r = 0;
            System.out.println("   *** Menu de Diccionario*** ");
            System.out.println(" 1. Insertar una nueva palabra");
            System.out.println(" 2. Buscar una palabra en el diccionario ");
            System.out.println(" 3. Mostrar el diccionario en orden ");
            System.out.println(" -- Ingrese el número de la opción que desea escoger: "); 
            try{
                r = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e){
                scan.nextLine();
                System.out.println(" ## No ingreso un número! ##");
            }
         
            while (r < 1 || r >4){
                System.out.println(" ## No ingreso una opción valida! ## ");
                System.out.println(" -- Ingrese la opcion desea elegir: ");
            
                try{
                    r = scan.nextInt();
                    scan.nextLine();
                } catch (InputMismatchException e){ 
                    scan.nextLine();
                    System.out.println(" ## No ingreso un número! ##");
                }
            }
            
            if (r == 1){
                String palabraIngles;
                String palabraEspanol;
                System.out.println(" -- Ingrese la palabra en Ingles que desea agregar: ");
                palabraIngles = scan.nextLine();
                System.out.println(" -- Ingrese la palabra en Español que desea agregar: ");
                palabraEspanol = scan.nextLine();
                asociacion.put(palabraIngles, palabraEspanol);
                binaryT.insert(asociacion); 
                System.out.println(" ## Asociacion/Traducción agregada ## ");
            
            } else if(r == 2){
                String palabra;
                System.out.println(" -- Ingrese la palabra en Espanol que desea buscar: ");
                palabra = scan.nextLine();
                if (binaryT.contains(palabra) == true){
                    System.out.println(" ## PALABRA ENCONTRADA ## " + asociacion.getKey());
                } else {
                    System.out.println(" ## PALABRA NO ENCONTRADA ## ");
                }
                
            } else if(r == 3){
                binaryT.printInOrder();
            }
             
            
            
        } 
            
        }
    }
    

