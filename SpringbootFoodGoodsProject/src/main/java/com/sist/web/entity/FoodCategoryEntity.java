package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name="food_category") // table 이름
@Getter
@Setter
public class FoodCategoryEntity {

	// 테이블에 있는 컬럼만 지정
	
	@Id // primary key => cno
	private int cno;
	private String title, subject, poster, link;
}
