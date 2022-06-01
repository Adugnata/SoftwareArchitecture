package com.interstatespeedservice;

public class SensorRecord {
	public String licencePlate;
	public int minute;
	public int second;
	public int cameraId;
	public double speed;

	public SensorRecord(String licencePlate, int minute, int second, int cameraId, double speed) {
		this.licencePlate = licencePlate;
		this.minute = minute;
		this.second = second;
		this.cameraId = cameraId;
		this.speed = speed;
	}

	public String toString() {
		return licencePlate+" "+cameraId+" "+minute+" "+second;
	}

	public SensorRecord() {
		super();
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String getLicencePlate() {
		return licencePlate;
	}

	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}


	public int getCameraId() {
		return cameraId;
	}

	public void setCameraId(int cameraId) {
		this.cameraId = cameraId;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	
}
