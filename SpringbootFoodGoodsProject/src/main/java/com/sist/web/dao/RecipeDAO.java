package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sist.web.entity.RecipeEntity;
import com.sist.web.entity.*;

@Repository
public interface RecipeDAO extends JpaRepository<RecipeEntity, Integer> {

	// 찾기
	@Query(value = "SELECT * FROM recipe "
			+ "WHERE title LIKE CONCAT('%', :ss, '%') "
			+ "ORDER BY no ASC "
			+ "LIMIT :start, 12", nativeQuery = true)
	public List<RecipeEntity> recipeFindData(@Param("ss") String ss, @Param("start") Integer start);
	
	
	// 페이징
	@Query(value = "SELECT CEIL(COUNT(*)/12.0) FROM recipe "
			+ "WHERE title LIKE CONCAT('%', :ss, '%')", nativeQuery = true)
	public int recipeTotalPage(@Param("ss") String ss);
}
