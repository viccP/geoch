package com.jlu.utils;

/**
 * 
 * ClassName: CmdUtils <br/>
 * Function: 执行主机命令. <br/>
 * date: 2017年10月9日 上午9:56:24 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class CmdUtils {

	/**
	 * 
	 * exec:(执行命令). <br/>
	 * 
	 * @author liboqiang
	 * @param cmd
	 * @since JDK 1.6
	 */
	public static void exec(String cmd) {
		try {
			Process process = Runtime.getRuntime().exec(cmd);
			StreamGobbler errorGobbler = new StreamGobbler(process.getErrorStream(), "ERROR");
			// kick off stderr
			errorGobbler.start();
			StreamGobbler outGobbler = new StreamGobbler(process.getInputStream(), "STDOUT");
			// kick off stdout
			outGobbler.start();
			process.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * exec:(执行多条命令). <br/> 
	 * 
	 * @author liboqiang
	 * @param cmds 
	 * @since JDK 1.6
	 */
	public static void exec(String[] cmds) {
		try {
			Process process = Runtime.getRuntime().exec(cmds);
			StreamGobbler errorGobbler = new StreamGobbler(process.getErrorStream(), "ERROR");
			// kick off stderr
			errorGobbler.start();
			StreamGobbler outGobbler = new StreamGobbler(process.getInputStream(), "STDOUT");
			// kick off stdout
			outGobbler.start();
			process.waitFor();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
