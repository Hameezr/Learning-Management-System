/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadassignment2;

import java.util.Scanner;

/**
 *
 * @author Salva
 */
public class AcademicOfficer extends User
{
    
    boolean reg;
    String deadline;
    Student std;
    public AcademicOfficer(String name,String ded) {
        super(name);
        reg=false;
        deadline=ded;
    }
    
    void openregistration(){
        reg=true;
    }
    void closeregistration(){
       reg=false;
    }
    public String Getdeadline(){
        return deadline;
    }
    @Override
    public void UpdateInfo(int id,String name,int mn,int age)
    {
        boolean check = LearningManagementSystem.SearchUser(id);
        if (check)
        {
            if(LearningManagementSystem.UserList.get(id).getType().equals("Sudent"))
            {
                // Make a search function for student too and roll number unique bhee check krlo
                this.UserId=id;
                this.name=name;
                this.mobileNumber=mn;
                this.age=age;
                Scanner input=new Scanner(System.in);
                System.out.println("Enter the Roll Number of Student\n");
                String rn=input.nextLine();
                
            }
            else if (LearningManagementSystem.UserList.get(id).getType()=="Teacher")
            {
                this.UserId=id;
                this.name=name;
                this.mobileNumber=mn;
                this.age=age;
                
            }
        }
        else
        {
            System.out.println("No User with this UserId exists\n");
        }
    }
}
