package com.jvm.tracking.impl;

import com.jvm.tracking.CPUTracking;

public class CPUTrackingImpl extends Thread implements CPUTracking {
	
	private boolean isCpuTracking = true;
	
	
	public CPUTrackingImpl() {
	}
	
	@Override
	public void run() {
		
		while(isTracking()){
			tracking();
		}
		
	}
	
	public void tracking() {

	}

	public void printCPUStatistic(String cpuMessage) {
		
	}

	public void stopTracking() {
		this.isCpuTracking = false;
	}

	public boolean isTracking() {
		return isCpuTracking;
	}

	public void startTracking() {
		this.isCpuTracking = true;
	}


}
