package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import structure.coveringarrays.CoveringArrays;
import structure.coveringarrays.Line;
import structure.graph.Graph;
import structure.graph.State;
import structure.sample.ViewLine;
import test.FullTest;

import java.io.IOException;
import java.util.List;

public class StateNumberPage {

    @FXML
    AnchorPane pane1;

    @FXML
    TextField elementsNumber;

    private int numberOfElements;
    private int[] states;
    private Graph graph = new Graph();

    public void setElementsNumber() throws IOException {
        if (!Validator.checkInput(elementsNumber.getText())){
            show("Error", "incorrect input");
            return;
        }
        numberOfElements = Integer.valueOf(elementsNumber.getText());
        //System.out.println(numberOfElements);
        dynamic2Init();
    }

    public void setStatesNumber(){
        states = new int[numberOfElements];
        Scene scene = pane1.getScene();
        for (int i = 0; i < numberOfElements; i++){
            TextField textField = (TextField) scene.lookup("#textField" + i);
            if (!Validator.checkInput(textField.getText())){
                show("Error", "incorrect input in "+(i+1));
                return;
            }
        }
        for (int i = 0; i < numberOfElements; i++){
            TextField textField = (TextField) scene.lookup("#textField" + i);
            states[i] = Integer.valueOf(textField.getText());
        }
        //System.out.println(Arrays.toString(states));
        graph.init(states);
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
        ListView<String> list = new ListView<>();

        ObservableList<String> items =FXCollections.observableArrayList ();
        for (int i = 0; i < numberOfElements; i++){
            for (int j = 0; j < states[i]; j++){
                items.add("element: "+(i+1)+" state: "+(j+1));
            }
        }
        ObservableList<String> itemsDepends =FXCollections.observableArrayList ();
        list.setItems(items);
        list.setPrefWidth(250);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        list.setOrientation(Orientation.VERTICAL);
        list.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> ov, String old_val,
                 String new_val) -> {
                    itemsDepends.clear();
                    String[] arr = new_val.split(" ");
                    int element = Integer.valueOf(arr[1]) - 1;
                    for (int i = element + 1; i < numberOfElements; i++){
                        for (int j = 0; j < states[i]; j++){
                            itemsDepends.add("element: "+(i+1)+" state: "+(j+1));
                        }
                    }
                });
        ListView <String> depends = new ListView<>();
        depends.setLayoutX(350);
        depends.setItems(itemsDepends);
        depends.setPrefWidth(250);
        depends.setPrefHeight(350);
        list.setPrefHeight(350);
        depends.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Button button = new Button("finish");
        button.setLayoutX(550);
        button.setLayoutY(370);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                graph.finish();
                CoveringArrays coveringArrays = FullTest.getTest(graph);
                List<Line> copyLine = coveringArrays.getCopyLines();
                Controller.coveringArrayData.clear();
                for (int i = 0; i < copyLine.size(); i++){
                    ViewLine viewLine = new ViewLine(i+1, copyLine.get(i));
                    Controller.coveringArrayData.add(viewLine);
                }
                Stage stage = (Stage) pane1.getScene().getWindow();
                stage.close();
            }
        });
        Button save = new Button("Save states depending");
        save.setLayoutX(255);
        save.setPrefWidth(90);
        save.setLayoutY(170);
        save.setPrefHeight(60);
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                String[] arr1 = list.getSelectionModel().getSelectedItems().get(0).split(" ");
                int element1 = Integer.valueOf(arr1[1]) - 1;
                int state1 = Integer.valueOf(arr1[3]) - 1;
                State stateGraph1 = new State(element1, state1);
                ObservableList <String> list2 = depends.getSelectionModel().getSelectedItems();
                for (String s: list2){
                    String[] arr2 = s.split(" ");
                    int element2 = Integer.valueOf(arr2[1]) - 1;
                    int state2 = Integer.valueOf(arr2[3]) - 1;
                    State stateGraph2 = new State(element2, state2);
                    graph.add(stateGraph1, stateGraph2);
                }
            }
        });
        pane1.getChildren().add(list);
        pane1.getChildren().add(button);
        pane1.getChildren().add(depends);
        pane1.getChildren().add(save);
    }

    private void show(String header, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("data information");
        alert.setContentText(message);
        alert.setHeaderText(header);
        alert.setResizable(true);
        alert.getDialogPane().setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        alert.show();
    }
}
