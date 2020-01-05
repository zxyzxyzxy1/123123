package com.bw.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bw.entity.Goods;
import com.bw.entity.Type;

/**
 * @author zxy
 *
 * 2019年12月27日
 */
public interface GoodsService {

	public List<Goods> queryGoods(Map<String, Object> map);
	
	List<Type> listType();
	
	void addGoods(Goods goods);
	void updateGoods(Goods goods);
	
	void deleteGoods(@Param("id")String ids);
	
	Goods GoodsByID(@Param("id")Integer id);
	
	
}
