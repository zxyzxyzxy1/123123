package com.bw.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.entity.Goods;
import com.bw.entity.Type;
import com.bw.mapper.GoodsDao;
import com.bw.service.GoodsService;

/**
 * @author zxy
 *
 * 2019年12月27日
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Resource
	private GoodsDao dao;
	
	public List<Goods> queryGoods(Map<String, Object> map) {
		return dao.queryGoods(map);
	}

	public List<Type> listType() {
		// TODO Auto-generated method stub
		return dao.listType();
	}

	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		dao.addGoods(goods);
	}

	public void deleteGoods(String ids) {
		// TODO Auto-generated method stub
		dao.deleteGoods(ids);
	}

	public Goods GoodsByID(Integer gid) {
		// TODO Auto-generated method stub
		return dao.GoodsByID(gid);
	}

	public void updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		dao.updateGoods(goods);
	}

}
