package aydin.firebasedemo;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.FirebaseAuthException;

public class RegisterController {
    @FXML private TextField emailField;
    @FXML private TextField passwordField;
    @FXML private TextField phoneField;

    @FXML
    private void onRegisterAction() {
        try {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(emailField.getText())
                    .setPassword(passwordField.getText())
                    .setEmailVerified(false)
                    .setDisplayName(emailField.getText())
                    .setDisabled(false);

            String phoneValue = phoneField.getText().trim();
            if (!phoneValue.isEmpty() && phoneValue.matches("\\+\\d{10,15}")) {
                request.setPhoneNumber(phoneValue);
            }
            // Else: you can show a warning dialog if you want, or proceed without adding a phone

            UserRecord userRecord = DemoApp.fauth.createUser(request);
            System.out.println("User registered: " + userRecord.getUid());
            DemoApp.setRoot("primary");
        } catch (FirebaseAuthException | IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void onBackAction() throws IOException {
        DemoApp.setRoot("welcome");
    }
}
