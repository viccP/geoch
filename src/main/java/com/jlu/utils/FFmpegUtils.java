package com.jlu.utils;

import java.util.ArrayList;
import java.util.List;

import com.jlu.cst.CST;
import com.jlu.exception.SystemException;

/**
 * 
 * ClassName: FFmpegUtils <br/> 
 * Function: 视频解码器工具类. <br/> 
 * date: 2018年2月8日 下午1:42:19 <br/> 
 * 
 * @author liboqiang 
 * @version  
 * @since JDK 1.6
 */
public class FFmpegUtils {

	/**
	 * 
	 * snapshot:(截图). <br/> 
	 * 
	 * @author liboqiang
	 * @param fileUrl
	 * @param despicUrl 
	 * @since JDK 1.6
	 */
	public static void snapshot(String fileUrl, String despicUrl) {
		snapshot(fileUrl, despicUrl, "150*150","17");
	}
	
	/**
	 * 
	 * snapshot:(截图). <br/> 
	 * 
	 * @author liboqiang
	 * @param fileUrl
	 * @param despicUrl
	 * @param picSize 
	 * @since JDK 1.6
	 */
	public static void snapshot(String fileUrl, String despicUrl,String picSize) {
		snapshot(fileUrl, despicUrl, picSize,"17");
	}

	/**
	 * 
	 * snapshot:(截图). <br/> 
	 * 
	 * @author liboqiang
	 * @param fileUrl
	 * @param despicUrl
	 * @param picSize
	 * @param time 
	 * @since JDK 1.6
	 */
	public static void snapshot(String fileUrl, String despicUrl, String picSize,String time) {
		List<String> cutpic = new ArrayList<String>();
		cutpic.add(CST.FFMPEG_PATH);
		cutpic.add("-i");
		cutpic.add(fileUrl); // 同上（指定的文件即可以是转换为flv格式之前的文件，也可以是转换的flv文件）
		cutpic.add("-y");
		cutpic.add("-f");
		cutpic.add("image2");
		cutpic.add("-ss"); // 添加参数＂-ss＂，该参数指定截取的起始时间
		cutpic.add(time); // 添加起始时间为第17秒
		cutpic.add("-t"); // 添加参数＂-t＂，该参数指定持续时间
		cutpic.add("0.001"); // 添加持续时间为1毫秒
		cutpic.add("-s"); // 添加参数＂-s＂，该参数指定截取的图片大小
		cutpic.add(picSize); // 添加截取的图片大小为350*240
		cutpic.add(despicUrl); // 添加截取的图片的保存路径
		ProcessBuilder builder = new ProcessBuilder();

		try {
			builder.command(cutpic);
			builder.redirectErrorStream(true);
			// 如果此属性为 true，则任何由通过此对象的 start() 方法启动的后续子进程生成的错误输出都将与标准输出合并，
			// 因此两者均可使用 Process.getInputStream() 方法读取。这使得关联错误消息和相应的输出变得更容易
			builder.start();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException("视频文件["+fileUrl+"]缩略图截取失败");
		}
	}

}
