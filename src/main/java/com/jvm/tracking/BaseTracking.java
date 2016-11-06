package com.jvm.tracking;

public interface BaseTracking {
	public abstract boolean isTracking();
	public abstract void tracking();
	public abstract void startTracking();
	public abstract void stopTracking();
}
