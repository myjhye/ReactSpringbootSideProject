package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "goods_all")
@Getter
@Setter
public class GoodsEntity {

	@Id
	private int no;
	private String goods_name, goods_sub, goods_first_price, goods_poster;
	private int goods_discount, hit;
}
