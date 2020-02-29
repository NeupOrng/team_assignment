/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Orng
 */
public class Student {
    private String id;
    private String name;
    private String age;
    
    Student(){}
    Student(String id, String name, String age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getAge(){
        return this.age;
    }
    
    public void setId(String id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAge(String age){
        this.age=age;
    }
}
