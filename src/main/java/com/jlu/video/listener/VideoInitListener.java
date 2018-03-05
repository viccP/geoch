package com.jlu.video.listener;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.io.FileUtils;

import com.jlu.cst.CST;
import com.jlu.exception.ConfigException;
import com.jlu.exception.SystemException;
import com.jlu.utils.FFmpegUtils;
import com.jlu.utils.IdGenerator;
import com.jlu.utils.PropUtil;
import com.jlu.video.bean.VideoInfo;

public class VideoInitListener implements ServletContextListener {
	
	private List<String> avilableExtType= Arrays.asList("mp4","flv");
	private final String contextPath="/pages/video/"; 

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * 系统初始化
	 */
	public void contextInitialized(ServletContextEvent sce) {

		Properties props = new Properties();
		InputStream inputStream = null;
		try {

			// 1.获取配置文件参数
			inputStream = getClass().getResourceAsStream("/config.properties");
			props.load(inputStream);
			CST.VIDEO_ORIGINAL_DIR = PropUtil.get(props, "video.original.dir");
			CST.VIDEO_WORK_DIR = PropUtil.get(props, "video.work.dir");
			CST.FFMPEG_PATH=PropUtil.get(props, "ffmpeg.path");

			// 2.读取视频文件；复制到工作区；生成视频缩略图
			readVedioIntoSys(CST.VIDEO_ORIGINAL_DIR);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * 
	 * readVedioIntoSys:(读取视频文件). <br/>
	 * 
	 * @author liboqiang
	 * @param filepath
	 * @throws Exception 
	 * @since JDK 1.6
	 */
	private void readVedioIntoSys(String filepath) throws Exception {
		File file = new File(filepath);
		
		//判断配置的原始视频路径是否为一个文件夹
		if(!file.isDirectory()) {
			throw new ConfigException("原始视频路径["+filepath+"]必须为一个目录");
		}
		
		initVideoWorkSpace();
		
		//递归获取文件夹下所有文件
		String[] filelist = file.list();
		for (String fileName:filelist) {
			File readfile = new File(filepath + "/" + fileName);
			if (!readfile.isDirectory()) {
				String fileUrl = readfile.getAbsolutePath() + "/" + readfile.getName();
				int lastDotPos = fileUrl.lastIndexOf(".");
				String extType = fileUrl.substring(lastDotPos + 1, fileUrl.length());
				
				//验证文件扩展名
				if(!avilableExtType.contains(extType)) {
					continue;
				}
				
				//定义需要的参数
				String rndId=IdGenerator.genId();
				String desFileName=rndId+"."+extType;
				String desFileUrl=CST.VIDEO_WORK_DIR+desFileName;
				String snapShotPicName=rndId+".jpg";
				String snapshotPicUrl=CST.VIDEO_WORK_DIR+snapShotPicName;
				
				//生成目标文件
				File destFile=new File(desFileUrl);
				
				//copy文件到目标区域
				try {
					FileUtils.copyFile(readfile, destFile);
				} catch (IOException e) {
					e.printStackTrace();
					throw new SystemException("文件["+fileUrl+"]拷贝失败");
				}
				
				//生成文件缩略图
				FFmpegUtils.snapshot(desFileUrl, snapshotPicUrl);
				
				//将文件信息存储到内存中
				VideoInfo videoInfo=new VideoInfo();
				videoInfo.setVideoName(fileName);
				videoInfo.setVideoPicUrl(contextPath+snapShotPicName);
				videoInfo.setVideoUrl(contextPath+desFileName);
				CST.VIDEO_MAP.put(rndId, videoInfo);
			} else if (readfile.isDirectory()) {
				readVedioIntoSys(filepath + "/" + fileName);
			}
		}

	}

	/**
	 * 
	 * initVideoWorkSpace:(清空视频工作空间). <br/> 
	 * 视频工作区间不能存在多层目录结构（从程序上可以控制到这一点）
	 * @author liboqiang 
	 * @since JDK 1.6
	 */
	private void initVideoWorkSpace() {
		try {
			File file=new File(CST.VIDEO_WORK_DIR);
			if(!file.isDirectory()) {
				throw new ConfigException("视频工作区路径["+CST.VIDEO_WORK_DIR+"]必须为一个目录");
			}
			
			String[] filelist = file.list();
			for(String fileName:filelist) {
				File readfile = new File(CST.VIDEO_WORK_DIR + "/" + fileName);
				readfile.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException("清空视频文件工作区失败");
		}
	}

}
