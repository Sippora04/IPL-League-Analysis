package com.ipl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import org.junit.Test;

public class IPLAnalysisTest {
	
	
	private static String RUNS_FILE_PATH = "C:\\Users\\sippo\\eclipse-workspace\\IPL\\WP DP Data_01 IPL2019FactsheetMostRuns.csv";
	private static String WICKET_FILE_PATH = "C:\\Users\\sippo\\eclipse-workspace\\IPL\\WP DP Data_02 IPL2019FactsheetMostWkts.csv";
	
	public IPLAnalysis iplAnalysis = new IPLAnalysis();
	
	@Test
	void givenRunsFilePath_shouldReturn_NumberOfRecords() {
		int numOfRecords = 0;
		try {
			numOfRecords = iplAnalysis.loadRunsCSV(RUNS_FILE_PATH);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		assertEquals(101, numOfRecords);
	}
	
	@Test
	void givenWicketsFilePath_shouldReturn_NumberOfRecords() {
		int numOfRecords = 0;
		try {
			numOfRecords = iplAnalysis.loadWicketsCSV(WICKET_FILE_PATH);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		assertEquals(99, numOfRecords);
	}
	
	@Test
	void givenRunsFilePath_shouldReturn_topBattingAvg() throws CSVBuilderException, IOException {
		double maxBattingAvg = iplAnalysis.getTopBattingAvg(RUNS_FILE_PATH);
		assertEquals(83.2, maxBattingAvg);
	}
	
	@Test
	void givenRunsFilePath_shouldReturn_topStrikiingRate() throws CSVBuilderException, IOException {
		double maxBattingAvg = iplAnalysis.getTopStrikingRate(RUNS_FILE_PATH);
		assertEquals(333.33, maxBattingAvg);
	}
}
