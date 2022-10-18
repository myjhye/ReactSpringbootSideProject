package com.sist.web.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sist.web.entity.FoodEntity;

@Repository
public interface FoodDAO extends JpaRepository<FoodEntity, Integer>{

	public List<FoodEntity> findByCno(int cno); // == SELECT * FROM food_house WHERE cno=매개변수
	public FoodEntity findByFno(int fno); // == SELECT * FROM food_house WHERE fno=매개변수
	
	// sql 문장 없이 cno, fno 값을 찾아 줌
}
