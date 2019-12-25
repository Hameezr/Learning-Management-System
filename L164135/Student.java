/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadassignment2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static ooadassignment2.OoadAssignment2.obj;
import static ooadassignment2.stulogin.currStudent;

/**
 *
 * @author Salva
 */
public class Student extends User 
{

   
    private ArrayList<Course> cList;
    Marks m;
    AcademicOfficer ao;
    public Student(String email) throws SQLException 
    {
        super(email);
        cList=new ArrayList<>();
        //marks=new ArrayList<>();
        ResultSet rs = obj.getstudent(email);
        if(rs.next())
        {
         String n=rs.getString("name");
         super.name=n;
        }   
    }
    @Override
    public void UpdateInfo(int id,String name,int mn,int age)
    {
        ao.UpdateInfo(id, name, mn, age);
    }
    public Transcript getTrans(int sem) throws SQLException
    {
        ResultSet rs1 = obj.getTranscript(email , sem);
        List<Course> cu = new ArrayList<>();
        List<String> gr = new ArrayList<>();
        Transcript trans=new Transcript(sem,cu,gr);
        while(rs1.next())
        {
         String n1=rs1.getString("courseid");
         String crs=rs1.getString("cname");
         Course cs=new Course(crs,n1);
         cu.add(cs);
         
         String n3=rs1.getString("grade");
         gr.add(n3);
        }
        trans.setCor(cu);
        trans.setGr(gr);
        
        return trans;
    }
    public void ViewMarks() throws SQLException {
        
       m.ViewMarks();
    }
    
}
