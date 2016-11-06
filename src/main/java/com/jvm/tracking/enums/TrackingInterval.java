package com.jvm.tracking.enums;

public enum TrackingInterval {
	EVERY_ONE_MINUTE("Tracking every one minute on jvm", 1000*60), 
	EVERY_FIVE_MINUTE("Tracking every five minute on jvm", 1000*60*5),
	EVERY_TEN_MINUTE("Tracking every ten minute on jvm", 1000*60*10),
	EVERY_ONE_HOUR("Tracking every one hour on jvm", 1000*60*60),
	EVERY_TWO_HOUR("Tracking every two hour on jvm", 1000*60*60*2),
	EVERY_FIVE_HOUR("Tracking every five hour on jvm", 1000*60*60*5),
	EVERY_TEN_HOUR("Tracking every ten hour on jvm", 1000*60*60*10);
	
	private String description;
	private int interval;
	
	private TrackingInterval(String description, int interval) {
		this.setDescription(description);
		this.setInterval(interval);
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
