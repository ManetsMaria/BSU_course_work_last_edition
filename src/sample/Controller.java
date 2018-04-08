package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import structure.sample.ViewLine;

import java.io.IOException;

public class Controller {
    public static ObservableList<ViewLine> coveringArrayData = FXCollections.observableArrayList();

    @FXML
    private TableView<ViewLine> tableLines;

    @FXML
    private TableColumn<ViewLine, Integer> idColumn;

    @FXML
    private TableColumn<ViewLine, String> lineColumn;

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<ViewLine, Integer>("id"));
        lineColumn.setCellValueFactory(new PropertyValueFactory<ViewLine, String>("line"));
        tableLines.setItems(coveringArrayData);
    }

    @FXML
    public void showInputDialog() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StateNumberPage.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Другая форма");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
