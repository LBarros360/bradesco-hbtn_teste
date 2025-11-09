import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Person {

    private String name;
    private String surName;
    private Date birthDate;
    private boolean anotherCompanyOwner;
    private boolean pensioner;
    private boolean publicServer;
    private float salary;

    public Person(String name, String surName, Date birthDate, boolean anotherCompanyOwner, boolean pensioner, boolean publicServer) {
        this.name = name;
        this.surName = surName;
        this.birthDate = birthDate;
        this.anotherCompanyOwner = anotherCompanyOwner;
        this.pensioner = pensioner;
        this.publicServer = publicServer;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String fullName () {
        return this.name + " " + this.surName;
    }

    public float calculateYearlySalary() {
        return this.salary * 12;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isAnotherCompanyOwner() {
        return anotherCompanyOwner;
    }

    public void setAnotherCompanyOwner(boolean anotherCompanyOwner) {
        this.anotherCompanyOwner = anotherCompanyOwner;
    }

    public boolean isPensioner() {
        return pensioner;
    }

    public void setPensioner(boolean pensioner) {
        this.pensioner = pensioner;
    }

    public boolean isPublicServer() {
        return publicServer;
    }

    public void setPublicServer(boolean publicServer) {
        this.publicServer = publicServer;
    }

    public boolean isMEI() {
        if (isAtLeast18YearsOld(this.birthDate)
            && calculateYearlySalary() < 130000
            && !this.anotherCompanyOwner
            && !this.pensioner
            && !this.publicServer) {
                return true;
        } else {
            return false;
        }
    }

    public static boolean isAtLeast18YearsOld(Date birthDateUtil) {
        // Convert java.util.Date to LocalDate
        LocalDate birthDate = birthDateUtil.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate currentDate = LocalDate.now();

        // Calculate the period between the birth date and the current date
        Period age = Period.between(birthDate, currentDate);

        // Check if the age in years is 18 or more
        return age.getYears() >= 18;
    }
}
