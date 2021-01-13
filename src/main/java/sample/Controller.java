package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.EmployeeModel;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Button test;

    @FXML
    private Button addBtn;

    @FXML
    private Button editBtn;

    @FXML
    private Button deleteBtn;


    @FXML
    private TableView<EmployeeModel> employeeTable;

    @FXML
    private TableColumn<EmployeeModel, Integer> colId;

    @FXML
    private TableColumn<EmployeeModel, String> colName;

    @FXML
    private TableColumn<EmployeeModel, LocalDate> colAge;

    private ObservableList<EmployeeModel> employeeList = FXCollections.observableArrayList(
            (EmployeeModel model) -> new Observable[]{ model.idProperty(), model.nameProperty(), model.birthDateProperty() }
    );


    @FXML
    void onAddEmployeeBtnAction(ActionEvent event) {
        // SQL insert
        employeeList.add(new EmployeeModel(1, "Name", LocalDate.now()));
    }

    @FXML
    void onDeleteEmployeeBtnAction(ActionEvent event) {
        employeeList.remove(0);
        // SQL Delete
    }

    @FXML
    void onEditEmployeeBtnAction(ActionEvent event) {
        int selectedIndex = this.employeeTable.getSelectionModel().getSelectedIndex();
        employeeList.get(selectedIndex).birthDateProperty().set(LocalDate.now());
        // SQL update
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name")); // coincide cu denumirea atributului name din EModel
        colAge.setCellValueFactory(new PropertyValueFactory<>("birthdate"));

        employeeTable.setItems(employeeList);
    }
}

