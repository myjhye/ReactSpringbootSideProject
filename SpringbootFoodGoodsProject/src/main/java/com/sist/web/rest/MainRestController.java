package com.sist.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.*;
import com.sist.web.entity.*;

//react 연결용으로 사용(데이터 전송) => class/function 혼합해서 사용 (a.k.a hooks)
@RestController
@CrossOrigin("http://localhost:3000/") // react에서 port 허용 => react와 연결 시 필요
public class MainRestController {

	@Autowired
	private FoodCategoryDAO dao;
	
	@Autowired
	private FoodDAO fdao;
	
	@Autowired
	private GoodsAllDAO gdao;
	
	
	
	@GetMapping("/food/category_react") // react에서 요청한 값
	public List<FoodCategoryEntity> foodCategoryListData(int no)
	{	
		int start = 0;
		int end = 0;
		
		if(no == 1)
		{
			start = 0;
			end = 12;
		}
		else if(no == 2)
		{
			start = 12;
			end = 6;
		}
		else if(no == 3)
		{
			start = 18;
			end = 12;
		}
		
		List<FoodCategoryEntity> list = dao.foodCategoryListData(start, end);
		
		return list; // list 값 react로 넘겨 줌
	}
	
	
	
	@GetMapping("/food/food_list_react") // []
	public List<FoodEntity> food_list(int cno)
	{
		List<FoodEntity> list = fdao.findByCno(cno);
		
		for(FoodEntity vo:list)
		{
			// 맛집 이미지 잘라서 출력
			String poster = vo.getPoster();
			poster = poster.substring(0, poster.indexOf("^"));
			vo.setPoster(poster);
			
			// 주소 이름 잘라서 출력
			String address = vo.getAddress();
			address = address.substring(0, address.lastIndexOf("지"));
			vo.setAddress(address);
		}
		
		return list;
	}
	
	@GetMapping("/food/info_react") // {}
	public FoodCategoryEntity food_info(int cno)
	{
		FoodCategoryEntity vo = dao.findByCno(cno);
		
		return vo;
	}
	
	
	@GetMapping("/food/detail_react")
	public FoodEntity food_detail(int fno)
	{
		FoodEntity vo = fdao.findByFno(fno);
		
		return vo;
	}
	
	//---------- 상품
	
	
	// 목록
	@GetMapping("/goods/all_react")
	public List<GoodsEntity> goods_all(int page)
	{
		List<GoodsEntity> list = new ArrayList<GoodsEntity>();
		
		int curpage = page;
		int rowSize = 12;
		int start = (rowSize*curpage)-rowSize;
		
		list = gdao.goodsListData(start);
		
		
		// 상품 이름 자르기
		for(GoodsEntity vo:list)
		{
			String s = vo.getGoods_name();
			if(s.length() > 20)			{
				s = s.substring(0, 20) + "...";
				vo.setGoods_name(s);;
			}
			vo.setGoods_name(s);
		}
		
		return list;
	}
	
	
	// 전체 페이지
	@GetMapping("/goods/all_totalpage")
	public int goods_all_totalpage()
	{
		int total = gdao.goodsAllTotalpage();
		
		return total;
	}
}
