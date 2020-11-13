package com.ipl;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.CSVBuilder.CSVBuilderException;
import com.CSVBuilder.CSVBuilderFactory;
import com.CSVBuilder.ICSVBuilder;

public class IPLAnalysis {

	List<IPLBatting> runsCSVList = null;
	List<IPLBowling> wicketsCSVList = null;
	
	private static <K> List <K> loadCSVData(String filepath, Class<K> csvClass) throws CSVBuilderException, IOException {
		Reader reader = Files.newBufferedReader(Paths.get(filepath));
		ICSVBuilder<K> csvBuilder = CSVBuilderFactory.createCSVBuilder();
		return csvBuilder.getCSVFileList(reader, csvClass);
	}
	
	public int loadRunsCSV(String filePath) throws CSVBuilderException, IOException {
		runsCSVList = loadCSVData(filePath, IPLBatting.class);
		return runsCSVList.size();
	}
	
	public int loadWicketsCSV(String filePath) throws CSVBuilderException, IOException {
		wicketsCSVList = loadCSVData(filePath, IPLBowling.class);
		return wicketsCSVList.size();
	}
	
	public double getTopBattingAvg(String filePath) throws CSVBuilderException, IOException {
		loadRunsCSV(filePath);
		double max = runsCSVList.stream().map(entry -> entry.average).max(Double::compare).get();
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to IPL League Analysis Problem ***");
	}
}
