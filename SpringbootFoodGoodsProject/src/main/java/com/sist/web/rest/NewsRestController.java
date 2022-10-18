package com.sist.web.rest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.web.entity.*;
import com.sist.web.manager.*;
import java.util.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class NewsRestController {
   @Autowired
   private NewsManager mgr;
   
   @GetMapping("/news/find_react")
   public List<NewsVO> newsFindData(String ss)
   {
	   List<NewsVO> list=new ArrayList<NewsVO>();
	   try
	   {
	     String json = mgr.newsFind(ss);
	     JSONParser jp = new JSONParser();
	     JSONObject root = (JSONObject)jp.parse(json);
	     JSONArray arr = (JSONArray)root.get("items");
	     
	     for(int i = 0; i < arr.size(); i++)
	     {
	    	 JSONObject obj = (JSONObject)arr.get(i);
	    	 String title = (String)obj.get("title");
	    	 String description = (String)obj.get("description");
	    	 String link = (String)obj.get("link");
	    	 
	    	 NewsVO vo = new NewsVO();
	    	 vo.setTitle(title);
	    	 vo.setDescription(description);
	    	 vo.setLink(link);
	    	 
	    	 list.add(vo);
	     }
	   }catch(Exception ex){}
	   
	   return list;

   }

}