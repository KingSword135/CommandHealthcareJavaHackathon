package healthcare_project;
import java.util.*;
import java.io.*;

public class runHospital {

    public static void main(String[] args) throws Exception {

        Boolean running = true;

        while (running) {
            System.out.println("How big do you want the database to be enter? ");
            Scanner s = new Scanner(System.in);
            int size = s.nextInt();
            Hospital h = new Hospital(size);
            System.out.println("How many cycles do you want to run? ");
            int cycles = s.nextInt();
            for (int cycle = 1; cycle < cycles; ++cycle) {
                System.out.println("Month " + cycle + ":");
            }
            System.out.println("Hospital management is done. Do you want to run it again? ");
            System.out.println("For continue, enter 1. For quit, enter 2.");
            int contin = s.nextInt();

            switch(contin) {
                case 1:
                continue;
                case 2:
                break;
                default:
                break;
            }
        }
    }
}
