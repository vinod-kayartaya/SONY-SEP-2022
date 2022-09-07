package com.sony.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TryWithResourcesDemo {
	
	public static void main(String[] args) {
		String filename = "pom.xml";
		
		// try-with-resource block (JDK1.7+)
		try(FileReader reader= new FileReader(filename);){
			int ch;
			while ((ch = reader.read()) != -1) {
				System.out.print((char) ch);
			}
			
		} // reader.close() is automatically called
		catch(Exception ex) {
			log.warn("Something went wrong! - {}", ex);
		}
	}

	public static void main_old(String[] args) {

		String filename = "src/main/resources/log4j.properties";

		FileReader reader = null;
		try {
			reader = new FileReader(filename);
			int ch;

			while ((ch = reader.read()) != -1) {
				System.out.print((char) ch);
			}

		} catch (FileNotFoundException e) {
			log.warn("The speficied file '{}' does not exist!", filename);

		} catch (IOException ex) {
			log.warn("There wan issue while reading the content of the file {}", filename);
		} finally {
			try {
				if (reader != null) {
					reader.close();
					log.debug("reader.close() succeeded");
				}
			} catch (IOException e) {
				log.warn("There wan issue while closing the reader object");
			}
		}
	}
}
