package com.jlu.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * ClassName: SerializUtil <br/>
 * Function: Java序列化工具类. <br/>
 * date: 2017年10月30日 下午7:56:25 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class SerializUtil{

	/**
	 * 
	 * java2Stream:(JavaBean转Byte). <br/>
	 * 
	 * @author liboqiang
	 * @param obj
	 * @return
	 * @since JDK 1.6
	 */
	public static <T> byte[] java2Stream(T obj) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(baos);
			out.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return baos.toByteArray();
	}

	/**
	 * 
	 * stream2Java:(Byte转JavaBean). <br/>
	 * 
	 * @author liboqiang
	 * @param bytes
	 * @return
	 * @since JDK 1.6
	 */
	@SuppressWarnings("unchecked")
	public static <T> T stream2Java(byte[] bytes) {

		ByteArrayInputStream bais;
		ObjectInputStream in = null;
		try {
			bais = new ByteArrayInputStream(bytes);
			in = new ObjectInputStream(bais);
			return (T) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
