package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CaregiverTest {

    @Test
    public void changeNameTest() {
        Caregiver caregiver1 = new Caregiver("James", "Father");
        String caregiverName = caregiver1.getCaregiverName();

        assertEquals("James", caregiverName);

        caregiver1.changeName("Alfred");
        String newCaregiverName = caregiver1.getCaregiverName();

        assertEquals("Alfred", newCaregiverName);
    }

}
