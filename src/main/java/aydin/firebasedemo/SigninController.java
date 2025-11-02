package aydin.firebasedemo;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;

public class SigninController {
    @FXML private TextField emailField;
    @FXML private TextField passwordField;

    @FXML
    private void onSignInAction() {
        // Firebase client SDK does not support email+password login for server-side Java.
        // Use custom logic, validate via Firestore, or call a backend REST API.
        // For demo, move to data access view if fields not empty.
        if (!emailField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
            System.out.println("Sign In: " + emailField.getText());
            try { DemoApp.setRoot("primary"); } catch (IOException e) { e.printStackTrace(); }
        }
    }

    @FXML
    private void onBackAction() throws IOException {
        DemoApp.setRoot("welcome");
    }
}
