package JunitTests;

import account.AccountManager;
import authenticator.LoginAuthenticator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginAuthenticatorTest {

    String username = "username";
    String password = "password";
    String email = "test@gmail.com";

    @BeforeEach
    void setUp() {
        AccountManager.createAccount(username, password, email);
    }

    @AfterEach
    void tearDown() {
        AccountManager.deleteAccount("username");
    }

    @Test
    void authenticate() {
        boolean answer = true;

        boolean testResult1 = LoginAuthenticator.authenticate(this.username, this.password);
        boolean testResult2 = LoginAuthenticator.authenticate("username", "password");
        boolean testResult3 = LoginAuthenticator.authenticate("username", "pass");
        boolean testResult4 = LoginAuthenticator.authenticate("user", "password");

        assertEquals(answer,testResult1);
        assertEquals(answer,testResult2);
        assertEquals(!answer,testResult3);
        assertEquals(!answer,testResult4);
    }
}