package com.jlu.cst;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jlu.magmalab.bean.Distribute;
import com.jlu.video.bean.VideoInfo;

public class CST {

	/** 默认用户ID **/
	public static final String USER_ID_DEFAULT = "0";

	/** 自动消息提示标识(-1) **/
	public static final String RES_AUTO_DIALOG = "-1";

	/** 会话超时标识(-2) **/
	public static final String RES_SESSION_TIME_OUT = "-2";

	/** 成功标识(0) **/
	public static final String RES_SUCCESS = "0";

	/** 业务逻辑错误(1) **/
	public static final String RES_LOGIC_ERROR_1 = "1";

	/** 业务逻辑错误(2) **/
	public static final String RES_LOGIC_ERROR_2 = "2";

	/** 用户性别(1:男) **/
	public static final String USER_SEX_MALE = "1";

	/** 用户性别(0:女) **/
	public static final String USER_SEX_FEMALE = "0";

	/** 用户密码状态(0:初始密码) **/
	public static final int PWD_STATUS_INIT = 0;

	/** 用户密码状态(1:已经修改) **/
	public static final int PWD_STATUS_ALTERED = 1;

	/** 用户默认密码(000000) **/
	public static final String PWD_DEFAULT = "000000";

	/** 申请状态(0:完成) **/
	public static final Integer APPLY_STATUS_FINISH = 0;

	/** 申请状态(1:待审批) **/
	public static final Integer APPLY_STATUS_WAITE = 1;

	/** 申请状态(2:驳回) **/
	public static final Integer APPLY_STATUS_REJECTED = 2;

	/** 文件格式xls **/
	public static final String FILE_TYPE_XLS = "xls";

	/** 文件格式xlsx **/
	public static final String FILE_TYPE_XLSX = "xlsx";

	/** 导入文件类型(0:结晶) **/
	public static final int IMP_DATA_TYPE_CRYSTAL = 0;

	/** 导入文件类型(1:熔融) **/
	public static final int IMP_DATA_TYPE_MELT = 1;

	/**系统异常消息**/
	public static final String MSG_SYS_ERR = "系统异常请联系系统管理员";
	
	/**稀土元素序号列表**/
	public static final List<Integer> REE_ELE_INDEX_ARRAY= Arrays.asList(new Integer[]{35,13,51,44,62,21,25,66,19,30,20,72,77,37});
	
	/**稀土元素名称列表**/
	public static final List<String> REE_ELE_NAME_ARRAY= Arrays.asList(new String[]{"La","Ce","Pr","Nd","Sm","Eu","Gd","Tb","Dy","Ho","Er","Tm","Yb","Lu"});
	
	/**微量元素序号列表**/
	public static final List<Integer> TRACE_ELE_INDEX_ARRAY= Arrays.asList(new Integer[]{53,6,69,73,43,35,13,51,64,44,79,28,62,21,76,30,77});
	
	/**微量元素名称列表**/
	public static final List<String> TRACE_ELE_NAME_ARRAY= Arrays.asList(new String[]{"Rb","Ba","Th","U","Nb","La","Ce","Pr","Sr","Nd","Zr","Hf","Sm","Eu","Y","Ho","Yb","Yb"});

	/** 上传文件夹地址 **/
	public static String UPLOAD_DIR = "";

	/** 原始视频路径 **/
	public static String VIDEO_ORIGINAL_DIR = "";

	/** 目标视频路径 **/
	public static String VIDEO_WORK_DIR = "";

	/** 视频解码器地址 **/
	public static String FFMPEG_PATH = "";

	/** 分配系数列表 **/
	public static List<Distribute> GLOBAL_DIST_LIST;

	/** 视频存储静态Map **/
	public static Map<String, VideoInfo> VIDEO_MAP = new HashMap<>();

}
