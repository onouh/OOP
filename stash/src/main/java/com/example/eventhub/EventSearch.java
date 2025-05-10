
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EventSearch extends Application {
    
    private TextField textBox;
    private Event evnt;

    @Override
    public void start(Stage primaryStage) {
        textBox = new TextField();

        // Add a listener to the text property of the text box
        textBox.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                for (Event event : Database.events) {
                    if (event.getName().matches(newValue)) {
                        evnt = event;
                        System.out.println("Event found: " + event.toString());
                        return;
                    }
                }
                System.out.println("Event not found.");
            }
        });


        StackPane root = new StackPane(textBox);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Text Box with Listener");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    // public boolean match(String input, String target) {
    //     if (input == null || target == null || target.isEmpty() || input.length() < target.length()) {
    //         return false;
    //     }

    //     for (int i = 0; i <= input.length() - target.length(); i++) {
    //         boolean foundMatch = true;
    //         for (int j = 0; j < target.length(); j++) {
    //             if (input.charAt(i + j) != target.charAt(j)) {
    //                 foundMatch = false;
    //                 break;
    //             }
    //         }
    //         if (foundMatch) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}
