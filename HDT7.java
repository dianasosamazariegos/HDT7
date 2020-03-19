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
        
        Asociacion<String,String> asc;
        BinaryTree dicc = new BinaryTree();
        Scanner scan = new Scanner(System.in);
        int resp = 0;
                
        //Lectura del archivo "dictionary.txt" para ordenar el diccionario de traducciones
        String FILENAME = "dictionary.txt";
        
        BufferedReader br = null;
        FileReader fr = null;
        String output = "";
        
        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            String stringOutput ="";
            int cont = 0;

            while ((stringOutput = br.readLine()) != null) {
		
                int startParenIndex = 1 + stringOutput.indexOf("(");
                int endParenIndex = stringOutput.indexOf(")");
            	int commaIndex = stringOutput.indexOf(",");
            	
            	String key = stringOutput.substring(startParenIndex, commaIndex);
            	String value = stringOutput.substring(2+commaIndex, endParenIndex);

            	asc = new Asociacion<>(key.toLowerCase(), value.toLowerCase());
            	
            if (cont == 0) {
            		dicc.setData(asc);
            		cont++;
            		
            	} else {
            		dicc.insert(asc); //se inserta el array en el diccionario
            	}
		
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
        
        //Lectura del archivo "text.txt" para poder hacer la traduccion de la oracion
        String FILENAME2 = "text.txt";
        br = null;
	fr = null;
        String traduction = "";
        String stringOutput = "";
        
        try {

            fr = new FileReader(FILENAME2);
            br = new BufferedReader(fr);
         
            while ((stringOutput = br.readLine()) != null) {
	
                stringOutput = stringOutput.replace(".",""); // remueve todos los puntos
                
                String[] palabras = stringOutput.split(" ",0); // separa por espacios
                
                for (String p : palabras) { // se crea un ciclo para ordenar las palabras y separarlas
                	
                	if (dicc.contains(p.toLowerCase())) {
                		
                		traduction += " " + dicc.get(p.toLowerCase());
                		
                	} else {
                		
                		traduction += " *" + p + "* "; //se imprime la traduccion
                	}
                }
                
                traduction+= ".\n"; // final de la oracion
				
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
        
        while (resp != 3) {
        System.out.println("\n   *** Menu *** ");
        System.out.println(" 1. Diccionario de palabras ordenado");
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
        
        if (resp == 1){
            System.out.println("\n --Imprimiendo diccionario en forma In Order... \n");
            dicc.printInOrder(); // se llama a la funcion de BinaryTree (diccionario)
          
        } else if (resp == 2){
            System.out.println("\n --Traduccion: \n");
            System.out.println(traduction); // se imprime la traduccion 
        
        } else {
            System.out.println("**Saliendo.... ");
        }
            
    }
}
}

