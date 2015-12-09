package com.hanains.mysite.dao.test;

import java.util.List;

import com.hanains.mysite.dao.GuestBookDao;
import com.hanains.mysite.vo.GuestBookVo;

public class GuestBookDataTest {
	public static void main(String[] args){
		getListTest();
	}
	public static void getListTest(){
		GuestBookDao dao = new GuestBookDao();
		List<GuestBookVo> list = dao.getList();
		for(GuestBookVo vo : list){
			System.out.println(vo);
		}
	}
}
