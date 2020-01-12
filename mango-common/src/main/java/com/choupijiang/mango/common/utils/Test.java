package com.choupijiang.mango.common.utils;


import java.time.LocalDate;
import java.util.*;
import javax.swing.Timer;

public class Test {
    static class Pair<T> {
        T first;
        T second;

        public Pair(){
            first = null;
            second = null;
        }
        public Pair(T first, T second){
            this.first = first;
            this.second = second;
        }
        T getFirst(){
            return first;
        }
        T getSecond(){
            return second;
        }
        void setFirst(T first){
            this.first = first;
        }
        void setSecond(T second){
            this.second = second;
        }
    }


    public  <T extends Comparable> Pair<T> minmax(T[] a){
        if (a == null || a.length == 0){
            return null;
        }
        T min = a[0];
        T max = a[0];
        for (int i = 0; i < a.length; i++) {
            if(min.compareTo(a[i])>0){
                min = a[i];
            }
            if(max.compareTo(a[i])<0){
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }

    public <T> Pair<T> makePair(Class<T> cl){
        try{
            return new Pair<>(cl.newInstance(), cl.newInstance());
        }catch (Exception ex){
            return  null;
        }
    }


    public <T> void swapHelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);

    }

    public void swap(Pair<?> p){
        swapHelper(p);
    }

    public static void main(String[] args) {

        Test test = new Test();
        LocalDate[] birthdays = {
                LocalDate.of(1906,12,19),
                LocalDate.of(2018,1,1),
                LocalDate.of(2019,12,01)

        };

        Pair<LocalDate> mm = test.minmax(birthdays);
        System.out.println("min=" + mm.getFirst());
        System.out.println("max=" + mm.getSecond());

        Pair<String>[] table = (Pair<String>[]) new Pair<?>[10];
        Object[] objarray = table;
        objarray[0] = new Pair<String>("a", "b");

        System.out.println(((Pair<String>)objarray[0]).first);
        Pair<String> p = test.makePair(String.class);
        p = ( Pair<String>)objarray[0];
        System.out.println(p.getSecond());
        test.swap(p);

        System.out.println(p.getFirst());
        String[] a = {"abc", "def", "acf"};
        Arrays.sort(a,
                (first, second) -> first.length() - second.length()
        );

        Arrays.sort(a, String::compareTo);

        Arrays.asList(a).forEach( System.out::println );

//        Timer t = new Timer(1000,e  -> System.out.println("now"));
//
//        t.start();


        Set<String> settings = new HashSet<>();

        settings.add("abc");
        settings.add("cba");
        settings.add("as");

        settings.forEach(System.out::println);
        System.out.println("--");
        Collections.unmodifiableSet(settings).forEach(System.out::println);
        settings.clear();

        System.out.println("--");
        settings.forEach(System.out::println);

    }
}
