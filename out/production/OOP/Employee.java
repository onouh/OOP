
package com.example.app_gui;

import javafx.scene.layout.VBox;

public interface Employee <T> {
        public void create(String jack , VBox john);
        public String read(T o);
        public void update(T o , String newValue , VBox theInputOfTheNewValue,VBox theInputOfTheCategory);
        public void delete(T o);
        public void show();
}
