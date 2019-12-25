/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadassignment2;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Salva
 */
public class Transcript {
    int semester;
    float CGPA;
    float SGPA;
    List<Course> cor;
    List<String> gr;

    public Transcript(int semester, List<Course> cor, List<String> gr) 
	{
        this.semester = semester;
        this.cor = cor;
        this.gr = gr;
    }

    public String print()
    {
        String tr="";
        boolean[] array = new boolean[20];
        int foo;
        int sz=cor.size();
        for (int i = 0; i < sz ; i++) 
        {
            foo = Integer.parseInt(cor.get(i).id);
            if(array[foo]==false)
            {
                tr+="Course Name:   "+cor.get(i).getName() +"   Grade:  "+gr.get(i)+"\n";
                array[foo]=true;    // Course printed
                //sz--;
            }
        }
        return tr;
    }

    public void setCor(List<Course> cor) {
        this.cor = cor;
    }

    public void setGr(List<String> gr) 
    {
        this.gr = gr;
    }
}
