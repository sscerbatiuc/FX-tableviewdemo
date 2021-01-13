package sample.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class EmployeeModelTemporary {

    private Double age;
    private DoubleProperty ageProperty = new SimpleDoubleProperty();

    public DoubleProperty getAgeProperty() {
        return ageProperty;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;

        // graphics, object
    }

    public void setAgeProperty(Double value) {
        this.ageProperty.set(value); // NULL
    }

    public double getAgePropertyValue(){
        return this.ageProperty.get();
    }
}

class Controller {
    public static void main(String[] args) {
        EmployeeModelTemporary object = new EmployeeModelTemporary();
        object.setAge(100.0);
        object.setAge(120.0);
        object.setAge(130.0);
        object.setAge(140.0);
        object.setAge(150.0);

        object.getAgeProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue observable, Number oldValue, Number newValue) {
                System.out.println("Value changed: " + oldValue + " -> " + newValue);
                // GUI

                // DB
            }
        });
        object.setAgeProperty(100.0);
        object.setAgeProperty(200.0);
        object.setAgeProperty(250.0);
        object.setAgeProperty(201.0);
        object.setAgeProperty(202.0);

    }
}
