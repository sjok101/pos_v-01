
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class EmployeeManagementController implements Initializable {

    public Button add;
    public Button edit;
    public Button back;



    public TableView<employee> e_table;


    public TableColumn<employee,String> e_id;
    public TableColumn<employee,String> e_last;
    public TableColumn<employee,String> e_first;
    public TableColumn<employee,String>e_position;
    public TableColumn<employee,String> e_phone;
    public TableColumn<employee,String> e_email;
    public TableColumn<employee,String> e_address;

    public TextField id_text;
    public TextField last_text;
    public TextField first_text;
    public TextField position_text;
    public TextField phone_text;
    public TextField email_text;
    public TextField address_text;


    List<employee> list = null;

    @Override
    public void initialize(URL location, ResourceBundle resource){
        
        
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = objectMapper.readValue(new File("saves/EmployeeList.json"), new TypeReference<List<employee>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
       

                
        final ObservableList<employee> data = FXCollections.observableArrayList(list);

        e_id.setCellValueFactory(new PropertyValueFactory<employee,String>("id"));
        e_last.setCellValueFactory(new PropertyValueFactory<employee,String>("last"));
        e_first.setCellValueFactory(new PropertyValueFactory<employee,String>("first"));
        e_position.setCellValueFactory(new PropertyValueFactory<employee,String>("position"));
        e_phone.setCellValueFactory(new PropertyValueFactory<employee,String>("phone"));
        e_email.setCellValueFactory(new PropertyValueFactory<employee,String>("email"));
        e_address.setCellValueFactory(new PropertyValueFactory<employee,String>("address"));

        e_table.setItems(data);


    e_table.setOnMouseClicked(event ->{
        employee selected = (employee) e_table.getSelectionModel().getSelectedItem();
        if(selected!=null) {
            id_text.setText(selected.getId());
            last_text.setText(selected.getLast());
            first_text.setText(selected.getFirst());
            position_text.setText(selected.getPosition());
            phone_text.setText(selected.getPhone());
            email_text.setText(selected.getEmail());
            address_text.setText(selected.getAddress());
        }
    });


    }
    @FXML
    private void deleteRow() throws StreamWriteException, DatabindException, IOException{
        e_table.getItems().removeAll(e_table.getSelectionModel().getSelectedItem());
        employee remove = (employee) e_table.getSelectionModel().getSelectedItem();
        list.remove(remove);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("saves/EmployeeList.json"), list);  

    }
    @FXML
    public void addEmployee() throws StreamWriteException, DatabindException, IOException {
        employee add = new employee( id_text.getText(),last_text.getText(), first_text.getText(),position_text.getText(),phone_text.getText(),email_text.getText(),address_text.getText());
        e_table.getItems().add(add);
        list.add(add);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("saves/EmployeeList.json"), list);
        e_table.refresh();



    }
    @FXML
    public void editEmployee() throws StreamWriteException, DatabindException, IOException {
        employee selected = (employee) e_table.getSelectionModel().getSelectedItem();
        if(selected!=null) {
            if (selected.getId() != id_text.getText()) {
                selected.setId(id_text.getText());
            }
            if (selected.getLast() != last_text.getText()) {
                selected.setLast(last_text.getText());
            }
            if (selected.getFirst() != first_text.getText()) {
                selected.setFirst(first_text.getText());
            }
            if (selected.getPosition() != position_text.getText()) {
                selected.setPosition(position_text.getText());
            }
            if (selected.getPhone() != phone_text.getText()) {
                selected.setPhone(phone_text.getText());
            }
            if (selected.getEmail() != email_text.getText()) {
                selected.setEmail(email_text.getText());
            }
            if (selected.getAddress() != address_text.getText()) {
                selected.setAddress(address_text.getText());
            }
        }
        for(int i = 0; i < list.size();i++)
        {
            if(list.get(i)==selected)
            {
                if (selected.getId() != id_text.getText()) {
                    list.get(i).setId(id_text.getText());
                }
                if (selected.getLast() != last_text.getText()) {
                    list.get(i).setLast(last_text.getText());
                }
                if (selected.getFirst() != first_text.getText()) {
                    list.get(i).setFirst(first_text.getText());
                }
                if (selected.getPosition() != position_text.getText()) {
                    list.get(i).setPosition(position_text.getText());
                }
                if (selected.getPhone() != phone_text.getText()) {
                    list.get(i).setPhone(phone_text.getText());
                }
                if (selected.getEmail() != email_text.getText()) {
                    list.get(i).setEmail(email_text.getText());
                }
                if (selected.getAddress() != address_text.getText()) {
                    list.get(i).setAddress(address_text.getText());
                }
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("saves/EmployeeList.json"), list);
        
        e_table.refresh();

    }
    @FXML
    public void gotoOverview() throws Exception{


        try {
            PosMenu p = new PosMenu();
            p.changeScene("OverviewScene.fxml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
