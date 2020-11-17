package com.ipl;

public class BuilderFactoryCSV {
	public static ICSVBuilder generateBuilder() {
		return new OpenCSVBuilder();
	}
}