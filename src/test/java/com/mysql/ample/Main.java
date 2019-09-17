package com.mysql.ample;

import java.util.HashMap;
import java.util.Map;

public class Main {

    /**
     * 证明对象是值的引用在传递，而不是值在传递
     * @param i
     * @param j
     * @param maps
     */
    public static void swap(Integer i, Integer j, Map<String,String> maps) {
        Integer temp = new Integer(i);
        i = j;
        j = new Integer(3);
        maps.clear();
    }
    public static void main(String[] args) {
        Integer i = new Integer(10);
        Integer j = new Integer(20);
        Map<String,String> maps = new HashMap<>();
        maps.put("01","01");
        System.out.println(maps.size());
        swap(i, j, maps);
        System.out.println("i = " + i + ", j = " + j);
        System.out.println(maps.size());
    }

}
