package Testing;

import model.DeadLine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeadLineTest {
    private DeadLine deadLine;

    private String valueOf(DeadLine deadLine) {
    return deadLine.getYear() + "/" + deadLine.getMonth() + "/" + deadLine.getDay();
    }

    @BeforeEach void setUp()
    {
        System.out.println("---> setUp");
        deadLine = new DeadLine(0,0,0);
    }

    @AfterEach void tearDown(){
        System.out.println("<--- TearDown");
    }

    @Test void setDeadLineZero()
    {
        deadLine.setDeadLine(0,0,0);
        assertEquals("0/0/0", valueOf(deadLine));
    }

    @Test void setDeadLinetOne()
    {
        deadLine.setDeadLine(0,0,1);
        assertEquals("0/0/1", valueOf(deadLine));
        deadLine.setDeadLine(0,1,0);
        assertEquals("0/1/0", valueOf(deadLine));
        deadLine.setDeadLine(1,0,0);
        assertEquals("1/0/0", valueOf(deadLine));
    }

    @Test void setDeadLineMany()
    {
        deadLine.setDeadLine(2000,10,2);
        assertEquals("2000/10/2", valueOf(deadLine));
        deadLine.setDeadLine(2001,10,3);
        assertEquals("2001/10/3",valueOf(deadLine));
    }

    @Test void setDeadLineBoundary()
    {
        assertThrows(java.lang.IllegalArgumentException.class, () -> {
            deadLine.setDeadLine(0,0,-1);
        });
        assertThrows(java.lang.IllegalArgumentException.class, () -> {
            deadLine.setDeadLine(0,-1,0);
        });
        assertThrows(java.lang.IllegalArgumentException.class, () -> {
            deadLine.setDeadLine(-1,0,0);
        });


        assertThrows(java.lang.IllegalArgumentException.class, () -> {
            deadLine.setDeadLine(0,0,32);
        });
        assertThrows(java.lang.IllegalArgumentException.class, () -> {
            deadLine.setDeadLine(0,13,0);
        });

        assertThrows(java.lang.IllegalArgumentException.class, () -> {
            deadLine.setDeadLine(0,0,200);
        });
        assertThrows(java.lang.IllegalArgumentException.class, () -> {
            deadLine.setDeadLine(0,100,0);
        });
    }






}
