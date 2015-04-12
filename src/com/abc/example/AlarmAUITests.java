package com.abc.example;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlarmAUITests extends TestCase{
    private String DESKCLOCK_ACTIVITY = "com.android.deskclock/com.android.deskclock.DeskClock";
    
    public AlarmAUITests() throws Exception {
        super();
    }

    @Before
    @Override
    public void setUp() throws Exception {
       super.setUp();
    }

    @After
    @Override
    public void tearDown() throws Exception {
    	super.tearDown();
    }
    
    @Test
    public void test_create_alarm() throws Exception {
    }
    
}
