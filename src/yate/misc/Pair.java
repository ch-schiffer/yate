/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.misc;

/**
 * Diese Klasse stellt ein generisches Tupel dar
 * @author Carina
 * @param <T> Typ des ersten Arguments
 * @param <V> Typ des zweiten Arguments
 */
public class Pair<T,V> {
    private T first;
    private V second;
    
    /**
     * Konstruktor, erstellt eine Instanz der Klasse
     * @param first Erstes Element
     * @param second Zweites Element
     */
    public Pair (T first, V second) {
        this.first = first;
        this.second = second;
    }
    
    /**
     * Gibt das erste Element zurück
     * @return Erstes Element
     */
    public T getFirst() {
        return first;
    }

    /**
     * Legt das erste Element fest
     * @param first Erstes Element
     */
    public void setFirst(T first) {
        this.first = first;
    }

    /**
     * Gibt das erste Element zurück
     * @return Zweites Element
     */
    public V getSecond() {
        return second;
    }

    /**
     * Legt das zweite Element fest
     * @param second Zweites Element
     */
    public void setSecond(V second) {
        this.second = second;
    }
   
    
   
    
    
}
