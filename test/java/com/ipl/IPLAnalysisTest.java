package com.ipl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class IPLAnalysisTest {

	public static String FILEPATH = "C:\\Users\\sippo\\eclipse-workspace\\IPL\\WP DP Data_01 IPL2019FactsheetMostRuns.csv";
	private IPLAnalyzer iplAnalyzer;

	@Before
	public void initialize() {
		iplAnalyzer = new IPLAnalyzer();
	}

	@Test
	public void givenCSVFILEPATH_ShouldReturnTopBattingAverage() throws IplAnalyzerException {
		iplAnalyzer.loadIplData(FILEPATH);
		String sortedData = iplAnalyzer.sortBatsmanDataOnAverage();
		MostRunsCSV[] mostRunsCSV = new Gson().fromJson(sortedData, MostRunsCSV[].class);
		Assert.assertEquals("MS Dhoni", mostRunsCSV[0].playerName);
		Assert.assertEquals("83.2", mostRunsCSV[0].average);
	}

	@Test
	public void givenCSVFILEPATH_ShouldReturnTopStrikeRate() throws IplAnalyzerException {
		iplAnalyzer.loadIplData(FILEPATH);
		String sortedData = iplAnalyzer.sortBatsmanDataOnStrikeRate();
		MostRunsCSV[] mostRunsCSV = new Gson().fromJson(sortedData, MostRunsCSV[].class);
		Assert.assertEquals("Ishant Sharma", mostRunsCSV[0].playerName);
		Assert.assertEquals("333.33", mostRunsCSV[0].strikeRate);
	}

	@Test
	public void givenCSVFILEPATH_ShouldReturnPlayerWithMostSixesAndFours() throws IplAnalyzerException {
		iplAnalyzer.loadIplData(FILEPATH);
		String sortedData = iplAnalyzer.sortBatsmanDataOnBoundaries();
		MostRunsCSV[] mostRunsCSV = new Gson().fromJson(sortedData, MostRunsCSV[].class);
		Assert.assertEquals("Andre Russell", mostRunsCSV[0].playerName);
		Assert.assertEquals(83, mostRunsCSV[0].foursCollected + mostRunsCSV[0].sixesCollected);
	}

	@Test
	public void givenCSVFILEPATH_ShouldReturnPlayerWithBestStrikeAndBoundaries() throws IplAnalyzerException {
		iplAnalyzer.loadIplData(FILEPATH);
		String sortedData = iplAnalyzer.sortBatsmanDataOnBoundariesThenStrikeRate();
		MostRunsCSV[] mostRunsCSV = new Gson().fromJson(sortedData, MostRunsCSV[].class);
		Assert.assertEquals("Andre Russell", mostRunsCSV[0].playerName);
	}

	@Test
	public void givenCSVFilePath_ShouldReturnPlayerWithBestAverageWithStrikeRate() throws IplAnalyzerException {
		iplAnalyzer.loadIplData(FILEPATH);
		String sortedData = iplAnalyzer.sortBatsmanDataOnStrikeRateThenAverage();
		MostRunsCSV[] mostRunsCSV = new Gson().fromJson(sortedData, MostRunsCSV[].class);
		Assert.assertEquals("Ishant Sharma", mostRunsCSV[0].playerName);
	}
	
	@Test
	public void givenCSVFilePath_ShouldReturnPlayerWithMaximumRunsWithBestAverages() throws IplAnalyzerException {
		iplAnalyzer.loadIplData(FILEPATH);
		String sortedData = iplAnalyzer.sortBatsmanDataOnAverageThenMaximumRuns();
		MostRunsCSV[] mostRunsCSV = new Gson().fromJson(sortedData, MostRunsCSV[].class);
		Assert.assertEquals("MS Dhoni", mostRunsCSV[0].playerName);
	}
}