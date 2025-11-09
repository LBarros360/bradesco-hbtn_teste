import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class PersonTest {

    private static Person person;

    @BeforeAll
    static void setup() {
       person = new Person("Paul", "McCartney", new Date(2000), true, true, true);
    }

    @Test
    void show_full_name() {
        String fullName = person.fullName();
        Assertions.assertEquals("Paul McCartney", fullName);
    }

    @Test
    void test_calculateYearlySalary() {
        person.setSalary(1200);
       float salary = person.calculateYearlySalary();
       Assertions.assertEquals(14400, salary);
    }

    @Test
    void person_is_MEI() {
        person.setPensioner(false);
        person.setAnotherCompanyOwner(false);
        person.setPublicServer(false);
        var isValid = person.isMEI();
        Assertions.assertTrue(isValid);
    }

    @Test
    void person_is_not_MEI() {
        var isValid = person.isMEI();
        Assertions.assertFalse(isValid);
    }
}
