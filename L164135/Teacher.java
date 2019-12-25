/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadassignment2;

import java.sql.ResultSet;
import java.sql.SQLException;
import static ooadassignment2.OoadAssignment2.obj;

/**
 *
 * @author Salva
 */
public class Teacher extends User{
    Section sec;
    Transcript t;
    Marks m;
    AcademicOfficer ao;
    public Teacher(String name) {
        super(name);
    }
    public void UpdateMarks(String tid) throws SQLException {
        
        m.UpdateMarks(tid);
    }
    @Override
    public void UpdateInfo(int id,String name,int mn,int age)
    {
        ao.UpdateInfo(id, name, mn, age);
    }
    
}
