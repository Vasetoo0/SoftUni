package ObjectsAndClasses.StudentsPartII;

public class Student {
    private String firstName;
    private String lastName;
    private int years;
    private String homeTown;

    public Student(String firstName, String lastName, int years, String homeTown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.years = years;
        this.homeTown = homeTown;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

}
