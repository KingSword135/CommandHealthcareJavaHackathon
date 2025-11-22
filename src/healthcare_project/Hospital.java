package healthcare_project;

import java.util.ArrayList;

public class Hospital {

    public int hospital_size;
    public int Rooms;

    protected ArrayList<Patient> patients = new ArrayList<>();
    protected ArrayList<Worker> workers = new ArrayList<>();
    protected ArrayList<Facilities> facilities = new ArrayList<>();

    public Hospital() {

    }

    public void showAllPatients() {
        for (Patient p : patients) {
            System.out.println(p.toString());
        }
    }

    public Patient getWorstPatient() {
        int worst_condition = 9999;
        Patient worst_off = null;
        for (Patient p : patients) {
            int new_worst = p.getCondition();
            if (new_worst < worst_condition) {
                worst_condition = p.getCondition();
                worst_off = p;
            }
        }
        return worst_off;
    }

    public Patient getBestPatient() {
        int worst_condition = -9999;
        Patient best_off = null;
        for (Patient p : patients) {
            int new_worst = p.getCondition();
            if (new_worst > worst_condition) {
                worst_condition = p.getCondition();
                best_off = p;
            }
        }
        return best_off;
    }

    public void getDoctors() {
        for (Worker w : workers) {
            if (w.profession == "Doctor") {
                System.out.println(w.toString());
            }
        }
    }

    public void getTechnicians() {
        for (Worker w : workers) {
            if (w.profession == "Technician") {
                System.out.println(w.toString());
            }
        }
    }

    public void getStaff() {
        for (Worker w : workers) {
            if (w.profession == "Staff") {
                System.out.println(w.toString());
            }
        }
    }

    public boolean addPatient(Patient p) {
        return patients.add(p) ? true : false;
    }

    public boolean addDoctor(HealthcareDoctor d) {
        return workers.add(d) ? true : false;
    }

    public boolean addTechnician(HealthcareTechnician t) {
        return workers.add(t) ? true : false;
    }

    public boolean addStaff(HealthcareStaff s) {
        return workers.add(s) ? true : false;
    }

    public boolean dischargePatient(Patient p) {
        //If patient is healthy, you can remove them safely
        if (p.getCondition() >= 80) {
            patients.remove(p);
            return true;
        }
        //Lazy removal method but whatever
        else if (p.getCondition() >= 50 && p.getCondition() < 80) {
            int chance = (int)(Math.random() * 2);
            if (chance == 0) {
                patients.remove(p);
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public void getAllPatientNamesandHealths() {
        System.out.println("Name | Condition");
        for (Patient p : patients) {
            System.out.println(p.getName() + " " + p.getCondition());
        }
    }

    public int getHospitalBedsTaken() {
        return patients.size();
    }

    public void viewAllFacilities() {
        for (Facilities f : facilities) {
            System.out.println(f.toString());
        }
    }

}
