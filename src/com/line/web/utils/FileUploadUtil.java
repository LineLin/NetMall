package com.line.web.utils;

public class FileUploadUtil {
	
	public static String parseFileName(String header){
		return header.substring(header.lastIndexOf('=')+2,header.length()-1);
	}

}
