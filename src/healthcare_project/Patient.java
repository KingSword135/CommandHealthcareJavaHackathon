package healthcare_project;

public class Patient {

    private String name1;
    private String name2;
    private int patientID;
    private int condition;
    private int age;
    private String ailment;

    public Patient(String namefirst, String namesecond, String ailment) {

        this.name1 = namefirst;
        this.name2 = namesecond;
        this.patientID = ((int)(Math.random()) * 9999);
        this.ailment = ailment;
        this.age = (int)(Math.random() * 99);
        this.condition = ((int)(calculateCondition(ailment) * ageHealthCalculation(age)));

    }

    public int calculateCondition(String ailment) {

        if (ailment == "None") {
            return ((int)(Math.random()) * 51) + 50;
        }
        else if (ailment == "Flu") {
            return ((int)(Math.random()) * 51) + 40;
        }
        else if (ailment == "Cancer") {
            return ((int)(Math.random()) * 90) + 4;
        }
        else if (ailment == "Diabetes") {
            return ((int)(Math.random()) * 55) + 25;
        }
        else {
            return -1;
        }

    }

    public int getAge() {
        return age;
    }

    public int getPatientID() {
        return patientID;
    }

    public double ageHealthCalculation(int age) {
        if (age <= 60) {
            return 1.0;
        }
        else if (age > 60 && age <= 70) {
            return 1.60 - age / 100.0;
        }
        else {
            return 0.9;
        }
    }

    public String getAilment() {
        return ailment;
    }

    public int getCondition() {
        return condition;
    }

    public String toString();

}
