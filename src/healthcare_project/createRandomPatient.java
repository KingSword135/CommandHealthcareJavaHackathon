package healthcare_project;

import java.util.ArrayList;

public class createRandomPatient {

    public ArrayList<String> firstNames = new ArrayList<>() {
        {
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
        }
    };

    public ArrayList<String> secondNames = new ArrayList<>() {
        {
            firstNames.add("Smith");
            firstNames.add("Markov");
            firstNames.add("Robert");
            firstNames.add("William");
            firstNames.add("Louis");
            firstNames.add("Zach");
            firstNames.add("Henry");
            firstNames.add("David");
            firstNames.add("Charles");
            firstNames.add("Thomas");
        }
    };

    public ArrayList<String> ailments = new ArrayList<>() {
        {
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
        }
    };

    public Patient createPatient() {
        try {
            int pos1 = (int)(Math.random() * firstNames.size());
            int pos2 = (int)(Math.random() * secondNames.size());
            int pos3 = (int)(Math.random() * ailments.size());
            String firstname = firstNames.get(pos1);
            String secondname = firstNames.get(pos2);
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
