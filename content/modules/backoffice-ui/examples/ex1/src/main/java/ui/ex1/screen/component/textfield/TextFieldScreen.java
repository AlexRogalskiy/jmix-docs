package ui.ex1.screen.component.textfield;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.Label;
import io.jmix.ui.component.TextField;
import io.jmix.ui.component.TextInputField;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("sample_TextFieldScreen")
@UiDescriptor("textField-screen.xml")
public class TextFieldScreen extends Screen {
    @Autowired
    private TextField shortTextField;
    @Autowired
    private Label shortTextLabel;
    @Autowired
    private TextField textField;
    @Autowired
    private Notifications notifications;

    @Subscribe
    protected void onInit(InitEvent event) {
        // tag::conversion-text-field[]
        textField.setConversionErrorMessage("This field can work only with Integers");
        // end::conversion-text-field[]
    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent beforeShowEvent) {
        // tag::text-field-change-listener[]
        shortTextField.addTextChangeListener(event -> {
            int length = event.getText().length();
            shortTextLabel.setValue(length + " of " + shortTextField.getMaxLength());
        });
        shortTextField.setTextChangeEventMode(TextInputField.TextChangeEventMode.LAZY);
        // end::text-field-change-listener[]

        // tag::text-field-press-listener[]
        textField.addEnterPressListener(enterPressEvent ->
                notifications.create()
                        .withCaption("Enter pressed")
                        .show());
        // end::text-field-press-listener[]
    }
}