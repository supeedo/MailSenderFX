package sample;

import javafx.scene.control.*;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;

public class Controller {
    private final FileChooser chooser = new FileChooser();
    public TextField from;
    public TextField subject;
    public TextField smtpServer;
    public TextField userName;
    public PasswordField smtpPassword;
    public TableColumn<MailStatus, String> mailColumn;
    public TableColumn<MailStatus, Boolean> sentColumn;
    public TableView<MailStatus> mailView;
    public HTMLEditor htmlEditor;
    public ComboBox<String> mimeType;

    public void openFile() {
    }

    public void sendMassive(){}

}
