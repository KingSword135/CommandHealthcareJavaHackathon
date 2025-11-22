package healthcare_project;
public class Worker {
    
    protected String profession;
    protected double wage;
    private int daysWorked;
    private int hoursWorked;
    private String firstname;
    private String secondname;

    public Worker(String namefirst, String namesecond) {
        
        this.firstname = namefirst;
        this.secondname = namesecond;
        this.daysWorked = ((int)(Math.random()) * 7) + 1;
        this.hoursWorked = ((int)(Math.random()) * 12) + 1;

    }

    public double getWage() {
        return wage;
    }

    public int getDaysWorked() {
        return daysWorked;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getAnnualPay() {
        return getHoursWorked() * getDaysWorked() * getWage() * 52;
    }

    public int getTotalHoursWorked() {
        return hoursWorked * daysWorked;
    }

    public String getName() {
        return firstname + " " + secondname;
    }

    public String getProfession() {
        return profession;
    }

}
