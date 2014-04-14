package com.line.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.line.web.model.ClassItem;
import com.line.web.model.Classification;
import com.line.web.model.ClassificationValue;
import com.line.web.model.Commodity;
import com.line.web.model.User;
import com.line.web.service.CommodityService;
import com.line.web.utils.DateUtil;
import com.line.web.utils.FileUploadUtil;
import com.line.web.view.support.ClassItemVo;
import com.line.web.view.support.CommodityForm;

@Controller
@RequestMapping("/commodity")
public class CommodityController {
	
	private final long maxFileSize =  1024 * 1024 * 8l; //	1M   
	
	@Autowired
	private CommodityService commodityService;
	
	@RequestMapping("/update")
	public String addCommodity(CommodityForm commodity){
		
		return null;
	}
	
	@RequestMapping("/getClassitem")
	@ResponseBody
	public List<ClassItemVo> getAllClassItem(){
		List<ClassItem> itemList = commodityService.getAllClassItem();
		List<ClassItemVo> itemVoList = new ArrayList<ClassItemVo>();
		for(ClassItem item : itemList){
			ClassItemVo vo = new ClassItemVo(item.getId(),item.getName());
			itemVoList.add(vo);
		}
		return itemVoList;
	}
	
	@RequestMapping(value="/save",method= RequestMethod.POST)
	public String saveCommodity(CommodityForm form,ModelMap model){//,@ModelAttribute User user){
		System.out.println("********");
		User user = new User();
		user.setAccount("dd");
		if(form.getPhoto() == null){
			model.addAttribute("errMsg","请添加商品图片!");
			return "forward:/shop/add/commodity";
		}
		
		String err = FileUploadUtil.checkUploadFile(form.getPhoto(), maxFileSize);
		if(err != null){
			model.addAttribute("errMsg",err);
			return "forward:/shop/add/commodity";
		}

		String suffix = FileUploadUtil.getSuffix(form.getPhoto().getOriginalFilename());
		String savePath = "com/" + user.getAccount() + "/"  + DateUtil.getCurTimeMills() + "." +  suffix;
		boolean uploadSuccess = FileUploadUtil.filesCopy(form.getPhoto(),savePath);
		
		if(!uploadSuccess){
			model.addAttribute("errMsg","服务器繁忙，请稍后再试！");
			return "forward:/shop/add/commodity";
		} 
		
		//组装商品类
		Commodity commodity = new Commodity();
		commodity.setName(form.getName());
		commodity.setDescription(form.getComDescription());
		commodity.setImage(FileUploadUtil.getBaseUrl() + savePath);
		commodityService.saveCommodity(commodity);
		
		String[] itemIds = form.getClassitemId();
		String[] values = form.getClassValue();
		MultipartFile[] images = form.getClassValueImage();
		int[] counts = form.getCount();
		if(itemIds.length > 0){
			for(int i = 0; i < itemIds.length; i++){
				Classification classification = new Classification();
				ClassItem item = commodityService.getClassItemById(itemIds[i]);
				classification.setClassItem(item);
				classification.setCommodity(commodity);
				commodityService.saveClassification(classification);
				System.out.println("i=" + i + "  count = " + counts[i]);
				for(int j = i*counts[i]; j<(i+1) * counts[i];j++){
					
					ClassificationValue value = new ClassificationValue();
					value.setDescription(values[j]);
					String imgSavePath = "com/" + user.getAccount() + "/" 
											+ DateUtil.getCurTimeMills() + "."
											+ FileUploadUtil.getSuffix(images[j].getOriginalFilename());   
					
					if(!FileUploadUtil.filesCopy(images[j],imgSavePath)){
						model.addAttribute("errMsg","图片上传失败！");
						return "forward:/shop/add/commodity";
					}
					
					value.setImage(FileUploadUtil.getBaseUrl() + imgSavePath);
					value.setClassification(classification);
					commodityService.saveClassificationValue(value);
				}

			}
		}
		model.addAttribute("successMsg","商品添加成功！");
		return "forward:/shop/add/commodity";
	}
}
