package Problem2;

import java.util.ArrayList;
import java.util.List;

public class HelpDesk implements IHelpDesk{
    List<IEmployee> Employees;
    List<ITicket> Tickets;
    public HelpDesk(List<IEmployee> employees, List<ITicket> tickets){
        this.Employees = employees;
        this.Tickets = tickets;
    }
    public void addTicket(ITicket ticket){
        Tickets.add(ticket);
    }
    public void addEmployee(IEmployee employee){
        Employees.add(employee);
    }
    public void completeTicket(String employeeFullName, int ticketId){
        for (IEmployee e : Employees){
            if (e.getFullName().equals(employeeFullName)){
                for (ITicket ticket : Tickets){
                    if (ticket.getId()==ticketId){
                        if (ticket.getPoint()<=e.getPointLevel()){
                            ticket.setIsCompleted(true);
                        }
                    }
                }
            }
        }
    }
    public int getWaitingTicketCount(){
        int count = 0;
        for (ITicket ticket : Tickets){
            if (!ticket.getIsCompleted()){
               count++;
            }
        }
        return count;
    }
    public int getCompletedTicketsTotalPoint(){
        int totalPoint = 0;
        for (ITicket ticket : Tickets){
            if (ticket.getIsCompleted()){
                totalPoint+=ticket.getPoint();
            }
        }
        return totalPoint;
    }
    public List<CategoryNode> getTicketsTotalPointByCategory(){
        List<CategoryNode> pointsByCategory = new ArrayList<>();
        int countIT=0;
        int countHR =0;
        int countAcc=0;
        int countSales=0;
        int countMarketing=0;
        int countLegal=0;
        for(ITicket ticket : Tickets){
            switch(ticket.getCategory()){
                case InformationTechnologies: countIT += ticket.getPoint();
                case HumanResources: countHR += ticket.getPoint();
                case Accounting: countAcc += ticket.getPoint();
                case Sales: countSales += ticket.getPoint();
                case Marketing: countMarketing += ticket.getPoint();
                case Legal: countLegal += ticket.getPoint();
            }
        }
        pointsByCategory.add(new CategoryNode(Category.InformationTechnologies, countIT));
        pointsByCategory.add(new CategoryNode(Category.HumanResources, countHR));
        pointsByCategory.add(new CategoryNode(Category.Accounting, countAcc));
        pointsByCategory.add(new CategoryNode(Category.Sales, countSales));
        pointsByCategory.add(new CategoryNode(Category.Marketing, countMarketing));
        pointsByCategory.add(new CategoryNode(Category.Legal, countLegal));
        return pointsByCategory;
    }
    public List <EmployeeNode> getTicketsTotalPointByEmployee(){
        List<EmployeeNode> pointsByEmployee = new ArrayList<>();
        for (IEmployee e : Employees){
            int pointCount = 0;
            for (ITicket ticket : Tickets){
                if (ticket.getAssignedEmployee().equals(e.getFullName())){
                    pointCount += ticket.getPoint();
                }
            }
            pointsByEmployee.add(new EmployeeNode(e, pointCount));
        }
        return pointsByEmployee;
    }
}
