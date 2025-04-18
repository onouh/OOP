module GUI.UX {
    requires javafx.controls;
    requires javafx.fxml;

    opens asu.github to javafx.fxml;
    exports asu.github;
}
