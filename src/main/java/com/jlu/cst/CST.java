package com.jlu.cst;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jlu.magmalab.bean.Distribute;
import com.jlu.video.bean.VideoInfo;

public class CST {

	/**默认用户ID**/
	public static final String USER_ID_DEFAULT = "0";
	
	/**自动消息提示标识(-1)**/
	public static final String RES_AUTO_DIALOG = "-1";

	/**会话超时标识(-2)**/
	public static final String RES_SESSION_TIME_OUT = "-2";
	
	/**成功标识(0)**/
	public static final String RES_SUCCESS = "0";
	
	/**业务逻辑错误(1)**/
	public static final String RES_LOGIC_ERROR_1 = "1";

	/**业务逻辑错误(2)**/
	public static final String RES_LOGIC_ERROR_2 = "2";
	
	/**用户性别(1:男)**/
	public static final String USER_SEX_MALE="1";
	
	/**用户性别(0:女)**/
	public static final String USER_SEX_FEMALE="0";
	
	/**用户密码状态(0:初始密码)**/
	public static final int PWD_STATUS_INIT=0;
	
	/**用户密码状态(1:已经修改)**/
	public static final int PWD_STATUS_ALTERED=1;
	
	/**用户默认密码(000000)**/
	public static final String PWD_DEFAULT = "000000";  
	
	/**申请状态(0:完成)**/
	public static final Integer APPLY_STATUS_FINISH = 0;
	
	/**申请状态(1:待审批)**/
	public static final Integer APPLY_STATUS_WAITE = 1;
	
	/**申请状态(2:驳回)**/
	public static final Integer APPLY_STATUS_REJECTED = 2;
	
	/**上传文件夹地址**/
	public static String UPLOAD_DIR="";
	
	/**原始视频路径**/
	public static String VIDEO_ORIGINAL_DIR="";

	/**目标视频路径**/
	public static String VIDEO_WORK_DIR="";

	/**视频解码器地址**/
	public static String FFMPEG_PATH="";

	/**分配系数列表**/
	public static List<Distribute> GLOBAL_DIST_LIST;
	
	/**视频存储静态Map**/
	public static Map<String,VideoInfo> VIDEO_MAP=new HashMap<>();

}
