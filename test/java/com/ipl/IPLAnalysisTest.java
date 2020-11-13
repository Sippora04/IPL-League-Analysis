package com.ipl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class IPLAnalysisTest {
	
	private static String RUNS_FILE_PATH = "C:\\Users\\sippo\\eclipse-workspace\\IPL\\src\\WP DP Data_01 IPL2019FactsheetMostRuns.csv";
	private static String WICKET_FILE_PATH = "C:\\Users\\sippo\\eclipse-workspace\\IPL\\src\\WP DP Data_02 IPL2019FactsheetMostWkts.csv";
	
	//Object created
	IPLAnalysis iplAnalysis = new IPLAnalysis();
	
	@Test
	public void givenRunsFile_ShouldReturn_NumberOfRecords() {
		int numOfRecords = 0;
		try {
			numOfRecords = iplAnalysis.loadRunsCSV(RUNS_FILE_PATH);
		}	catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void givenWickets_ShouldReturn_NumberOfRecords() {
		int numOfRecords = 0;
		try {
			numOfRecords = iplAnalysis.loadRunsCSV(WICKET_FILE_PATH);
		}	catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void givenRunsFilePath_ShouldReturn_TopBattingAvg() throws CSVBuilderException, IOException {
		double maxBattingAvg = iplAnalysis.getTopBattingAvg.(RUNS_FILE_PATH); 
		assertEquals(83.2, maxBattingAvg);
	}

}
