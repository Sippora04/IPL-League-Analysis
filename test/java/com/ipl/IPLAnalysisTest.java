package com.ipl;

import java.util.HashMap;

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

	// UC9
	@Test
	public void givenCSVFILEPATH_ShouldReturnPalyersWithBestEconomy() throws IplAnalyzerException {
		iplAnalyzer.loadIplDataBowler(FILEPATHBOWLER);
		String sortedData = iplAnalyzer.sortBowlerDataOnEconomy();
		MostWicketsCSV[] mostWicketsCSV = new Gson().fromJson(sortedData, MostWicketsCSV[].class);
		Assert.assertEquals("Shivam Dube", mostWicketsCSV[0].playerName);
		Assert.assertEquals("4.8", mostWicketsCSV[0].economy);
	}

	// UC10
	@Test
	public void givenCSVFILEPATH_ShouldReturnPalyersWithBestStrikeWithFiveAndfourwicket() throws IplAnalyzerException {
		iplAnalyzer.loadIplDataBowler(FILEPATHBOWLER);
		String sortedData = iplAnalyzer.sortBowlerDataBestStrikeRateWithFiveAndFourWicketHauls();
		MostWicketsCSV[] mostWicketsCSV = new Gson().fromJson(sortedData, MostWicketsCSV[].class);
		Assert.assertEquals("Lasith Malinga", mostWicketsCSV[0].playerName);
		Assert.assertEquals("16.81", mostWicketsCSV[0].strikeRate);
	}

	// UC11
	@Test
	public void givenCSVFILEPATH_ShouldReturnPalyersWithGreatBowlingAveragesWithBestStrikeRate()
			throws IplAnalyzerException {
		iplAnalyzer.loadIplDataBowler(FILEPATHBOWLER);
		String sortedData = iplAnalyzer.sortBowlerDataBestAveragesWithStrikeRate();
		MostWicketsCSV[] mostWicketsCSV = new Gson().fromJson(sortedData, MostWicketsCSV[].class);
		Assert.assertEquals("Krishnappa Gowtham", mostWicketsCSV[0].playerName);
		Assert.assertEquals("120", mostWicketsCSV[0].strikeRate);
	}

	// UC12
	@Test
	public void givenCSVFILEPATH_ShouldReturnPalyersWithMaximumWicketsWithBestAverage() throws IplAnalyzerException {
		iplAnalyzer.loadIplDataBowler(FILEPATHBOWLER);
		String sortedData = iplAnalyzer.sortBowlerWithMaximumWicketsWithBestAverage();
		MostWicketsCSV[] mostWicketsCSV = new Gson().fromJson(sortedData, MostWicketsCSV[].class);
		Assert.assertEquals("Krishnappa Gowtham", mostWicketsCSV[0].playerName);
		Assert.assertEquals("1", mostWicketsCSV[0].wicketsTaken);
	}

	// UC13
	@Test
	public void givenCSVFILEPATH_ShouldReturnPlayerWithBestBattingAndBowlingAverage() throws IplAnalyzerException {
		iplAnalyzer.loadIplData(FILEPATH);
		iplAnalyzer.loadIplDataBowler(FILEPATHBOWLER);
		HashMap<String, Double> bestAverage = iplAnalyzer.getAveragePoints();
		Double max = 0.0;
		String bestAllRounder = null;
		// checking for maximum average points
		for (String i : bestAverage.keySet()) {
			if (max < bestAverage.get(i))
				max = bestAverage.get(i);
		}
		// printing best all rounder name on basis of average points
		for (String j : bestAverage.keySet()) {
			if (max == bestAverage.get(j)) {
				System.out.println(
						"best player with average is : " + j + " with batting+bowling average : " + bestAverage.get(j));
				bestAllRounder = j;
			}
		}
		Assert.assertEquals("Krishnappa Gowtham", bestAllRounder);
	}

	// UC14
	@Test
	public void givenCSVFILEPATH_ShouldReturnBestAllRounder() throws IplAnalyzerException {
		iplAnalyzer.loadIplData(FILEPATH);
		iplAnalyzer.loadIplDataBowler(FILEPATHBOWLER);
		HashMap<String, Double> allRounderPoints = iplAnalyzer.getAllRounderPoints();
		Double max = 0.0;
		String bestAllRounder = null;
		// checking for maximum points
		for (String i : allRounderPoints.keySet()) {
			if (max < allRounderPoints.get(i))
				max = allRounderPoints.get(i);
		}
		// printing best all rounder name on basis of points
		for (String j : allRounderPoints.keySet()) {
			if (max == allRounderPoints.get(j)) {
				System.out.println("best allrounder is : " + j + " with points " + allRounderPoints.get(j));
				bestAllRounder = j;
			}
		}
		Assert.assertEquals("Andre Russell", bestAllRounder);
	}

	// UC15
	@Test
	public void givenCSVFILEPATH_ShouldReturnPlayerWitnMostHundredsAndBestAverage() throws IplAnalyzerException {
		iplAnalyzer.loadIplData(FILEPATH);
		iplAnalyzer.getBatsmanNameWhoScoredHundreds();
		HashMap<String, Double> batsmanWithHundreds = iplAnalyzer.getBatsmanWithHundredsAndBestAverage();
		Double max = 0.0;
		String batsmanWithHundredNBestAverage = null;
		// checking for maximum average
		for (String i : batsmanWithHundreds.keySet()) {
			if (max < batsmanWithHundreds.get(i))
				max = batsmanWithHundreds.get(i);
		}
		// printing batsman with hundred and best average
		for (String j : batsmanWithHundreds.keySet()) {
			if (max == batsmanWithHundreds.get(j)) {
				System.out.println("batsman with hundred is : " + j + " with average " + batsmanWithHundreds.get(j));
				batsmanWithHundredNBestAverage = j;
			}
		}
		Assert.assertEquals("David Warner ", batsmanWithHundredNBestAverage);
	}

	// UC16
	@Test
	public void givenCSVFILEPATH_ShouldReturnPlayerWithZeroHundredsAndFifties_ButBestAverage()
			throws IplAnalyzerException {
		iplAnalyzer.loadIplData(FILEPATH);
		HashMap<String, Double> batsmanWithNoHundredsNFifty = iplAnalyzer
				.getBatsmanZeroHundredsAndFiftiesButBestAverage();
		Double max = 0.0;
		String batsmanWithNoHundredNFiftyButBestAverage = null;
		// checking for maximum average
		for (String i : batsmanWithNoHundredsNFifty.keySet()) {
			if (max < batsmanWithNoHundredsNFifty.get(i))
				max = batsmanWithNoHundredsNFifty.get(i);
		}
		// printing batsman with zero hundred and zero fifty but best average
		for (String j : batsmanWithNoHundredsNFifty.keySet()) {
			if (max == batsmanWithNoHundredsNFifty.get(j)) {
				System.out.println("Batsman with no hundreds &  no fifites is : " + j + " with best average "
						+ batsmanWithNoHundredsNFifty.get(j));
				batsmanWithNoHundredNFiftyButBestAverage = j;
			}
		}
		Assert.assertEquals("Marcus Stoinis", batsmanWithNoHundredNFiftyButBestAverage);
	}

}