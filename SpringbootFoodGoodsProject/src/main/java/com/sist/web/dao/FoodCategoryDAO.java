package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sist.web.entity.*;
import java.util.*;

@Repository
public interface FoodCategoryDAO extends JpaRepository<FoodCategoryEntity, Integer>{

	@Query(value = "SELECT * FROM food_category "
			+ "ORDER BY cno ASC "
			+ "LIMIT :start, :end", nativeQuery = true) // 개수 자르기
	public List<FoodCategoryEntity> foodCategoryListData(@Param("start") Integer start, @Param("end") Integer end);
	
	
	public FoodCategoryEntity findByCno(int cno);
	
	
	
}
