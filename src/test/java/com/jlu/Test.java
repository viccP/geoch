package com.jlu;

import com.jlu.magmalab.dao.tables.pojos.TmUser;

public class Test {

	public static void main(String[] args) {
		TmUser a=new TmUser();
		a.setLoginId("223");
		
		TmUser b=new TmUser();
		b=a;
		System.out.println(b.getLoginId());
		a.setLoginId("333");
		System.out.println(b.getLoginId());
	}

}
