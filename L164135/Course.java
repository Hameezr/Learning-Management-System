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
public class Course {
    String name;
    String id;
    List<Section> sec;
    
    Course(String name,String id)
    {
        this.name=name;
        this.id=id;
        sec=new ArrayList<>();
        
    }

    public String getName() {
        return name;
    }
    
}
