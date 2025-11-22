package healthcare_project;

import java.util.ArrayList;

public class createRandomPatient {

    public Patient createPatient() {

    ArrayList<String> firstNames = new ArrayList<>(10);
    ArrayList<String> secondNames = new ArrayList<>(10);
    ArrayList<String> ailments = new ArrayList<>(10);

    firstNames.add("Leah");
    firstNames.add("Jones");
    firstNames.add("Alex");
    firstNames.add("Matthew");
    firstNames.add("Joe");
    firstNames.add("Zhao");
    firstNames.add("Monica");
    firstNames.add("Abgail");
    firstNames.add("Nicholas");
    firstNames.add("Samantha");
    secondNames.add("Smith");
    secondNames.add("Markov");
    secondNames.add("Robert");
    secondNames.add("William");
    secondNames.add("Louis");
    secondNames.add("Zach");
    secondNames.add("Henry");
    secondNames.add("David");
    secondNames.add("Charles");
    secondNames.add("Thomas");
    ailments.add("None");
    ailments.add("None");
    ailments.add("None");
    ailments.add("None");
    ailments.add("None");
    ailments.add("Flu");
    ailments.add("Flu");
    ailments.add("Cancer");
    ailments.add("Diabetes");
    ailments.add("Malaria");

        try {
            int pos1 = (int)(Math.random() * 10);
            int pos2 = (int)(Math.random() * 10);
            int pos3 = (int)(Math.random() * 10);
            String firstname = firstNames.get(pos1);
            String secondname = secondNames.get(pos2);
            String ailment = ailments.get(pos3);
            Patient p = new Patient(firstname, secondname, ailment);
            return p;
        }
        catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
}
