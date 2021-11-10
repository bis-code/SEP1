package view;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import model.ProjectModel;

public class MainViewController {
    private ViewHandler viewHandler;
    private Region root;
    private ProjectModel model;

    public MainViewController()
    {

    }

    public void init(ViewHandler viewHandler, ProjectModel model, Region root)
    {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;

        // no reset() method - there is no textfield/field.
    }

    @FXML
    private void onStartButton()
    {
        viewHandler.openView("ProjectList");
    }



}
