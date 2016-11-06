package com.jvm.tracking.factory;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

import com.jvm.tracking.BaseTracking;
import com.jvm.tracking.enums.TrackingInterval;
import com.jvm.tracking.enums.TrackingType;
import com.jvm.tracking.exception.TrackingInitializeException;
import com.jvm.tracking.impl.CPUTrackingImpl;
import com.jvm.tracking.impl.MemoryTrackingImpl;

public class TrackingFactory {
	
	public static synchronized BaseTracking newTracking(TrackingType trackingType) throws TrackingInitializeException{
		return newTracking(trackingType, TrackingInterval.EVERY_TEN_MINUTE);
	}
	
	public static synchronized BaseTracking newTracking(TrackingType trackingType, TrackingInterval trackingInterval) throws TrackingInitializeException{
		BaseTracking trackingImplementation = null;
		
		switch (trackingType) {
		case CPU:
			trackingImplementation = new CPUTrackingImpl();
			break;
		case MEMORY:
			trackingImplementation = new MemoryTrackingImpl(ManagementFactory.getMemoryMXBean(), trackingInterval);
			break;
		case THREAD:
			
			break;
		default:
			throw new TrackingInitializeException("Unknow Tracking Type!");
		}
		
		return trackingImplementation;
	}
	
	private ThreadMXBean createThredTracking(){
		return null;
	}
	
}
