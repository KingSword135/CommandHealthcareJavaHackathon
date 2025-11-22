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
            ailments.add("Nothing");
            ailments.add("Nothing");
            ailments.add("Nothing");
            ailments.add("Nothing");
            ailments.add("Nothing");
            ailments.add("Flu");
            ailments.add("Flu");
            ailments.add("Cancer");
            ailments.add("Diabetes");
        }
    };

    public Patient createPatient() {
        try {
            String firstname = firstNames.get((int)(Math.random() * 10));
            String secondname = firstNames.get((int)(Math.random() * 10));
            String ailment = ailments.get((int)(Math.random() * 9));
            Patient p = new Patient(firstname, secondname, ailment);
            return p;
        }
        catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
}
