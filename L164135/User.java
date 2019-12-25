/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadassignment2;

/**
 *
 * @author Salva
 */
public abstract class User {
    String email;
    String name;
    protected String type;
    protected int mobileNumber;
    protected int UserId;    // When we add a user , we increment the id number. 
    int age;
    public User(String e) 
    {
        this.email = e;
    }
    
    User() 
        {
            type = null;
            name = null;
            UserId = 0;
            mobileNumber=0;
        }
    User(int id,String type,String name,int mn,int age)
    {
        // search for the id, if it exists print a message that a user with this id already exists 
        boolean check =LearningManagementSystem.SearchUser(id);
        if(!check)
        {
            this.UserId=id;
            this.name=name;
            this.type=type;
            this.mobileNumber=mn;   
            this.age=age;
        }
        else{
                System.out.println("This userId already exists\n");
            }
    }
    
    abstract public void UpdateInfo(int id,String name,int mn,int age);
    public String getName()
    {
        return name;
    }
    public String getType()
    {
        return type;
    }
    public int getMN()
    {
        return mobileNumber;
    }
    public int GetID()
    {
        return UserId;
    }
    
    public void set_Name(String Name) {
        this.name = Name;
    }
}
