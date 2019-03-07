//package com.example.demo.controller;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//
//import org.springframework.core.io.InputStreamResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class FileDownloadController {
//	@RequestMapping(value = "/download", method = RequestMethod.GET)
//	public ResponseEntity<Object> downloadFile() throws FileNotFoundException {
//		// init
//		String fileName = "/var/tmp/mysql.png";
//		File file;
//		InputStreamResource sir;
//		HttpHeaders headers;
//		ResponseEntity<Object> responseEntity = null;
//		file = new File(fileName);
//		sir = new InputStreamResource(new FileInputStream(file));
//		headers = new HttpHeaders();
//
//		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
//		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
//		headers.add("Pragma", "no-cache");
//		headers.add("Expires", "0");
//		responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length())
//				.contentType(MediaType.parseMediaType("application/txt")).body(sir);
//		return responseEntity;
//	}
//}
