package com.jtracking;

import java.lang.management.ManagementFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.jvm.tracking.enums.TrackingInterval;
import com.jvm.tracking.exception.TrackingInitializeException;
import com.jvm.tracking.impl.MemoryTrackingImpl;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws TrackingInitializeException 
     */
    public void testApp() throws TrackingInitializeException
    {
        MemoryTrackingImpl memoryTrackingImpl = new MemoryTrackingImpl(ManagementFactory.getMemoryMXBean(), TrackingInterval.EVERY_ONE_MINUTE);
        memoryTrackingImpl.start();
    }
}
