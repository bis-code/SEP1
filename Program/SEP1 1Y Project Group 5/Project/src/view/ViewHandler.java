package view;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.*;

public class ViewHandler {
    private Scene currentScene;
    private Stage primaryStage;
    private ProjectModel model;
    private AddProjectViewController addProjectViewController;
    private AddRequirementViewController addRequirementViewController;
    private AddTaskViewController addTaskViewController;
    private CustomizeProjectViewController customizeProjectViewController;
    private CustomizeRequirementsViewController customizeRequirementsViewController;
    private CustomizeTaskViewController customizeTaskViewController;
    private DetailsProjectViewController detailsProjectViewController;
    private DetailsRequirementViewController detailsRequirementViewController;
    private MainViewController mainViewController;
    private ProjectListViewController projectListViewController;
    private TaskDescriptionViewController taskDescriptionViewController;
    private RequirementDescriptionViewController requirementDescriptionViewController;
    private AddResponsibleTeamMemberViewController responsibleTeamMemberViewController;
    private TaskTimeSpentViewController taskTimeSpentViewController;
    private AddMembersToTaskViewController addMembersToTaskViewController;
    private TaskMembersViewController taskMembersViewController;
    private CustomizeMemberViewController customizeMemberViewController;
    private ViewState state;
    public ViewHandler(ProjectModel model) {
        this.model = model;
        currentScene = new Scene(new Region());
        this.state = new ViewState();
    }
    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        openView("Main");
    }
    public void openView(String id)
    {
        Region root = null;
        switch (id){
            case "Main" :
                root = LoadMainView("MainView.fxml");
                break;
            case "AddProject" :
                root = LoadAddProjectView("AddProjectView.fxml",state);
                break;
            case "AddRequirement" :
                root = LoadAddRequirementView("AddRequirementView.fxml",state);
                break;
            case "AddTask" :
                root = LoadAddTaskView("AddTaskView.fxml",state);
                break;
            case "CustomizeProject" :
                root = LoadCustomizeProjectView("CustomizeProjectView.fxml",state);
                break;
            case "CustomizeTask" :
                root = LoadCustomizeTaskView("CustomizeTaskView.fxml",state);
                break;
            case "CustomizeRequirements" :
                root = LoadCustomizeRequiremetsView("CustomizeRequirementsView.fxml",state);
                break;
            case "DetailsProject" :
                root = LoadDetailsProjectView("DetailsProjectView.fxml",state);
                break;
            case "DetailsRequirement" :
                root = LoadDetailsRequirementView("DetailsRequirementView.fxml",state);
                break;
            case "ProjectList" :
                root = LoadProjectListView("ProjectListView.fxml",state);
                break;
            case "TaskDescription" :
                root = LoadTaskDescriptionView("TaskDescriptionView.fxml",state);
                break;
            case "AddResponsibleTM" :
                root = LoadAddResponsibleTeamMemberView("AddResponsibleTeamMemberView.fxml",state);
                break;
            case "RequirementDescription" :
                root = LoadRequirementDescriptionView("RequirementDescriptionView.fxml", state);
                break;
            case "TaskMembers" :
                root = LoadTaskMembersView("TaskMembersView.fxml",state);
                break;
            case "CustomizeMemberTask" :
                root = LoadCustomizeMemberView("CustomizeMember.fxml",state);
                break;
            case "AddMembersToTask" :
                root = LoadAddMembersToTaskView("AddMembersToTask.fxml",state);
                break;
            case "TaskTimeSpent" :
                root = LoadTaskTimeSpentView("TaskTimeSpentView.fxml", state);
                break;
        }
        currentScene.setRoot(root);
        String title = "";
        if(root.getUserData() != null)
            title += root.getUserData();
        primaryStage.setTitle(title);
        primaryStage.setScene(currentScene);
        primaryStage.setHeight(root.getPrefHeight());
        primaryStage.setWidth(root.getPrefWidth());
        primaryStage.show();
    }
    public void closeView(){
        primaryStage.close();
    }
    public Region LoadAddProjectView(String fxmlFile,ViewState state)
    {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            root = loader.load();
            addProjectViewController = loader.getController();
            addProjectViewController.init(this,model,root,state);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return root;
    }
    public Region LoadAddRequirementView(String fxmlFile,ViewState state)
    {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            root = loader.load();
            addRequirementViewController = loader.getController();
            addRequirementViewController.init(this,model,root,state);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return root;
    }
    public Region LoadAddTaskView(String fxmlFile,ViewState state)
    {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            root = loader.load();
            addTaskViewController = loader.getController();
            addTaskViewController.init(this,model,root,state);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return root;
    }
    public Region LoadCustomizeProjectView(String fxmlFile,ViewState state)
    {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            root = loader.load();
            customizeProjectViewController = loader.getController();
            customizeProjectViewController.init(this,model,root,state);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return root;
    }
    public Region LoadCustomizeRequiremetsView(String fxmlFile,ViewState state)
    {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            root = loader.load();
            customizeRequirementsViewController = loader.getController();
            customizeRequirementsViewController.init(this,model,root,state);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return root;
    }
    public Region LoadCustomizeTaskView(String fxmlFile,ViewState state)
    {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            root = loader.load();
            customizeTaskViewController = loader.getController();
            customizeTaskViewController.init(this,model,root,state);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return root;
    }

    public Region LoadCustomizeMemberView(String fxmlFile, ViewState state)
    {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            root = loader.load();
            customizeMemberViewController = loader.getController();
            customizeMemberViewController.init(this,model,root,state);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return root;
    }
    public Region LoadDetailsProjectView(String fxmlFile,ViewState state)
    {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            root = loader.load();
            detailsProjectViewController = loader.getController();
            detailsProjectViewController.init(this,model,root,state);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return root;
    }
    public Region LoadDetailsRequirementView(String fxmlFile,ViewState state)
    {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            root = loader.load();
            detailsRequirementViewController = loader.getController();
            detailsRequirementViewController.init(this,model,root,state);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return root;
    }
    public Region LoadMainView(String fxmlFile)
    {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            root = loader.load();
            mainViewController = loader.getController();
            mainViewController.init(this,model,root);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return root;
    }
    public Region LoadProjectListView(String fxmlFile,ViewState state)
    {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            root = loader.load();
            projectListViewController = loader.getController();
            projectListViewController.init(this,model,root,state);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return root;
    }
    public Region LoadTaskDescriptionView(String fxmlFile,ViewState state)
    {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            root = loader.load();
            taskDescriptionViewController = loader.getController();
            taskDescriptionViewController.init(this,model,root,state);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return root;
    }
    public Region LoadRequirementDescriptionView(String fxmlFile, ViewState state)
    {
        Region root = null;
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            root = loader.load();
            requirementDescriptionViewController = loader.getController();
            requirementDescriptionViewController.init(this,model,root,state);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return root;
    }

    public Region LoadAddResponsibleTeamMemberView(String fxmlFile, ViewState state)
    {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            root = loader.load();
            responsibleTeamMemberViewController = loader.getController();
            responsibleTeamMemberViewController.init(this,model,root,state);

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return root;
    }

    public Region LoadTaskTimeSpentView(String fxmlFile, ViewState state)
    {
        Region root = null;
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            root = loader.load();
            taskTimeSpentViewController = loader.getController();
            taskTimeSpentViewController.init(this, model, root, state);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return root;
    }

    public Region LoadAddMembersToTaskView(String fxmlFile, ViewState state)
    {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            root = loader.load();
            addMembersToTaskViewController = loader.getController();
            addMembersToTaskViewController.init(this,model,root,state);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return root;
    }

    public Region LoadTaskMembersView(String fxmlFile, ViewState state)
    {
        Region root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            root = loader.load();
            taskMembersViewController = loader.getController();
            taskMembersViewController.init(this,model,root,state);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return root;
    }
}