package net.erqo.model;

public class Exif implements java.io.Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 6714388113244278862L;
	/**
	 * 厂家
	 */
	private String make;
	/**
	 * 型号
	 */
	private String model;
	/**
	 * 时间
	 */
	private String dateTime;
	/**
	 * 快门速度
	 */
	private String exposureTime;
	/**
	 * 光圈值
	 */
	private String apertureValue;
	/**
	 * ISO
	 */
	private String isoValue;
	/**
	 * Exif version
	 */
	private String exifVer;
	/**
	 * 爆光补尝
	 */
	private String exposureBiasValue;
	/**
	 * 焦距
	 */
	private String focalLength;
	/**
	 * 闪光灯
	 */
	private String flash;

	/**
	 * 模式
	 */
	private String exposureProgram;

	/**
	 * 測光 
	 * Multi-segment：矩阵测光 
	 * Centre-weighted Average:中央重点测光 
	 * Spot:点测光
	 */
	private String meteringMode;

	public String getExposureProgram() {
		return exposureProgram;
	}

	public void setExposureProgram(String exposureProgram) {
		this.exposureProgram = exposureProgram;
	}

	public String getMeteringMode() {
		return meteringMode;
	}

	public void setMeteringMode(String meteringMode) {
		this.meteringMode = meteringMode;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getExposureTime() {
		return exposureTime;
	}

	public void setExposureTime(String exposureTime) {
		this.exposureTime = exposureTime;
	}

	public String getApertureValue() {
		return apertureValue;
	}

	public void setApertureValue(String apertureValue) {
		this.apertureValue = apertureValue;
	}

	public String getIsoValue() {
		return isoValue;
	}

	public void setIsoValue(String isoValue) {
		this.isoValue = isoValue;
	}

	public String getExifVer() {
		return exifVer;
	}

	public void setExifVer(String exifVer) {
		this.exifVer = exifVer;
	}

	public String getExposureBiasValue() {
		return exposureBiasValue;
	}

	public void setExposureBiasValue(String exposureBiasValue) {
		this.exposureBiasValue = exposureBiasValue;
	}

	public String getFocalLength() {
		return focalLength;
	}

	public void setFocalLength(String focalLength) {
		this.focalLength = focalLength;
	}

	public String getFlash() {
		return flash;
	}

	public void setFlash(String flash) {
		this.flash = flash;
	}

}
