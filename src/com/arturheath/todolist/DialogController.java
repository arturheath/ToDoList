package com.arturheath.todolist;

import com.arturheath.todolist.datamodel.TodoData;
import com.arturheath.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {

    @FXML
    public TextField shortDescriptionField;
    @FXML
    public TextArea detailsArea;
    @FXML
    public DatePicker deadlinePicker;

    public TodoItem addNewItemInDialog(){

        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadLineValue = deadlinePicker.getValue();

        TodoItem newItem = new TodoItem(shortDescription, details, deadLineValue);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }

    public void editExistingItemInDialog(TodoItem item){

        item.setShortDescription(shortDescriptionField.getText().trim());
        item.setDetails(detailsArea.getText().trim());
        item.setDeadLine(deadlinePicker.getValue());
    }
}
