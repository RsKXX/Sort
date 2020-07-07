package com.design;

import com.design.singleton.LazySingleton;

public class Test {
    public static void main(String[] args){
        LazySingleton single = LazySingleton.getInstance();
        single.setAge(12);
        LazySingleton single1 = LazySingleton.getInstance();
        single1.setAge(1122);
        if(single==single1){
            System.out.println(single.getAge()+"danli "+single1.getAge());
        }else{
            System.out.println("budanli ");
        }
    }
}
