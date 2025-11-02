package aydin.firebasedemo;

import javafx.fxml.FXML;
import java.io.IOException;

public class WelcomeController {
    @FXML
    private void onRegisterClicked() throws IOException {
        DemoApp.setRoot("register");
    }

    @FXML
    private void onSignInClicked() throws IOException {
        DemoApp.setRoot("signin");
    }
}
