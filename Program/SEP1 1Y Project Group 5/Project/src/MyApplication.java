import javafx.application.Application;
import javafx.stage.Stage;
import model.*;
import view.ViewHandler;

public class MyApplication extends Application
{
    public void start(Stage primaryStage)
    {
        ProjectModel model = new ProjectModelManager();
        ViewHandler view = new ViewHandler(model);
        view.start(primaryStage);
    }
}
