/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop7.pkg8;

/**
 *
 * @author Jason
 */
public class Student {
    private String firstName,lastName,department;
    private double grade;
    
    public Student(String pFirstN,String pLastN, double pGrade,String pDept){
        firstNSetter(pFirstN);
        lastNSetter(pLastN);
        gradeSetter(pGrade);
        deptSetter(pDept);
        
    }
    public void firstNSetter(String pFirstN){       
        this.firstName=pFirstN;
    }
    
    public void lastNSetter(String pLastN){
        this.lastName=pLastN;
    }
    
    public void gradeSetter(double pGrade){
       
        this.grade=pGrade;
    }
    
    public void deptSetter(String pDept){
        this.department=pDept;
    }
    
    public String firstNGetter(){
        return this.firstName;
    }
    
    public String lastNGetter(){
        return this.lastName;
    }
    
    public double gradeGetter(){
        return this.grade;
    }
    
    public String deptGetter(){
        return this.department;
    }
    
    public String getName(){
        return firstNGetter().concat(" "+lastNGetter());
    }
    
    @Override
    public String toString(){
        return String.format("%-6s   %-8s    %.2f      %s\n",firstNGetter(),lastNGetter(),gradeGetter(),deptGetter());
                
    }
    
    //public boolean equals(){}   to be defined as well
    
}
