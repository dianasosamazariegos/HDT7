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


import java.util.*;

public class Asociacion<K,V> implements Map.Entry<K,V> {

    
    //Variables
    protected K key; 
    protected V value;
    private HashMap<K,V> association;
    
    //Extraído de: https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/

    public Asociacion(K k, V v) {
        this.key = k;
        this.value = v;
    }
    
    public Asociacion(K key) {
        this(key,null);
    }
    
    //Metodo que implementa el HasMap para organizar las asociaciones
    public Asociacion() {
	association = new HashMap<K,V>();
    }
    
    public boolean equals(Object other) {
        Asociacion otherAssoc = (Asociacion)other;
        return getKey().equals(otherAssoc.getKey());
    }
    
    public int hashCode() {
        return getKey().hashCode();
    }
    
    public V getValue(){
        return value;
    }

    public K getKey() {
        return key;
    }

    public V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }
    
    public void put(K key, V value){
            association.put(key, value);
	}
	
	public V get(Object key){
		return association.get(key);
	}

    public String toString() {
    
        StringBuffer str = new StringBuffer();
        
        str.append("(" + getKey() + ", " + getValue() + ")");
        return str.toString();
    }
}