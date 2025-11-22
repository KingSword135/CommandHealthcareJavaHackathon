package healthcare_project;
public class HealthcareDoctor extends Worker {

    private int Proficiency;

    public HealthcareDoctor(String namefirst, String namesecond) {
        super(namefirst, namesecond);
        this.profession = "Doctor";
        this.Proficiency = (int)(Math.random() * 101);
        this.wage = Math.random() * 45 + 25;
    }

    public void treatPatient(Patient p) {
        //Give the patient some medicine if flu or slightly poor health but nothing chronic
        if (p.getAilment() == "Flu" || (p.getAilment() == "None" && p.calculateCondition("None") > 75)) {
            if (Proficiency >= 50) {
                int con = p.getCondition();
                p.setCondition(con + (5 + Proficiency / 25));
            }
            else {

            }
        }
    }

    public int getProfficiency() {
        return Proficiency;
    }

    public String toString() {
        String msg = "Info: \n";
        msg += "Profession: " + getProfession() + "\n";
        msg += "Name: " + getName() + "\n";
        msg += "Proficiency: " + getProfficiency() + "\n";
        msg += "Annual Pay: " + String.format("%.2f", getAnnualPay()) + "\n";
        return msg;
    }

}
