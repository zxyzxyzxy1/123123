package com.bw.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.entity.Goods;
import com.bw.entity.Type;
import com.bw.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author zxy
 *
 * 2019年12月27日
 */
@Controller
public class GoodsController {

	@Resource
	private GoodsService ser;
	
	@RequestMapping("queryGoods")
	public String query(Model model,@RequestParam(defaultValue="1")Integer pageNum,String name,String begin,String end){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("begin", begin);
		map.put("end", end);
		
		PageHelper.startPage(pageNum, 2);
		List<Goods> list = ser.queryGoods(map);
		
		PageInfo<Goods> page = new PageInfo<Goods>(list);
		model.addAttribute("page", page);
		model.addAttribute("name", name);
		model.addAttribute("begin", begin);
		model.addAttribute("end", end);
		return "list";
	}
	
	@RequestMapping("listType")
	@ResponseBody
	public Object listType(){
		List<Type> list = ser.listType();
		return list;
	}
	
	@RequestMapping("addGoods")
	@ResponseBody
	public boolean addGoods(Goods goods){
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM--dd");
			String format = sdf.format(date);
			goods.setDatea(format);
			goods.setStatus(0);
			ser.addGoods(goods);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping("deleteGoods")
	@ResponseBody
	public boolean deleteGoods(String ids){
		try {
			ser.deleteGoods(ids);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping("GoodsByID")
	@ResponseBody
	public Object GoodsByID(String gid){
		Goods goods = ser.GoodsByID(Integer.parseInt(gid));
//		System.out.println(goods);
		return goods;
	}
	
	@RequestMapping("updateGoods")
	@ResponseBody
	public boolean updateGoods(Goods goods){
		try {
			ser.updateGoods(goods);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
