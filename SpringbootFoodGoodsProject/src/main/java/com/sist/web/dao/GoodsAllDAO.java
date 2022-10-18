package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sist.web.entity.GoodsEntity;
import java.util.*;

@Repository
public interface GoodsAllDAO extends JpaRepository<GoodsEntity, Integer>{

	// 목록
	@Query(value="SELECT * FROM goods_all ORDER BY no ASC "
	        + "LIMIT :start,12", nativeQuery = true)
	public List<GoodsEntity> goodsListData(@Param("start") Integer start);


	// 상세
	@Query(value="SELECT CEIL(COUNT(*)/12.0) FROM goods_all", nativeQuery = true)
    public int goodsAllTotalpage();
	
	
	// 상세에 이용
	public GoodsEntity findByNo(int no);
}
