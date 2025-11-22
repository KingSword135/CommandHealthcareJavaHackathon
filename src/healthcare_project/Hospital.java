package healthcare_project;

import java.util.ArrayList;

public class Hospital {

    public int hospital_size;
    public int Rooms;

    protected ArrayList<Patient> patients = new ArrayList<>();
    protected ArrayList<Worker> workers = new ArrayList<>();

    public Hospital(int size) {
        if (size < 0) {
            this.hospital_size = -1 * size;
        }
        else {
            this.hospital_size = size;
        }
        this.Rooms = size / 2;




    }

    public Patient getWorstPatient(ArrayList<Patient> patients) {
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

    public Patient getBestPatient(ArrayList<Patient> patients) {
        int worst_condition = -9999;
        Patient worst_off = null;
        for (Patient p : patients) {
            int new_worst = p.getCondition();
            if (new_worst > worst_condition) {
                worst_condition = p.getCondition();
                worst_off = p;
            }
        }
        return worst_off;
    }


}
