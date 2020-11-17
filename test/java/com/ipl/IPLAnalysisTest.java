package com.ipl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class IPLAnalysisTest {

	public static String FILEPATH = "C:\\Users\\sippo\\eclipse-workspace\\IPL\\WP DP Data_01 IPL2019FactsheetMostRuns.csv";
	public static String FILEPATHBOWLER = "C:\\Users\\sippo\\eclipse-workspace\\IPL\\WP DP Data_02 IPL2019FactsheetMostWkts.csv";
	private IPLAnalyzer iplAnalyzer;

	@Before
	public void initialize() {
		iplAnalyzer = new IPLAnalyzer();
	}

	// UC1
	@Test
	public void givenCSVFILEPATH_ShouldReturnTopBattingAverage() throws IplAnalyzerException {
		iplAnalyzer.loadIplData(FILEPATH);
		String sortedData = iplAnalyzer.sortBatsmanDataOnAverage();
		MostRunsCSV[] mostRunsCSV = new Gson().fromJson(sortedData, MostRunsCSV[].class);
		Assert.assertEquals("MS Dhoni", mostRunsCSV[0].playerName);
		Assert.assertEquals("83.2", mostRunsCSV[0].average);
	}

	// UC2
	@Test
	public void givenCSVFILEPATH_ShouldReturnTopStrikeRate() throws IplAnalyzerException {
		iplAnalyzer.loadIplData(FILEPATH);
		String sortedData = iplAnalyzer.sortBatsmanDataOnStrikeRate();
		MostRunsCSV[] mostRunsCSV = new Gson().fromJson(sortedData, MostRunsCSV[].class);
		Assert.assertEquals("Ishant Sharma", mostRunsCSV[0].playerName);
		Assert.assertEquals("333.33", mostRunsCSV[0].strikeRate);
	}

	// UC3
	@Test
	public void givenCSVFILEPATH_ShouldReturnPlayerWithMostSixesNFours() throws IplAnalyzerException {
		iplAnalyzer.loadIplData(FILEPATH);
		String sortedData = iplAnalyzer.sortBatsmanDataOnBoundaries();
		MostRunsCSV[] mostRunsCSV = new Gson().fromJson(sortedData, MostRunsCSV[].class);
		Assert.assertEquals("Andre Russell", mostRunsCSV[0].playerName);
		Assert.assertEquals(83, mostRunsCSV[0].foursCollected + mostRunsCSV[0].sixesCollected);
	}

	// UC4
	@Test
	public void givenCSVFILEPATH_ShouldReturnPlayerWithBestStrikeAndBoundaries() throws IplAnalyzerException {
		iplAnalyzer.loadIplData(FILEPATH);
		String sortedData = iplAnalyzer.sortBatsmanDataOnBoundariesThenStrikeRate();
		MostRunsCSV[] mostRunsCSV = new Gson().fromJson(sortedData, MostRunsCSV[].class);
		Assert.assertEquals("Andre Russell", mostRunsCSV[0].playerName);
	}

	// UC5
	@Test
	public void givenCSVFILEPATH_ShouldReturnPlayerWithBestAverageWithStrikeRate() throws IplAnalyzerException {
		iplAnalyzer.loadIplData(FILEPATH);
		String sortedData = iplAnalyzer.sortBatsmanDataOnStrikeRateThenAverage();
		MostRunsCSV[] mostRunsCSV = new Gson().fromJson(sortedData, MostRunsCSV[].class);
		Assert.assertEquals("Ishant Sharma", mostRunsCSV[0].playerName);
	}

	// UC6
	@Test
	public void givenCSVFILEPATH_ShouldReturnPlayerWithMaximumRunsWithBestAverages() throws IplAnalyzerException {
		iplAnalyzer.loadIplData(FILEPATH);
		String sortedData = iplAnalyzer.sortBatsmanDataOnAverageThenMaximumRuns();
		MostRunsCSV[] mostRunsCSV = new Gson().fromJson(sortedData, MostRunsCSV[].class);
		Assert.assertEquals("MS Dhoni", mostRunsCSV[0].playerName);
	}

	// UC7
	@Test
	public void givenCSVFILEPATH_ShouldReturnPalyersWithTopBowlingAverages() throws IplAnalyzerException {
		iplAnalyzer.loadIplDataBowler(FILEPATHBOWLER);
		String sortedData = iplAnalyzer.sortBowlerDataOnAverage();
		MostWicketsCSV[] mostWicketsCSV = new Gson().fromJson(sortedData, MostWicketsCSV[].class);
		Assert.assertEquals("Krishnappa Gowtham", mostWicketsCSV[0].playerName);
		Assert.assertEquals("166", mostWicketsCSV[0].average);
	}

	// UC8
	@Test
	public void givenCSVFILEPATH_ShouldReturnPalyersWithTopStrikingRates() throws IplAnalyzerException {
		iplAnalyzer.loadIplDataBowler(FILEPATHBOWLER);
		String sortedData = iplAnalyzer.sortBowlerDataOnTopStrikingRates();
		MostWicketsCSV[] mostWicketsCSV = new Gson().fromJson(sortedData, MostWicketsCSV[].class);
		Assert.assertEquals("Krishnappa Gowtham", mostWicketsCSV[0].playerName);
		Assert.assertEquals("120", mostWicketsCSV[0].strikeRate);
	}
	
	//UC9
	@Test
	public void givenCSVFilePath_ShouldReturnPalyersWithBestEconomy() throws IplAnalyzerException {
		iplAnalyzer.loadIplDataBowler(FILEPATHBOWLER);
		String sortedData = iplAnalyzer.sortBowlerDataOnEconomy();
		MostWicketsCSV[] mostWicketsCSV = new Gson().fromJson(sortedData, MostWicketsCSV[].class);
		Assert.assertEquals("Shivam Dube", mostWicketsCSV[0].playerName);
		Assert.assertEquals("4.8", mostWicketsCSV[0].economy);
	}
}