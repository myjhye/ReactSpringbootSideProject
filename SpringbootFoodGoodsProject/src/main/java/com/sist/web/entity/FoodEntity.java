package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "food_house") // 사용 table 이름
public class FoodEntity {

	@Id
	private int fno; // primary key라서 id 달아주기
	private int cno;
	private String name, address, tel, type, price, time, parking, menu, poster;
	private double score;
}
