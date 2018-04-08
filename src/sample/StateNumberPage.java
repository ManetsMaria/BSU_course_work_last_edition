package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class StateNumberPage {

    @FXML
    AnchorPane pane1;

    @FXML
    TextField elementsNumber;

    private int numberOfElements;
    private int[] states;

    public void setElementsNumber() throws IOException {
        numberOfElements = Integer.valueOf(elementsNumber.getText());
        System.out.println(numberOfElements);
        dynamic2Init();
    }

    public void setStatesNumber(){
        states = new int[numberOfElements];
        Scene scene = pane1.getScene();
        for (int i = 0; i < numberOfElements; i++){
            TextField textField = (TextField) scene.lookup("#textField" + i);
            states[i] = Integer.valueOf(textField.getText());
        }
        System.out.println(Arrays.toString(states));
        dynamic3Init();
    }

    private void dynamic2Init(){
        pane1.getChildren().clear();
        Label name = new Label("Input states number");
        name.setLayoutX(400);
        name.setLayoutY(200);
        pane1.getChildren().add(name);
        double partY = 400 / numberOfElements;
        for (int i = 0; i < numberOfElements; i++){
            Label label = new Label(String.valueOf(i + 1));
            label.setLayoutY(partY * i);
            label.setLayoutX(30);
            pane1.getChildren().add(label);
            TextField textField = new TextField();
            textField.setLayoutY(partY * i);
            textField.setLayoutX(100);
            textField.setId("textField" + i);
            pane1.getChildren().add(textField);
        }
        Button button = new Button("next");
        button.setLayoutX(550);
        button.setLayoutY(350);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                setStatesNumber();
            }
        });
        pane1.getChildren().add(button);
    }

    private void dynamic3Init(){
        pane1.getChildren().clear();
        
    }
}
