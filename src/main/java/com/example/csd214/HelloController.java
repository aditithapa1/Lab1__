package com.example.csd214;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.sql.*;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;
public class HelloController implements Initializable {
    @FXML
    private TableView<classlist> classlist;
    @FXML
    private TableColumn<classlist,Integer > Studentid;
    @FXML
    private TableColumn<classlist, String> Studentname;
    @FXML
    private TableColumn<classlist,String> Studentphonenumber;
    @FXML
    private TableColumn<classlist,Integer> Teachername;
    ObservableList<classlist> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Studentid.setCellValueFactory(new
                PropertyValueFactory<classlist,Integer>("Studentid"));
        Studentname.setCellValueFactory(new
                PropertyValueFactory<classlist,String>("Studentname"));
        Studentphonenumber.setCellValueFactory(new
                PropertyValueFactory<classlist,String>("Studentphonenumber"));
        Teachername.setCellValueFactory(new
                PropertyValueFactory<classlist,Integer>("Teachername"));
        classlist.setItems(list);
    }
    @FXML
    protected void onHelloButtonClick() {
        populateTable();
    }
    public void populateTable() {
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab1";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM classlist";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int Studentid = resultSet.getInt("Studentid");
                String Studentname = resultSet.getString("Studentname");
                int Studentphonenumber = resultSet.getInt("Studentphonenumber");
                String Teachername = resultSet.getString("Teachername");
                classlist.getItems().add(new classlist(Studentid, Studentname,Studentphonenumber,
                        Teachername));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}