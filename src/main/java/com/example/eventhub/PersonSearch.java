
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PersonSearch extends Application {
    private TextField textBox;
    private Person person;

    @Override
    public void start(Stage primaryStage) {
        textBox = new TextField();

        // Add a listener to the text property of the text box
        textBox.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                for (Person p : Database.people) {
                    if (p.getUsername().matches(newValue)) {
                        person = p;
                        System.out.println("Person found: " + person.toString());
                        return;
                    }
                }
                System.out.println("Person not found.");
            }
        });

        StackPane root = new StackPane(textBox);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Text Box with Listener");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
