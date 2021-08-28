package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessTest {

    @Test
    @DisplayName("ไม่กำหนดชื่อ จะเกิด exception First name is required.")
    public void caseExceptionFirstName() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        try {
            registerBusiness.register(null,new Speaker());
            fail();
        } catch (ArgumentNullException e) {
            if (!e.getMessage().equals("First name is required.")) {
                fail();
            }
        }
    }

    @Test
    @DisplayName("ไม่กำหนดสกุล จะเกิด exception Last name is required.")
    public void caseExceptionLastName() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("firstName");
        try {
            registerBusiness.register(null,speaker);
            fail();
        } catch (ArgumentNullException e) {
            if (!e.getMessage().equals("Last name is required.")) {
                fail();
            }
        }
    }

    @Test
    @DisplayName("ไม่กำหนด Email จะเกิด exception Email is required.")
    public void caseExceptionEmail() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("firstName");
        speaker.setLastName("lastName");
        try {
            registerBusiness.register(null,speaker);
            fail();
        } catch (ArgumentNullException e) {
            if (!e.getMessage().equals("Email is required.")) {
                fail();
            }
        }
    }

    @Test
    @DisplayName("ไม่กำหนด Domain จะเกิด exception Email Domain")
    public void caseExceptionEmailDomain() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("firstName");
        speaker.setLastName("lastName");
        speaker.setEmail("email");
        try {
            registerBusiness.register(null,speaker);
            fail();
        } catch (DomainEmailInvalidException e) {
        }
    }

    @Test
    @DisplayName("ไม่กำหนดชื่อ จะเกิด exception Speaker doesn't meet our standard rules.")
    public void caseExceptionEmailDomainStandardRules() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("firstName");
        speaker.setLastName("lastName");
        speaker.setEmail("email@test.com");
        try {
            registerBusiness.register(null,speaker);
            fail();
        } catch (SpeakerDoesntMeetRequirementsException e) {
        }
    }

    @Test
    @DisplayName("ไม่กำหนดชื่อ จะเกิด exception Can't save a speaker.")
    public void caseExceptionCanNotSaveASpeaker() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("firstName");
        speaker.setLastName("lastName");
        speaker.setEmail("email@gmail.com");
        try {
            registerBusiness.register(null,speaker);
            fail();
        } catch (SaveSpeakerException e) {
        }
    }
}