module com.example.tarea1_ud3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tarea1_ud3 to javafx.fxml;
    exports com.example.tarea1_ud3;
    exports com.example.tarea1_ud3.controladores;
    opens com.example.tarea1_ud3.controladores to javafx.fxml;
    exports com.example.tarea1_ud3.utilities;
    opens com.example.tarea1_ud3.utilities to javafx.fxml;
}