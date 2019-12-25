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
    double CGPA;
    double SGPA;
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
        double[] g=new double[20];
        int sz=cor.size();
        int index=0;
        for (int i = 0; i < sz ; i++) 
        {
            foo = Integer.parseInt(cor.get(i).id);
            if(array[foo]==false)
            {
                tr+="Course Name:   "+cor.get(i).getName() +"   Grade:  "+gr.get(i)+"\n";
                array[foo]=true;    // Course printed
                if(gr.get(i).equals("A"))
                {
                    g[index]=4.0;
                    index++;
                }
                if(gr.get(i).equals("B"))
                {
                    g[index]=3.0;
                    index++;
                }
                if(gr.get(i).equals("C"))
                {
                    g[index]=2.0;
                    index++;
                }
                if(gr.get(i).equals("D"))
                {
                    g[index]=1.0;
                    index++;
                }
                if(gr.get(i).equals("F"))
                {
                    g[index]=0.0;
                    index++;
                }
                //sz--;
            } 
        }
        double sum=0;
        for(int in=0;in<index;in++)
        {
            sum+=(g[in]*3);
        }
        sum=sum/((index)*3);
        tr+="\n\n\n\n\n\nGPA: "+sum;
        SGPA=sum;
        return tr;
    }

    public void setCor(List<Course> cor) {
        this.cor = cor;
    }
    public double GetSGPA()
    {
        return SGPA;
    }
    public void setGr(List<String> gr) 
    {
        this.gr = gr;
    }
}
