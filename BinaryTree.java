/*
Universidad del Valle de Guatemala
Algoritmos y Estructuras de Datos
Autor: Diana Sosa 18842  -Fecha: 18/03/2020
 */
package hdt7;

/**
 *
 * @author diana
 */
public class BinaryTree {
    
	Asociacion<String,String> data;
	BinaryTree left;
	BinaryTree right;
	
	//Extraído de: https://www.baeldung.com/java-binary-tree
        
        public BinaryTree() {
		data = null;
		left = null;
		right = null;
	}
	
	public BinaryTree(Asociacion<String,String> data) {
		this.data = data;
		left = null;
		right = null;
	}
	
	public void setData(Asociacion<String,String> data) {
		this.data = data;
	}
    
        public Asociacion<String,String> getValue() {
		return data;
	}
        
	//Metodo para insertar nodos
	public void insert(Asociacion<String,String> value) {
		
		int res = stringCompare(value.getKey(), data.getKey());
		
		if (res <= 0) {
		
			if (left == null) {
				left = new BinaryTree(value);
			} else {
				left.insert(value);
			}
			
		} else {
			
			if (right == null) {
				right = new BinaryTree(value);
			} else {
				right.insert(value);
			}
		}
		
	}
	
        //Metodo para encontrar un nodo
	public boolean contains(String value) {
		
		int res = stringCompare(value, data.getKey());
		
		if (res == 0) {
			return true;
			
		} else if (res < 0) {
		
			if (left == null) {
				return false;	
			} else {
				return left.contains(value);
			}
		} else {
		
			if (right == null) {
				return false;
			} else {
				return right.contains(value);
			}
		}
	}
	
        //Metodo que hace las traducciones
	public String get(String key) {
	
		int res = stringCompare(key, data.getKey());
		
		if (res == 0) {
			return data.getValue();
			
		} else {
			
			if (res < 0) {
				return left.get(key);
			
			} else {
				return right.get(key);
			}
		}

	}
	
        //Metodo para mostrar los nodos en orden
	public void printInOrder() {
		
		if (left != null) {
			left.printInOrder();
		}
		
		System.out.println(this.data.toString());
		
		if (right != null) {
			right.printInOrder();
		}
	}
	
        //Metodo que compara las asociaciones
	public int stringCompare(String str1, String str2) { 
  
        int l1 = str1.length(); 
        int l2 = str2.length(); 
        int lmin = Math.min(l1, l2); 
  
        for (int i = 0; i < lmin; i++) { 
            int str1_ch = (int)str1.charAt(i); 
            int str2_ch = (int)str2.charAt(i); 
  
            if (str1_ch != str2_ch) { 
                return str1_ch - str2_ch; 
            } 
        } 
        if (l1 != l2) { 
            return l1 - l2; 
        } else { 
            return 0; 
        } 
    }

}

