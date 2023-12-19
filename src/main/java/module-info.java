module com.example.comp336_proj2 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.comp336_proj2 to javafx.fxml;
    exports com.example.comp336_proj2;
}