package com.example.demo.factory;

import com.example.demo.vo.Course;

/**
 * @author kuangjunlin
 */
public class BeanFactory {
    public static Object getClass(Class clazz){
        Object obj = null;
        try{
            obj = Class.forName(clazz.getName()).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }
}
