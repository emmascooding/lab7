package Problem2;

import java.util.List;

public class Employee implements IEmployee{
    String FullName;
    int PointLevel;
    List<Category> AssignedCategories;
    public Employee(String FullName, int PointLevel, List<Category> AssignedCategories){
        this.FullName = FullName;
        this.PointLevel = PointLevel;
        this.AssignedCategories = AssignedCategories;
    }
    public void setFullName(String fullName){
        this.FullName=fullName;
    }
    public String getFullName(){
        return this.FullName;
    }
    public void setPointLevel(int pointLevel){
        this.PointLevel=pointLevel;
    }
    public int getPointLevel(){
        return this.PointLevel;
    }
    public void setAssignedCategories(List<Category> assignedCategories){
        this.AssignedCategories=assignedCategories;
    }
    public List<Category> getAssignedCategories(){
        return this.AssignedCategories;
    }
}
