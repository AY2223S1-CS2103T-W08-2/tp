package seedu.address.ui;


import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import seedu.address.ui.exceptions.InputOutputException;
import seedu.address.ui.exceptions.UriSyntaxParseException;

/**
 * Container for all the contact addresses of the Contact.
 */
public class ContactBox extends UiPart<Region> {
    private static final String FXML = "ContactBox.fxml";

    @FXML
    private ImageView contactLogo;

    @FXML
    private Hyperlink contactLabel;

    /**
     * Initialises a ContactListBox.
     *
     * @param type The type of contact
     * @param name The name of the contact
     */
    public ContactBox(String type, String name, String link) {
        super(FXML);

        contactLogo.setImage(new Image(
            Objects.requireNonNull(
                this.getClass().getResourceAsStream(
                    "/images/contact/" + type + ".png"
                )
            )
        ));
        
        contactLabel.setText(name);
        contactLabel.setOnAction(e -> {
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI("http://www.google.com"));
                } catch (IOException ex) {
                    throw new InputOutputException();
                } catch (URISyntaxException ex) {
                    throw new UriSyntaxParseException();
                }
            }
        });
    }
}
