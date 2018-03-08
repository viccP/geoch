package com.jlu.utils;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void test() {
		System.out.println(Utils.checkEleName("FF"));
		System.out.println(Utils.checkEleName("Fe"));
		System.out.println(Utils.checkEleName("ff"));
		System.out.println(Utils.checkEleName("FFe"));
		System.out.println(Utils.checkEleName("FFF"));
		System.out.println(Utils.checkEleName("Fee"));
		System.out.println(Utils.checkEleName("Feeee"));
		System.out.println(Utils.base64Encode("这是测试1"));
		System.out.println(Utils.base64Decode(Utils.base64Encode(("这是测试1"))));
	}
}
