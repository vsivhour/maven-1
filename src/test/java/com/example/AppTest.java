package com.example;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple Desktop App.
 */
public class AppTest 
{
    /**
     * Verify the app can be instantiated
     */
    @Test
    public void shouldCreateAppInstance()
    {
        App app = new App();
        assertNotNull(app);
    }
    
    /**
     * Basic test
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue(true);
    }
}
