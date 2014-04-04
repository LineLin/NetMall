package com.line.web.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CheckCodeProductor {
	
	private int width = 90;
	
	private int height = 20;
	
	private int codeCount = 4;
	
	private int fontHeight = 18;
	
	private int charWidth = 15;
	
	private int charY = 15;
	
	private String code;
	
	private final char[] items = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',  
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',  
            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	
	public CheckCodeProductor(){
		
	}
	
	public CheckCodeProductor(int width,int height,int count){
		this.width = width;
		this.height = height;
		this.codeCount = count;
	}
	public BufferedImage getCodeImage(){
		
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		
		Graphics  gd = image.getGraphics();
		
		StringBuffer sb = new StringBuffer();
		//先清空code
		code="";
		
		 //为背景设置颜色
		gd.setColor(Color.WHITE);
		
		gd.fillRect(0, 0, width, height); 
		
		Font font = new Font("微软雅黑",Font.BOLD,fontHeight);
		
		gd.setFont(font);
		
		//画边框
		gd.setColor(Color.BLACK);
		gd.drawRect(0, 0, width, height);
		
		Random random = new Random();
		
		
		//画干扰线
		for(int i = 0; i<20; i++){
			int x1 = random.nextInt(width);
			int y1 = random.nextInt(height);
			int x2 = random.nextInt(10);
			int y2 = random.nextInt(10);
			gd.setColor(getRandomColor());
			gd.drawLine(x1, y1, x1+x2, y1+y2);
		}
		
		//画干扰像素点
		for(int i = 0; i<50; i++){
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			gd.setColor(getRandomColor());
			gd.drawLine(x, y, x, y);
		}
		//生成验证码
		for(int i = 0; i<codeCount;i++){
			int index = random.nextInt(items.length);
			gd.setColor(getRandomColor());
			gd.drawString(String.valueOf(items[index]), (i+1) * charWidth, charY);
			sb.append(items[index]);
		}
		code = sb.toString().toLowerCase();
		return image;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getheight() {
		return height;
	}

	public void setheight(int height) {
		this.height = height;
	}

	public int getCodeCount() {
		return codeCount;
	}

	public void setCodeCount(int codeCount) {
		this.codeCount = codeCount;
	}
	
	public String getCode(){
		return code;
	}
	
	private Color getRandomColor(){
		Random random = new Random();
		int r,g,b;
		r = random.nextInt(255);
		g = random.nextInt(255);
		b = random.nextInt(255);
		return new Color(r,g,b);
	}
	

}
