package healthcare_project;
public class HealthcareDoctor extends Worker {

    public HealthcareDoctor(String namefirst, String namesecond) {
        super(namefirst, namesecond);
        this.profession = "Doctor";
    }

    public void treatPatient(Patient p) {
        //Give the patient some medicine if flu or slightly poor health but nothing chronic
        if (p.getAilment() == "Flu" || (p.getAilment() == "None" && p.calculateCondition("None") > 75)) {

        }
    }

}
