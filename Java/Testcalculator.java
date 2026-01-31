package demos;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Testcalculator {
    private Calculator calculator;
    @BeforeEach
    public void setup(){
        calculator=new Calculator();
    }
    @Test
    public void testAdd(){
        Assert.assertEquals(4,calculator.add(2,2));

    }

    
}

