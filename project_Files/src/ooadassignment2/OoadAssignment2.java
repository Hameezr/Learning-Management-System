/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadassignment2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Salva
 */
public class OoadAssignment2 
{

     Connection con;
    Statement stmt;
    public static OoadAssignment2 obj=new OoadAssignment2();
    public static String currsemester="4";
    public OoadAssignment2() 
    {
        try
        {
             String s = "jdbc:sqlserver://HMX-PC\\\\SQLEXPRESS:1433;databaseName=assignment";
             con=DriverManager.getConnection(s,"sa","Nokia12.");
            stmt = con.createStatement(); 
            
        }
        catch(Exception e)
        {
            java.lang.System.out.println(e);
        }
    }
    
    public boolean studentLogin(String n, String p) throws SQLException
    {
        String q="Select * from student where email=? and pass=? ";
        PreparedStatement st=con.prepareStatement(q);
        st.setString(1, n);
        st.setString(2, p);
        ResultSet rs=st.executeQuery();
        if(rs.next())
            return true;
         return false;
        
    }
    
    public boolean teacherLogin(String n, String p) throws SQLException
    {
        String q="Select * from teacher where email=? and pass=? ";
        PreparedStatement st=con.prepareStatement(q);
        st.setString(1, n);
        st.setString(2, p);
        ResultSet rs=st.executeQuery();
        if(rs.next())
            return true;
         return false;
        
    }
    
    public boolean acLogin(String n, String p) throws SQLException
    {
        String q="Select * from academicofficer where email=? and pass=? ";
        PreparedStatement st=con.prepareStatement(q);
        st.setString(1, n);
        st.setString(2, p);
        ResultSet rs=st.executeQuery();
        if(rs.next())
            return true;
         return false;   
    }
    
    public String CidbyCname(String cname) throws SQLException
    {
     ResultSet rs;
        String qr="Select cid from course where cname=? ";
        PreparedStatement st=con.prepareStatement(qr);
       st.setString(1, cname);
        rs=st.executeQuery();
        if(rs.next())
            return rs.getString("cid");
        return "";
    }
    
    public String CnamedbyCid(String cid) throws SQLException
    {
     ResultSet rs;
        String qr="Select cname from course where cid=? ";
        PreparedStatement st=con.prepareStatement(qr);
       st.setString(1, cid);
        rs=st.executeQuery();
        if(rs.next())
            return rs.getString("cname");
        return "";
    }
    
    ResultSet getstudents() throws SQLException
    {
        ResultSet rs;
        String q="Select * from student ";
        PreparedStatement st=con.prepareStatement(q);
       
         rs=st.executeQuery();
        return rs;
    }
    ResultSet getstudent(String n) throws SQLException
    {
        ResultSet rs;
        String q="Select * from student where email= ?  ";
        PreparedStatement st=con.prepareStatement(q);
        st.setString(1, n);
       
         rs=st.executeQuery();
        return rs;
    }
    
    ResultSet getCourse(String tid) throws SQLException //for teacher
    {
        ResultSet rs;
        String q="Select * from course where tid= ?  ";
        PreparedStatement st=con.prepareStatement(q);
        st.setString(1, tid);
       
         rs=st.executeQuery();
        return rs;
    }
    
    ResultSet getOfferedCourses() throws SQLException
    {
        ResultSet rs;
        String q="Select * from degree where semesterno= ?  ";
        PreparedStatement st=con.prepareStatement(q);
        st.setInt(1,Integer.parseInt(currsemester));
       
         rs=st.executeQuery();
        return rs;
    }
    ResultSet getCourses() throws SQLException //for teacher
    {
        ResultSet rs;
        String q="Select * from course";
        PreparedStatement st=con.prepareStatement(q);
        
       
        rs=st.executeQuery();
        return rs;
    }
    
    
    ResultSet getSections(String tid,String course) throws SQLException //for teacher
    {
        ResultSet rs;
        String q="Select * from course where tid= ? and cname=?  ";
        PreparedStatement st=con.prepareStatement(q);
        st.setString(1, tid);
       st.setString(2, course);
         rs=st.executeQuery();
        return rs;
    }
    
    ResultSet getStudents(String secid,String cid) throws SQLException //for teacher
    {
        ResultSet rs;
        String q="Select * from section where secid= ? and courseid=?  ";
        PreparedStatement st=con.prepareStatement(q);
        st.setString(1,secid);
        st.setString(2, cid);
       
         rs=st.executeQuery();
        return rs;
    }
    
    int grade(String cid,String stid,String grade) throws SQLException
    {
        int x=0;
        
        String q="insert into transcript values(?,?,?,?)";
         PreparedStatement st=con.prepareStatement(q);
        st.setString(1,stid);
        st.setString(2, cid);
        st.setString(3, currsemester);
        st.setString(4, grade);
        
       x=st.executeUpdate();
       
        return x;
    }
    
    
    int setMarks(String course, String student,String descrip, float marks,String section,float total, float weightage) throws SQLException
    {
        int x=0;
        
        String q="insert into marks values(?,?,?,?,?,?,?)";
        PreparedStatement st=con.prepareStatement(q);
        st.setString(1,student);
        st.setString(2, course);
        st.setString(3, section);
        st.setString(4, descrip);
        st.setFloat(5, marks);
        st.setFloat(6, total);
        st.setFloat(7, weightage);
        
        
       x=st.executeUpdate();
      
        return x;
    }
    
    int setAttendance(String student,String course,String section,String status) throws SQLException
    {
        int x=0;
         String q="insert into attendance values(?,?,?,?,?)";
         PreparedStatement st=con.prepareStatement(q);
        st.setString(1,student);
        st.setString(2, course);
        st.setString(3, section);
        st.setString(4, status);
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        st.setTimestamp(5, date);

       x=st.executeUpdate(); 
        return x;
    }
    
    
    ResultSet getTeacher(String eid) throws SQLException
    {
        ResultSet rs;
        String q="Select id from teacher where email=? ";
        PreparedStatement st=con.prepareStatement(q);
       st.setString(1, eid);
         rs=st.executeQuery();
        return rs;
    }
    
    ResultSet StgetCourse(String sid) throws SQLException
    {
        ResultSet rs;
        String q="Select * from section where stid=? ";
        PreparedStatement st=con.prepareStatement(q);
        st.setString(1, sid);
         rs=st.executeQuery();
        return rs;
    }
    
    ResultSet StgetSection(String sid,String cid) throws SQLException
    {
        ResultSet rs;
        String q="Select * from section where stid=? and courseid=? ";
        PreparedStatement st=con.prepareStatement(q);
        st.setString(1, sid);
        st.setString(2, cid);
         rs=st.executeQuery();
        return rs;
    }
    
    ResultSet getCourseSections(String cid) throws SQLException
    {
        ResultSet rs;
        String q="Select * from course where cname=? ";
        PreparedStatement st=con.prepareStatement(q);
        st.setString(1, cid);
         rs=st.executeQuery();
        return rs;
    }
    
    ResultSet getAC() throws SQLException
    {
        ResultSet rs;
        String q="Select * from academicofficer ";
        PreparedStatement st=con.prepareStatement(q);
       
         rs=st.executeQuery();
        return rs;
    }
    
    ResultSet gettranscript(String n, int sem) throws SQLException
    {
        ResultSet rs;
        String q="Select * from transcript where studentid=? and semesterno=? ";
        PreparedStatement st=con.prepareStatement(q);
       st.setString(1, n);
       st.setInt(2, sem);
         rs=st.executeQuery();
        return rs;
    }
    
    ResultSet getAttendance(String n, String c) throws SQLException
    {
        ResultSet rs;
        String q="Select * from attendance where email=? and cid=? ";
        PreparedStatement st=con.prepareStatement(q);
       st.setString(1, n);
       st.setString(2, c);
         rs=st.executeQuery();
        return rs;
    }
    ResultSet getTranscript(String e, int sem) throws SQLException
    {
        ResultSet rs;
        String q="Select * from Transcript join course on course.cid=transcript.courseid where studentid=? and semesterno=? ";
        PreparedStatement st=con.prepareStatement(q);
       st.setString(1, e);
       st.setInt(2, sem);
         rs=st.executeQuery();
        return rs;
    }
    
    ResultSet getMarks(String n, String c, String sec) throws SQLException
    {
        ResultSet rs;
        String q="Select * from marks where studentid=? and courseid=? and sectionid=? ";
        PreparedStatement st=con.prepareStatement(q);
       st.setString(1, n);
       st.setString(2, c);
       st.setString(3, sec);
         rs=st.executeQuery();
        return rs;
    }
    
    ResultSet getMarksSheet(String c, String sec) throws SQLException
    {
        ResultSet rs;
        String q="Select * from marks where courseid=? and sectionid=? Order by studentid asc";
        PreparedStatement st=con.prepareStatement(q);
       st.setString(1, c);
       st.setString(2, sec);
         rs=st.executeQuery();
        return rs;
    }
    
    ResultSet getAttendance(String n, String c, String sec) throws SQLException
    {
        ResultSet rs;
        String q="Select * from attendance where email=? and cid=? and secid=? ";
        PreparedStatement st=con.prepareStatement(q);
       st.setString(1, n);
       st.setString(2, c);
       st.setString(3, sec);
         rs=st.executeQuery();
        return rs;
    }
    
    boolean dropcoure(String stid,String cid ) throws SQLException
    {
        
        String q1="Delete from section where courseid=? and stid=?";
          PreparedStatement st=con.prepareStatement(q1);
          st.setString(1, cid);
          st.setString(2, stid);
          st.execute();
          
        String q2="Delete from marks where courseid=? and studentid=?";
          PreparedStatement st2=con.prepareStatement(q2);
          st2.setString(1, cid);
          st2.setString(2, stid);
          st2.execute();
          
        String q3="Delete from transcript where courseid=? and studentid=?";
          PreparedStatement st3=con.prepareStatement(q3);
          st3.setString(1, cid);
          st3.setString(2, stid);
          st3.execute();
         
        return true;
    }
    
    boolean AddCourse(String cid,String secid,String stid)
    {
         try {
             String q1="Insert into section values(?,?,?)";
             PreparedStatement st=con.prepareStatement(q1);
             st.setString(1, cid);
             st.setString(2, secid);
             st.setString(3, stid);
             st.execute();
           
             
         } catch (SQLException ex) {
             Logger.getLogger(OoadAssignment2.class.getName()).log(Level.SEVERE, null, ex);
         }
         return true;
    }
    
//    void degreeInsert() throws SQLException
//    {
//        ResultSet rs;
//        String q="Select * from transcript ";
//        PreparedStatement st=null;
//         try {
//             st = con.prepareStatement(q);
//         } catch (SQLException ex) {
//             Logger.getLogger(OoadAssignment2.class.getName()).log(Level.SEVERE, null, ex);
//         }
//         rs=st.executeQuery();
//        
//         
//        String q1="Insert into degree values(?,?,?) ";
//        PreparedStatement st1=null;
//        
//        st1 = con.prepareStatement(q1);
//         
//         String cid=null;
//         int semester=0;
//         while(rs.next())
//         {
//             cid=rs.getString("courseid");
//             semester=rs.getInt("semesterno");
//             st1.setString(1, cid);
//             st1.setInt(2, semester);
//             st1.setInt(3, 3);
//             st1.execute();
//             
//         }
//    }
//    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException 
    {
        // TODO code application logic here
        
         JFrame frame=new Login();
         frame.setSize(400, 400);
         frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
}
