package pl.edu.agh.dronka.shop.model.provider;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CSVReader {

	private Map<String, Integer> header = new HashMap<>();

	private List<String[]> data = new LinkedList<>();

	private String filename;

	public CSVReader(String filename) {
		this.filename = filename;
	}

	public List<String[]> getData() {
		return data;
	}

	public String getValue(String[] line, String name) {
		if (header.containsKey(name)) {
			return line[header.get(name)];
		}
		return null;
	}

	public void parse() throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(filename), "UTF8"))) {

			String line;
			while ((line = br.readLine()) != null) {
				data.add(line.split(","));
			}

		}

		String[] headerLine = data.remove(0);

		for (int i = 0; i < headerLine.length; i++) {
			header.put(headerLine[i], i);
		}

	}

}
