module com.example.batallanavalav2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.batallanavalav2 to javafx.fxml;
    exports com.example.batallanavalav2;
}