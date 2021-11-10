package Persistence;

import model.ProjectList;
import model.*;

public interface WriteToFile {

    //////write/read project
    void writeProject(ProjectList projectList);
    ProjectList readProject();

}
