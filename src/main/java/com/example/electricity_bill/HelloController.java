package com.example.electricity_bill;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    Stage stage;

    public void onsignup(ActionEvent actionEvent) {
        FXMLLoader loader1 =new FXMLLoader(getClass().getResource("registration_page.fxml"));
        Parent root2= null;
        try {
            root2 = loader1.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene1 = new Scene(root2);
        stage=HelloApplication.s;
        stage.setScene(scene1);
        stage.show();
    }
}