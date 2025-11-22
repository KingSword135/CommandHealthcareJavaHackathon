package healthcare_project;

import java.util.ArrayList;

public class Hospital {

    public int hospital_size;
    public int Rooms;

    protected ArrayList<Patient> patients = new ArrayList<>();
    protected ArrayList<Worker> workers = new ArrayList<>();

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

    public boolean addPatient(Patient p) {
        return patients.add(p) ? true : false;
    }
}
