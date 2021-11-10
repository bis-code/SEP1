package Testing;

import model.StartDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StartDateTest {
    private StartDate startDate;

    public String valueOf(StartDate startDate)
    {
        return startDate.getYear() + "/" + startDate.getMonth() + "/" + startDate.getDay();
    }

    @BeforeEach void setUp()
    {
        System.out.println("---> setUp");
        startDate = new StartDate(0,0,0);
    }

    @AfterEach void tearDown()
    {
        System.out.println("---> tearDown");
    }

    @Test
    void setStartDateZero()
    {
        startDate.setStartDate(0,0,0);
        assertEquals("0/0/0", valueOf(startDate));
    }

    @Test void setStartDateOne()
    {
        startDate.setStartDate(0,0,1);
        assertEquals("0/0/1", valueOf(startDate));
        startDate.setStartDate(0,1,0);
        assertEquals("0/1/0", valueOf(startDate));
        startDate.setStartDate(1,0,0);
        assertEquals("1/0/0", valueOf(startDate));
    }

    @Test void setStartDateMany()
    {
        startDate.setStartDate(2000,10,2);
        assertEquals("2000/10/2", valueOf(startDate));
        startDate.setStartDate(2001,10,3);
        assertEquals("2001/10/3",valueOf(startDate));
    }

    @Test void setStartDateBoundary()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            startDate.setStartDate(0,0,-1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            startDate.setStartDate(0,-1,0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            startDate.setStartDate(-1,0,0);
        });


        assertThrows(IllegalArgumentException.class, () -> {
            startDate.setStartDate(0,0,32);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            startDate.setStartDate(0,13,0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            startDate.setStartDate(0,0,200);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            startDate.setStartDate(0,100,0);
        });
    }


}
