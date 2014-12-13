/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.misc;

/**
 *
 * @author Carina
 */
public class Pair {
    private int first;
    private int second;
    
    public Pair (int begin, int end) {
        this.first = begin;
        this.second = end;
    }
    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
   
    
   
    
    
}
