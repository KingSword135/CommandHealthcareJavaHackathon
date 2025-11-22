package healthcare_project;
import java.util.*;
import java.io.*;

public class runHospital {

    public static void main(String[] args) throws Exception {

        Boolean running = true;
        Hospital h = new Hospital();

        while (running) {
            System.out.println("1. Patients 2. Technicians 3. Doctors 4. Staff");
            Scanner s = new Scanner(System.in);
            int choice = s.nextInt();

            switch(choice) {

                case 1: {
                    System.out.println("Patient Choices:");
                    System.out.println("1. View All Patients 2. View Best Off Patient 3. View Worst Off Patient 4. Add New Patient With Name 5. Add Random New Patient");
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
                                // if (ailment != "None" || ailment != "Flu" || ailment != "Cancer" || ailment != "Diabetes" || ailment != "Malaria") {
                                //     while (ailment != "None" || ailment != "Flu" || ailment != "Cancer" || ailment != "Diabetes" || ailment != "Malaria") {
                                //         ailment = s.next();
                                //     }
                                // }
                                Patient p = new Patient(firstname,secondname,ailment);
                                h.addPatient(p);
                            }
                            case 5: {
                                createRandomPatient c = new createRandomPatient();
                                Patient p = c.createPatient();
                                // h.addPatient(p);
                            }

                        }
                        System.out.println("Do you want to run it again? True if you do, anything else if you do not ");
                        patientRun = s.nextBoolean();
                    }
                    
                    break;
                }
                case 2:{

                }
                case 3:{

                }
                case 4:{

                }
                default: {
                    System.out.println("Invalid Choice");
                }
                
            }

            running = s.nextBoolean();

        }
    }
}
