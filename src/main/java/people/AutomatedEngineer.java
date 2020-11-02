package people;

public class AutomatedEngineer extends Engineer {
    public AutomatedEngineer(int age, int experience) {
        super(age, experience*3, experience);
    }

    @Override
    public String toString() {
        return "AutomatedEngineer{" +
                "skill=" + skill +
                ", experience=" + experience +
                '}';
    }
}
