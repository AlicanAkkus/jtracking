package com.jvm.tracking.impl;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

import com.jvm.tracking.MemoryTracking;
import com.jvm.tracking.enums.TrackingInterval;

public class MemoryTrackingImpl extends Thread implements MemoryTracking {

	private boolean isMemoryTracking = true;
	MemoryMXBean memoryMXBean;
	TrackingInterval trackingInterval;

	public MemoryTrackingImpl(MemoryMXBean memoryMXBean, TrackingInterval trackingInterval) {
		this.memoryMXBean = memoryMXBean;
		this.trackingInterval = trackingInterval;
	}

	@Override
	public void run() {
		System.out.println("######################################\n##### MemoryTracking is started. #####\n######################################");
		while (isTracking()) {
			try {
				tracking();
				Thread.sleep(trackingInterval.getInterval());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("##########################\n##### MemoryTracking is stopped. #####\n##########################");
	}

	public void tracking() {
		try {
			MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
			StringBuilder heapMemoryMessage = new StringBuilder();
			heapMemoryMessage.append("Heap Memory Statistic;");
			heapMemoryMessage.append("\n\tCommitted MB : ").append(heapMemoryUsage.getCommitted() / Math.pow(10, 6));
			heapMemoryMessage.append("\n\tInit MB : ").append(heapMemoryUsage.getInit() / Math.pow(10, 6));
			heapMemoryMessage.append("\n\tMax MB : ").append(heapMemoryUsage.getMax() / Math.pow(10, 6));
			heapMemoryMessage.append("\n\tUsed MB : ").append(heapMemoryUsage.getUsed() / Math.pow(10, 6));

			printMemoryStatistic(heapMemoryMessage.toString());

			MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();
			StringBuilder nonHeapMemoryMessage = new StringBuilder();
			nonHeapMemoryMessage.append("Non Heap Memory Statistic;");
			nonHeapMemoryMessage.append("\n\tCommitted MB : ").append(nonHeapMemoryUsage.getCommitted() / Math.pow(10, 6));
			nonHeapMemoryMessage.append("\n\tInit MB : ").append(nonHeapMemoryUsage.getInit() / Math.pow(10, 6));
			nonHeapMemoryMessage.append("\n\tMax MB : ").append(nonHeapMemoryUsage.getMax() / Math.pow(10, 6));
			nonHeapMemoryMessage.append("\n\tUsed MB : ").append(nonHeapMemoryUsage.getUsed() / Math.pow(10, 6));

			printMemoryStatistic(nonHeapMemoryMessage.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printMemoryStatistic(String memoryMessage) {
		System.out.println(memoryMessage);
	}

	public boolean isTracking() {
		return isMemoryTracking;
	}

	public void stopTracking() {
		this.isMemoryTracking = false;
	}

	public void startTracking() {
		this.isMemoryTracking = true;
	}

	public static void main(String[] args) {
		MemoryTrackingImpl memoryTrackingImpl = new MemoryTrackingImpl(ManagementFactory.getMemoryMXBean(), TrackingInterval.EVERY_ONE_MINUTE);
		memoryTrackingImpl.start();
	}

}
