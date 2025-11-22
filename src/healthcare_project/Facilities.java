package healthcare_project;

public class Facilities {

    private String type;
    private int condition;

    public Facilities () {

    }

    public String getType() {
        return type;
    }

    public int getCondition() {
        return condition;
    }

    public String toString() {
        String msg = "Type: " + getType() + "\nCondition: " + getCondition();
        return msg;
    }
}
