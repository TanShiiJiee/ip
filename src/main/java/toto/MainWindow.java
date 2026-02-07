package toto;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Toto toto;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaPerson.png"));
    private Image totoImage = new Image(this.getClass().getResourceAsStream("/images/DaToto.png"));

    /**
     * Handles initialization.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());

    }

    /** Injects the Toto instance */
    public void setToto(Toto t) {
        toto = t;
        String totoStart = toto.getStart();
        dialogContainer.getChildren().addAll(DialogBox.getDukeDialog(totoStart, totoImage));
    }

    /**
     * Creates two dialog boxes, one for user input and the other containing Toto's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = toto.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, totoImage)
        );
        userInput.clear();
    }


}
