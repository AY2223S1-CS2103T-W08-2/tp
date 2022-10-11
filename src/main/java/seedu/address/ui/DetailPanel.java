package seedu.address.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import seedu.address.model.person.Person;
import seedu.address.model.person.contact.Contact;

/**
 * A ui for the status bar that is displayed at the header of the application.
 */
public class DetailPanel extends MainPanel {

    private static final String FXML = "DetailPanel.fxml";

    @FXML
    private Circle profileImageContainer;

    @FXML
    private ImageView profileImageView;

    @FXML
    private Label nameLabel;

    @FXML
    private Label roleLabel;

    @FXML
    private Label timezoneLabel;

    @FXML
    private HBox contactBoxContainer;

    /**
     * Initialises the DetailPanel.
     *
     * @param person The person whose contact details are to be displayed.
     */
    public DetailPanel(Person person) {
        super(FXML);

        nameLabel.setText(person.getName().toString());

        Image placeholder = new Image(
            Objects.requireNonNull(
                this.getClass().getResourceAsStream("/images/user_placeholder.png")
            )
        );

        profileImageContainer.setFill(new ImagePattern(placeholder));
        person.getTag().ifPresent(tag -> roleLabel.setText(tag.tagName));
        timezoneLabel.setText("Local Time: 10.00 am (UTC+8)");

        List<ContactBox> contactBoxList = new ArrayList<>();

        for (Contact contact : person.getContactMap().values()) {
            contactBoxList.add(
                new ContactBox(
                    contact.getContactTypeName(),
                    contact.getValue(),
                    contact.getLink()
                )
            );
        }

        for (ContactBox contact : contactBoxList) {
            contactBoxContainer.getChildren().add(contact.getRoot());
        }
    }

    @Override
    public MainPanelName getPanelName() {
        return MainPanelName.Detail;
    }
}
