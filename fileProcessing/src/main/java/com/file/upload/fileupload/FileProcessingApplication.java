package com.file.upload.fileupload;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ch.qos.logback.classic.Logger;

/**
 * 
 * @author Durgadevi G
 *
 */

@SpringBootApplication
@RestController
public class FileProcessingApplication {
	
	Logger logger = (Logger) LoggerFactory.getLogger(FileProcessingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FileProcessingApplication.class, args);
	}
	
	@RequestMapping(value="/downloadFile",method=RequestMethod.GET)
	public ResponseEntity<Object> downloadFile() throws IOException{	
		logger.trace("Download method started");
		CSVData csv=new CSVData();
		csv.setId("1");
		csv.setName("Jerry");
		csv.setNumber("11");		
		CSVData csv2=new CSVData();
		csv2.setId("2");
		csv2.setName("Tom");
		csv2.setNumber("12");
		List<CSVData> csvData=new ArrayList<>();
		csvData.add(csv);
		csvData.add(csv2);		
		StringBuilder fileContent=new StringBuilder("Id,Name,Number\n");
		for(CSVData csvd : csvData){			
			fileContent.append(csvd.getId()).append(",").append(csvd.getName()).append(",").append(csvd.getNumber()).append(",").append("\n");		
		}
		
		String fileName="src/main/resources/download.csv";	
		FileWriter fileWriter=new FileWriter(fileName);
		fileWriter.write(fileContent.toString());
		fileWriter.flush();
	    return new ResponseEntity<>("File is downloaded Successfully in path src/main/resources/download.csv",HttpStatus.OK);
	}
	
	@RequestMapping(value="/copyFileContent",method=RequestMethod.GET)
	public ResponseEntity<String> copyFileContent() throws IOException{	
		logger.trace("CopyFileContent method started");
		File src = new File("src/main/resources/upload.csv");
		File dest = new File("src/main/resources/copyFileContent/copyFileContent.csv");
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dest);
		byte[] buffer =new byte[1024];
		int length;		
		while((length=fis.read(buffer))>0){
			fos.write(buffer, 0, length);
		}	
		return new ResponseEntity<>("File CopyContent Successfully present in path fileupload/src/main/resources/copyFileContent/copyFileContent.csv ",HttpStatus.OK);
	}
	
	@RequestMapping(value="/copyFile",method=RequestMethod.GET)
	public ResponseEntity<String> CopyFile()throws IOException{
		logger.trace("Copy method started");
		File sourceFile=new File("src/main/resources/upload.csv");
		File convertFile=new File("src/main/resources/copyFile/copyFile.csv");
		convertFile.createNewFile();
		FileInputStream fis = new FileInputStream(sourceFile);	
		FileOutputStream fout=new FileOutputStream(convertFile);
		byte[] buffer =new byte[1024];
		int length;		
		while((length=fis.read(buffer))>0){
			fout.write(buffer, 0, length);
		}	
		fout.close();
		return new ResponseEntity<>("File is Copied Successfully in path src/main/resources/copyFile/copyFile.csv",HttpStatus.OK);		
	}
	
	
	@RequestMapping(value="/deleteFile")
	public ResponseEntity<String> deleteFile() throws IOException{	
		logger.trace("DeleteFile method started");
		String message ;
		File deleteFile = new File("src/main/resources/deleteFile/deleteFile.csv");
		if(deleteFile.exists()) {
			deleteFile.delete();
			message ="File deleted Successfully.";
		}
		else
		{
			message ="File not found in the server.Create the file before delete operation";
		}	
		return new ResponseEntity<>(message,HttpStatus.OK);				
	}
	
	@RequestMapping(value="/createFile")
	public ResponseEntity<String> createFile() throws IOException{	
	logger.trace("CreateFile method started");
	File convertFile=new File("src/main/resources/deleteFile/deleteFile.csv");
	convertFile.createNewFile();
    return new ResponseEntity<>("File Created Sucessfully",HttpStatus.OK);			
	}
}
