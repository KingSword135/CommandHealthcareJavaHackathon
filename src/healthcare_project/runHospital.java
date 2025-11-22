package healthcare_project;
import java.util.*;
import java.io.*;

public class runHospital {

    public static void main(String[] args) throws Exception {

        Boolean running = true;
        Hospital h = new Hospital();

        while (running) {
            System.out.println("1. Patients 2. Technicians 3. Doctors 4. Staff 5. Facilities");
            Scanner s = new Scanner(System.in);
            int choice = s.nextInt();

            final int patientcapacity = 40;
            final int doctorcapacity = 10;
            final int techniciancapacity = 5;
            final int staffcapacity = 10;

            switch(choice) {
                
                case 1: {

                    System.out.println("Patient Choices:");
                    System.out.println("1. View All Patients 2. View Best Off Patient 3. View Worst Off Patient 4. Add New Patient With Name 5. Add Random New Patient 6. Discharge Patient");
                    Boolean patientRun = true;
                    while (patientRun) {
                        int patientChoice = s.nextInt();
                        switch(patientChoice) {
                            case 1: {
                                h.showAllPatients();
                                break;
                            }
                            case 2: {
                                h.getBestPatient();
                                break;
                            }
                            case 3: {
                                h.getWorstPatient();
                                break;
                            }
                            case 4: {
                                System.out.println("Enter firstname");
                                String firstname = s.next();
                                System.out.println("Enter secondname");
                                String secondname = s.next();
                                System.out.println("Enter ailment");
                                String ailment = s.next();
                                //I tried but for some reason it couldn't get ailment to work
                                // if (!ailment.equals("None") || !ailment.equals("Flu") || !ailment.equals("Cancer") || !ailment.equals("Diabetes") || !ailment.equals("Malaria")) {
                                //     while (!ailment.equals("None") || !ailment.equals("Flu") || !ailment.equals("Cancer") || !ailment.equals("Diabetes") || !ailment.equals("Malaria")) {
                                //         System.out.println("You need to have None, Flu, Cancer, Diabetes, or Malaria");
                                //         ailment = s.next();
                                //     }
                                // }
                                Patient p = new Patient(firstname,secondname,ailment);
                                h.addPatient(p);
                                break;
                            }
                            case 5: {
                                createRandomPatient c = new createRandomPatient();
                                Patient p = c.createPatient();
                                h.addPatient(p);
                                break;
                            }
                            case 6:
                                break;

                        }
                        System.out.println("Do you want to run it again? Enter True if you do, anything else if you do not ");
                        patientRun = s.nextBoolean();
                    }
                    
                    break;
                }
                case 2:{
                    System.out.println("Technician Choices:");
                    System.out.println("1. View All Technicians 2. Add New Technician");
                    Boolean technicianRun = true;
                    while (technicianRun) {
                        int technicianChoice = s.nextInt();
                        switch (technicianChoice) {
                            case 1: {
                                h.getTechnicians();
                                break;
                            }
                            case 2: {

                            }
                        }
                    }
                    break;
                }
                case 3:{
                    System.out.println("Doctor Choices:");
                    System.out.println("1. View All Doctors 2. Add New Doctor 3. Treat Patient 4. Dismiss Doctor");
                    Boolean doctorRun = true;
                    while (doctorRun) {
                        int doctorChoice = s.nextInt();
                        switch(doctorChoice) {
                            case 1: {
                                h.getDoctors();
                                break;
                            }
                            case 2: {
                                System.out.println("Enter firstname");
                                String firstname = s.next();
                                System.out.println("Enter secondname");
                                String secondname = s.next();
                                HealthcareDoctor d = new HealthcareDoctor(firstname, secondname);
                                h.addDoctor(d);
                                break;
                            }
                            case 3: {
                                h.getAllPatientNamesandHealths();
                                System.out.println("What patient on this list would you like to treat?");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 4:{
                    System.out.println("Staff Choices: ");
                    System.out.println("1. View All Staff 2. Add New Hospital Staff Member (NOT DOCTOR)");
                    Boolean staffrun = true;
                    while (staffrun) {
                        int staffChoice = s.nextInt();
                        switch(staffChoice) {
                            case 1: {

                            }
                            case 2: {

                            }
                        }
                    }
                    break;
                }
                default: {
                    System.out.println("Invalid Choice");
                }
                
            }
            System.out.println("Do you want to run it again? Enter True if you do, anything else if you do not ");
            running = s.nextBoolean();
            
        }
    }
}
