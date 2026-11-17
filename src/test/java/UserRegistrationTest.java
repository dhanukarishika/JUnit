
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/*
 * UC10-UC11. User Registration JUnit Testing
 * Test valid and invalid registration details using
 * assertions and parameterized email validation.
 */

public class UserRegistrationTest {

    // UC10: Happy-path test for valid first name
    @Test
    void testValidFirstName() {
        assertTrue(UserRegistration.validateFirstName("Rishika"));
    }

    // UC10: Sad-path test for invalid first names
    @Test
    void testInvalidFirstName() {
        assertFalse(UserRegistration.validateFirstName("rishika"));
        assertFalse(UserRegistration.validateFirstName("Ri"));
        assertFalse(UserRegistration.validateFirstName("12345"));
    }

    // UC10: Happy-path test for valid last name
    @Test
    void testValidLastName() {
        assertTrue(UserRegistration.validateLastName("Dhanuka"));
    }

    // UC10: Sad-path test for invalid last names
    @Test
    void testInvalidLastName() {
        assertFalse(UserRegistration.validateLastName("dhanuka"));
        assertFalse(UserRegistration.validateLastName("Dh"));
        assertFalse(UserRegistration.validateLastName("12345"));
    }

    // UC10: Happy-path test for valid email
    @Test
    void testValidEmail() {
        assertTrue(UserRegistration.validateEmail("abc.xyz@bl.co.in"));
    }

    // UC10: Sad-path test for invalid emails
    @Test
    void testInvalidEmail() {
        assertFalse(UserRegistration.validateEmail("abc"));
        assertFalse(UserRegistration.validateEmail("abc@.com"));
        assertFalse(UserRegistration.validateEmail("abc@gmail.a"));
    }

    // UC10: Happy-path test for valid mobile number
    @Test
    void testValidMobile() {
        assertTrue(UserRegistration.validateMobile("91 9922992299"));
    }

    // UC10: Sad-path test for invalid mobile numbers
    @Test
    void testInvalidMobile() {
        assertFalse(UserRegistration.validateMobile("9922992299"));
        assertFalse(UserRegistration.validateMobile("91 992299229"));
        assertFalse(UserRegistration.validateMobile("91-9922992299"));
        assertFalse(UserRegistration.validateMobile("91 99229922999"));
    }

    // UC10: Happy-path test for valid password
    @Test
    void testValidPassword() {
        assertTrue(UserRegistration.validatePassword("Rishika@123"));
    }
    // UC10: Sad-path test for invalid passwords
    @Test
    void testInvalidPassword() {
        assertFalse(UserRegistration.validatePassword("rishika@123"));
        assertFalse(UserRegistration.validatePassword("Rishika123"));
        assertFalse(UserRegistration.validatePassword("Rishika@abc"));
        assertFalse(UserRegistration.validatePassword("Rishika@@123"));
    }
    // UC10: Happy-path test for complete user registration
    @Test
    void testValidUserRegistration() {
        assertTrue(UserRegistration.validateUser(
                "Rishika",
                "Dhanuka",
                "abc.xyz@bl.co.in",
                "91 9922992299",
                "Rishika@123"
        ));
    }
    // UC10: Sad-path test for complete user registration
    @Test
    void testInvalidUserRegistration() {
        assertFalse(UserRegistration.validateUser(
                "rishika",
                "Dhanuka",
                "abc.xyz@bl.co.in",
                "91 9922992299",
                "Rishika@123"
        ));
    }
    // UC11: Parameterized tests for valid and invalid email samples
    @ParameterizedTest
    @CsvSource({
            "abc@yahoo.com, true",
            "abc-100@yahoo.com, true",
            "abc.100@yahoo.com, true",
            "abc111@abc.com, true",
            "abc-100@abc.net, true",
            "abc.100@abc.com.au, true",
            "abc@1.com, true",
            "abc@gmail.com.com, true",
            "abc+100@gmail.com, true",
            "abc, false",
            "abc@.com.my, false",
            "abc123@gmail.a, false",
            "abc123@.com, false",
            "abc123@.com.com, false",
            ".abc@abc.com, false",
            "abc()*@gmail.com, false",
            "abc@%*.com, false",
            "abc..2002@gmail.com, false",
            "abc.@gmail.com, false",
            "abc@abc@gmail.com, false",
            "abc@gmail.com.1a, false",
            "abc@gmail.com.aa.au, false"
    })
    void testEmailSamples(String email, boolean expectedResult) {
        assertEquals(
                expectedResult,
                UserRegistration.validateEmail(email),
                "Email validation failed for: " + email
        );
    }
    // Additional test for null email
    @Test
    void testNullEmail() {
        assertFalse(UserRegistration.validateEmail(null));
    }
}
