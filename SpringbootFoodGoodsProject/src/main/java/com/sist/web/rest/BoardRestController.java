package com.sist.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.dao.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class BoardRestController {

	@Autowired
	private BoardDAO dao;
	
	
	// 목록
	@GetMapping("/board/list_react")
	public List<BoardEntity> board_list(int page)
	{
		List<BoardEntity> list = new ArrayList<BoardEntity>();
		
		int rowSize = 10;
		int start = (rowSize*page)-rowSize;
		list = dao.boardListData(start);
		
		return list;
	}
	
	
	
	// 전체 페이지
	@GetMapping("/board/total_react")
	public int board_total()
	{
		return dao.boardTotalPage();
	}
	
	
	
	// 작성
	@GetMapping("/board/insert_react")
	public String board_insert(BoardEntity vo)
	{
		dao.save(vo);
		
		return "ok";
	}
	
	
	// 상세
	@GetMapping("/board/detail_react")
	public BoardEntity board_detail(int no)
	{
		BoardEntity vo = dao.findByNo(no);
		
		// 조회수
		vo.setHit(vo.getHit() + 1);
		dao.save(vo);
		vo = dao.findByNo(no);
		
		return vo;
	}
}
