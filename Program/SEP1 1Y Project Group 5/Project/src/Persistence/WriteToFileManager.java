package Persistence;
import model.ProjectList;

import java.io.*;

public class WriteToFileManager implements WriteToFile{

    private File projects;


    public WriteToFileManager()
    {
        projects = new File("C:\\Program Files (x86)\\Items\\Dokumentai\\VIA reikalai\\Mathematics\\I semestras\\SEP1 1Y Project\\Project\\src\\Persistence\\projects.bin");
    }
    @Override
    public void writeProject(ProjectList projectList) {
        ObjectOutputStream out = null;

        try {
            FileOutputStream fos = new FileOutputStream(projects);
            out = new ObjectOutputStream(fos);
            out.writeObject(projectList);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public ProjectList readProject() {
        ProjectList projectList = new ProjectList();
        ObjectInputStream in;

        try {
            FileInputStream fis = new FileInputStream(projects);
            in = new ObjectInputStream(fis);
            projectList = (ProjectList) in.readObject();
            in.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return projectList;
    }
}
