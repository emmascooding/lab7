package Problem2;

public class Ticket implements ITicket{
    private int Id;
    private String Name;
    private Category Category;
    private int Point;
    private String AssignedEmployee;
    private boolean IsCompleted;

    public Ticket(int Id, String Name, Category Category, int Point){
        this.Id=Id;
        this.Name=Name;
        this.Category=Category;
        this.Point=Point;
    }
    public void setId(int id){
        this.Id=id;
    }
    public int getId(){
        return this.Id;
    }
    public void setName(String name){
        this.Name=name;
    }
    public String getName(){
        return this.Name;
    }
    public void setCategory(Category category){
        this.Category = category;
    }
    public Category getCategory(){
        return this.Category;
    }
    public void setPoint(int point){
        this.Point=point;
    }
    public int getPoint(){
        return this.Point;
    }
    public void setIsCompleted(boolean isCompleted){
        this.IsCompleted=isCompleted;
    }
    public boolean getIsCompleted(){
        return this.IsCompleted;
    }
    public void setAssignedEmployee(String assignedEmployee){
        this.AssignedEmployee=assignedEmployee;
    }
    public String getAssignedEmployee(){
        return this.AssignedEmployee;
    }
}
