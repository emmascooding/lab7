package Problem2;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<IEmployee> employees = new ArrayList<>();
        for (int i=0;i<n;i++){
            System.out.println("Enter next employee: ");
            String fullName = scan.next(Pattern.compile("\\w+\\s+\\w+"));
            int points = scan.nextInt();
            List<Category> assignedCategories = new ArrayList<>();
                String category = scan.next(Pattern.compile("\\w+"));
                while(!category.equals("  ")){
                    assignedCategories.add(Category.valueOf(category));
                    category = scan.next(Pattern.compile("\\w+"));
                }
            employees.add(new Employee(fullName, points, assignedCategories));
        }
        System.out.println("Enter the number of tickets: ");
        int m = scan.nextInt();
        List<ITicket> tickets = new ArrayList<>();
        for (int i = 0; i<m; i++){
            int id = scan.nextInt();
            String name = scan.next();
            String category = scan.next();
            int point = scan.nextInt();
            tickets.add(new Ticket(id, name, Category.valueOf(category), point));
        }
        HelpDesk helpDesk = new HelpDesk(employees, tickets);
        System.out.println("Enter the number of Complete Ticket Calls: ");
        int k = scan.nextInt();
        for (int i=0; i<k; i++){
            String fullName = scan.next()+" "+scan.next();
            int ticketId = scan.nextInt();
            helpDesk.completeTicket(fullName, ticketId);
        }
        StringBuilder sb = new StringBuilder("Menu:\n");
        sb.append("1: get waiting tickets count\n").append("2: get completed tickets total points\n").append("3: get tickets total points by category\n").append("4: get tickets total points by employee\n").append("5: close menu\n");
        System.out.println("Enter a number from the menu: ");
        int actionNumber = scan.nextInt();
        while (actionNumber!=5){
            switch (actionNumber){
                case 1: System.out.println(helpDesk.getWaitingTicketCount());
                case 2: System.out.println(helpDesk.getCompletedTicketsTotalPoint());
                case 3: System.out.println(helpDesk.getTicketsTotalPointByCategory().toString());
                case 4: System.out.println(helpDesk.getTicketsTotalPointByEmployee().toString());
                default: System.out.println("Invalid Number");
            }
            actionNumber = scan.nextInt();
        }
    }
}
