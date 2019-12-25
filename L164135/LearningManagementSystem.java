/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadassignment2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Salva
 */
public class LearningManagementSystem {
    AcademicOfficer a;
    Teacher t;
    Student s;
    Course c1;
    static public List<User> UserList= new ArrayList(); 
    // Make some sort of list for transcript or whatever .. 
    
    LearningManagementSystem()
    {
        UserList=null;
        // Set that to null too 
    }
    static public boolean SearchUser(int id)
    {
        int temp=0;
        for(int i=0;i<UserList.size();i++)
        {
            temp=UserList.get(i).GetID();
            if (temp==id)
                return true;
        }
        return false;
    }
     static public void UserDetails(int id)
    {
        System.out.println("User ID: "+UserList.get(id).GetID());
        System.out.println("Name: "+UserList.get(id).getName());
        System.out.println("Type: "+UserList.get(id).getType());
        System.out.println("MobileNo: "+UserList.get(id).getMN());
    }
}
