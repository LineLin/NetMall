package com.line.web.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.springframework.web.multipart.MultipartFile;


public class FileUploadUtil {
	
	private static final String BASE_URL = "workspace/NetMall/upload";
	
	private static String[] imageSuffix = {"jpg","jpeg","gif","png","pneg","bmp"};

	public static void filesCopy(MultipartFile source,String targetPath){
		byte[] bf = new byte[1024];
		File file = new File(BASE_URL + targetPath);
		if(!file.getParentFile().exists()){
			file.getParentFile().mkdirs();
		}
		
		int read;
		FileOutputStream out = null;
		InputStream in = null;
		try {
			in = source.getInputStream();
		    out = new FileOutputStream(file);
			read = in.read(bf);
			while(read != -1){
				out.write(bf,0,read);
				read = in.read(bf);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}finally{
			try{
				in.close();
				out.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 功能：判断文件是否是图片
	 * @param fileName
	 * @return
	 */
	
	public static boolean isImageFile(String fileName){
		int index = fileName.lastIndexOf(".");
		String suffix = fileName.substring(index+1,fileName.length());
		for(String x : imageSuffix){
			if(x.equals(suffix)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 功能：判断上传的文件是否是图片，文件大小是否超出了限制
	 * @param file	上传的文件
	 * @param limit 文件大小的限制
	 * @return errorMessage 错误提示信息，如果符合条件，返回null
	 */
	public static String checkUploadFile(MultipartFile file,long limit){
		if(!isImageFile(file.getOriginalFilename())){
			return "图片文件必须格式为jpeg,jpg,png,gif,bmp等格式！";
		}
		if(file.getSize() > limit){
			return "文件大小不能超过" + getPropertySizeUnit(limit);
		}
		return null;
	}
	
	public static String getPropertySizeUnit(long size){
		int i = 0;
		double n = size * 1.0; 
		n = n/8;  //由b换算成B
		
		while(n/1024 >= 1){
			n = n/1024;
			i++;
		}
		
		DecimalFormat fomat = new DecimalFormat("##.00");
		String number = fomat.format(n);
		switch(i){
		 case 0 : return number + "B";
		 case 1 : return number + "kB";
		 case 2 : return number + "MB";
		 case 3 : return number + "G";
		 case 4 : return number + "T";
		 default : return "未知大小";
		}
	}
}
