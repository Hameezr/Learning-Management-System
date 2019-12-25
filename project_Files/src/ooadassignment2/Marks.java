/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadassignment2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static ooadassignment2.OoadAssignment2.obj;
import static ooadassignment2.stulogin.currStudent;

/**
 *
 * @author hamee
 */
public class Marks {
    List<Course> cor;
    List<Section> sec;
    List<Student> stu;
    float marks;
    String descrip;
    List<Teacher> tea;
    
    public Marks(List<Course> cor, List<Section> sec, List<Student> stu,float marks,String desc,List<Teacher> tea) 
	{
        this.cor = cor;
        this.sec = sec;
        this.stu=stu;
        this.marks=marks;
        this.descrip=desc;
        this.tea=tea;
    }
    public void setCor(List<Course> cor) {
        this.cor = cor;
    }
    public void setSec(List<Section> sec) {
        this.sec = sec;
    }
    public void setMarks(float marks) {
        this.marks = marks;
    }
    public void setDesc(String d) {
        this.descrip= d;
    }
    public String getDesc()
    {
        return descrip;
    }
    public float getMarks()
    {
        return marks;
    }
    public void UpdateMarks(String tid) throws SQLException {
       
        String teacher="";
        if(tid=="")
            tid="1";
        teacher=tid;
        ResultSet rs=obj.getCourse(tid);
        while(rs.next())
        {
            String t=rs.getString("cname");
        }
    }
       public void ViewMarks() throws SQLException {
        
        ResultSet rs=obj.StgetCourse(currStudent.email);
        while(rs.next())
        {
           String r=rs.getString("courseid");
           r=obj.CnamedbyCid(r);
        }
    }
}
