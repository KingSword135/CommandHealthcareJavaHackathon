package healthcare_project;
import java.util.*;

public class runHospital {

    public static void main(String[] args) throws Exception {

        Boolean running = true;
        Hospital h = new Hospital();
        int days = 1;

        System.out.println("Enter your password: ");
        Scanner a = new Scanner(System.in);
        String password = a.next();
        if (!password.equals("password") || !password.equals("abc123")) {
            password = a.next();
        }


        while (running) {

            int times = 0;
            System.out.println("Welcome to the Virtual Java Hospital! Enter your choices below.");
            System.out.println("1. Patients 2. Technicians 3. Doctors 4. Staff 5. Facilities");
            Scanner s = new Scanner(System.in);
            int choice = s.nextInt();

            final int patientcapacity = 40;
            final int doctorcapacity = 10;

            int funds = (int)(Math.random() * 400000);
            System.out.println("We are on Day " + days + ". Funds: $" + funds);

            switch(choice) {
                
                case 1: {


                    Boolean patientRun = true;
                    while (patientRun) {
                        System.out.println("Patient Choices:");
                        System.out.println("1. View All Patients 2. View Best Off Patient 3. View Worst Off Patient 4. Add New Patient With Name 5. Add Random New Patient 6. Discharge Patient 7. Add Number of Random Patients (Limit of 40)") ;
                        int patientChoice = s.nextInt();
                        switch(patientChoice) {
                            case 1: {
                                h.showAllPatients();
                                break;
                            }
                            case 2: {
                                System.out.println("The best-off patient in the hospital is: " + h.getBestPatient());
                                break;
                            }
                            case 3: {
                                System.out.println("The worst-off patient in the hospital is: " + h.getWorstPatient());
                                break;
                            }
                            case 4: {
                                System.out.println("Enter firstname");
                                String firstname = s.next();
                                System.out.println("Enter secondname");
                                String secondname = s.next();
                                System.out.println("Enter ailment");
                                String ailment = s.next();

                                //I tried but for some reason it couldn't get ailments to work
                                // if (!ailment.equals("None") || !ailment.equals("Flu") || !ailment.equals("Cancer") || !ailment.equals("Diabetes") || !ailment.equals("Malaria")) {
                                //     while (!ailment.equals("None") || !ailment.equals("Flu") || !ailment.equals("Cancer") || !ailment.equals("Diabetes") || !ailment.equals("Malaria")) {
                                //         System.out.println("You need to have None, Flu, Cancer, Diabetes, or Malaria");
                                //         ailment = s.next();
                                //     }
                                // }

                                Patient p = new Patient(firstname,secondname,ailment);
                                //The hospital can only have 40 patients!!!
                                if (h.getHospitalBedsTaken() >= patientcapacity) {
                                    break;
                                }
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
                                h.getAllPatientNamesandHealths();
                                System.out.println("What patient would you like to discharge? ");
                                h.getAllPatientNamesandHealths();
                                int number1 = s.nextInt();
                                if (number1 < 0 || number1 >= h.patients.size()) {
                                    break;
                                }
                                Patient p = h.patients.get(number1);
                                h.dischargePatient(p);
                                break;
                            case 7:
                                System.out.println("Enter the number of patients you want to administer: ");
                                try {
                                    int number = s.nextInt();
                                    if (h.getHospitalBedsTaken() + number > 40) {
                                        number = patientcapacity - h.getHospitalBedsTaken();
                                    }
                                    for (int i = 0; i < number; ++i) {
                                        createRandomPatient c = new createRandomPatient();
                                        Patient pa = c.createPatient();
                                        h.addPatient(pa);
                                    }
                                    break;
                                }
                                catch (Exception e) {
                                    System.out.println("There was an issue with the input.");
                                    break;
                                }

                        }
                        System.out.println("Do you want to run it again? Enter True if you do, anything else if you do not ");
                        patientRun = s.nextBoolean();
                    }
                    
                    break;
                }
                case 2:{

                    Boolean technicianRun = true;
                    while (technicianRun) {
                        System.out.println("Technician Choices:");
                        System.out.println("1. View All Technicians 2. Add New Technician 3. Fix Facility");
                        int technicianChoice = s.nextInt();
                        switch (technicianChoice) {
                            case 1: {
                                h.getTechnicians();
                                break;
                            }
                            case 2: {
                                System.out.println("Enter firstname");
                                String firstname = s.next();
                                System.out.println("Enter secondname");
                                String secondname = s.next();
                                HealthcareTechnician t = new HealthcareTechnician(firstname, secondname);
                                h.addTechnician(t);
                                break;
                            }
                            case 3: {
                                h.viewAllFacilities();
                                break;
                            }
                        }
                        System.out.println("Do you want to run it again? Enter True if you do, anything else if you do not ");
                        technicianRun = s.nextBoolean();
                    }
                    break;
                }
                case 3:{
                    
                    Boolean doctorRun = true;
                    while (doctorRun) {
                        System.out.println("Doctor Choices:");
                        System.out.println("1. View All Doctors 2. Add New Doctor 3. Treat Patient 4. Dismiss Doctor");
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
                                //Ensure a limit of 10 doctors
                                if (h.getNumDoctors() > doctorcapacity) {
                                    break;
                                }
                                h.addDoctor(d);
                                break;
                            }
                            case 3: {
                                //Only works with no ailment or Flu because i'm out of time
                                h.getAllPatientNamesandHealths();
                                System.out.println("What patient on this list would you like to treat, and using which doctor?");
                                h.getDoctors();
                                int number_patient = s.nextInt();
                                int number_doc = s.nextInt();
                                Patient p = h.patients.get(number_patient);
                                HealthcareDoctor d = (HealthcareDoctor) h.workers.get(number_doc);
                                d.treatPatient(p);
                                break;
                            }
                            case 4: {
                                h.getDoctors();
                                System.out.println("Which doctor would you like to dismiss? ");
                                int option = s.nextInt();
                                if (h.workers.get(option) instanceof HealthcareDoctor) {
                                    HealthcareDoctor d = (HealthcareDoctor) h.workers.get(option);
                                    h.removeWorker(d);
                                }
                                break;
                            }
                        }
                        System.out.println("Do you want to run it again? Enter True if you do, anything else if you do not ");
                        doctorRun = s.nextBoolean();
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
                                h.getTechnicians();
                                break;
                            }
                            case 2: {
                                System.out.println("Enter firstname");
                                String firstname = s.next();
                                System.out.println("Enter secondname");
                                String secondname = s.next();
                                HealthcareStaff si = new HealthcareStaff(firstname, secondname);
                                h.addStaff(si);
                                break;
                            }
                        }
                        System.out.println("Do you want to run it again? Enter True if you do, anything else if you do not ");
                        staffrun = s.nextBoolean();
                    }
                    break;
                }
                case 5: {
                    System.out.println("Facility Choices: ");
                    System.out.println("1. View All Facilities 2. Add New Facility (This will cost money) ");
                    Boolean facilityrun = true;
                    while (facilityrun) {
                        int facilitychoice = s.nextInt();
                        switch(facilitychoice) {
                            case 1: {
                                h.viewAllFacilities();
                                break;
                            }
                            case 2: {
                                System.out.println("Enter the facility you want to enter: Facility choices are: Ambulance, Lab, BloodBank, MRI");
                                String choices = s.next();
                                Facilities facility = new Facilities(choices);
                                //For simplicity we'll just say they are at 100% condition
                                switch(choices) {
                                    case "Ambulance": {
                                        h.facilities.add(facility);
                                        funds -= (int)(Math.random() * 20000) + 100000;
                                        break;
                                    }
                                    case "Lab": {
                                        h.facilities.add(facility);
                                        funds -= (int)(Math.random() * 20000) + 100000;
                                        break;
                                    }
                                    case "BloodBank": {
                                        h.facilities.add(facility);
                                        funds -= (int)(Math.random() * 20000) + 100000;
                                        break;
                                    }
                                    case "MRI": {
                                        h.facilities.add(facility);
                                        funds -= (int)(Math.random() * 20000) + 100000;
                                        break;
                                    }
                                    default:
                                        break;
                                }
                                break;
                            }
                        }
                    }
                }
                default: {
                    System.out.println("Invalid Choice");
                }
                
            }
            System.out.println("Do you want to run it again? Enter True if you do, anything else if you do not to leave the program ");
            running = s.nextBoolean();
            ++times;
            if (times == 5) {
                ++days;
                times = 0;
            }
            if (running == true) {
                continue;
            }
            if (running == false) {
                s.close();
                break;
            }
        }
    }
}
