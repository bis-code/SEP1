package Testing;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    private Project project;
    private ArrayList<Requirement> requirements;

    @BeforeEach
    void setUp() {
        System.out.println("--> setUp");
        project = new Project("Testing","Testing",2131);
        requirements = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
        System.out.println("<-- tearDown");
    }

    @Test
    void hasUniqueIDMany() {
        for(int i = 0; i < 1000; i++)
        {
            Requirement requirement = new Requirement("Name","desc",new Time(20,0));
            requirements.add(requirement);
        }
        project.setRequirements(requirements);
        boolean result = project.hasUniqueID(requirements.get(1));
        assertEquals(false,result);
    }
}