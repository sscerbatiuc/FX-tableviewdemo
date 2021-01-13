package sample.model;

import javafx.beans.property.*;

import java.time.LocalDate;

public class EmployeeModel {

    private IntegerProperty id;
    private StringProperty name;
    private ObjectProperty<LocalDate> birthDate;

    public EmployeeModel(Integer id, String name, LocalDate age) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.birthDate = new SimpleObjectProperty<>(age);
    }

    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public LocalDate setBirthdate() {
        return birthDate.get();
    }

    public void setBirthDate(LocalDate age) {
        this.birthDate.set(age);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public ObjectProperty<LocalDate> birthDateProperty() {
        return birthDate;
    }
}
