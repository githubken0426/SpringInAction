package org.fsd.com.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * java的简单的套接字连接，短连接，满足一次性的收发；注释部分可以通过控制台接受输入字符
 * @ClassName: ScoketSample 
 * @Description: 
 * @author ken 
 * @date 2017年7月25日 下午3:18:03
 */
public class ScoketSample {
	public static final String IP_ADDR = "127.0.0.1";// 服务器地址
	public static final int PORT = 3096;// 服务器端口号
	static String text = null;

	public static void main(String[] args) {
		socketTest(IP_ADDR, PORT);
	}

	static void socketTest(String ip, int port) {
		try {
			Socket socket = new Socket(ip, port);
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			os.println("测试消息");
			os.flush();

			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg = is.readLine();
			System.out.println("客户端收到：" + msg);

			os.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("+++++客户端发生异常+++++");
		}
	}

	/**
	 * java的简单socket连接，长连接，尝试连续从服务器获取消息
	 * @param ip
	 * @param port
	 * @throws UnknownHostException
	 * @throws IOException
	 * @throws 
	 * @date 2017年7月25日 下午3:16:14
	 */
	public static void socketTest2(String ip, int port) throws UnknownHostException, IOException {
		System.out.println("客户端启动...");
		Socket socket = new Socket(ip, port);
		PrintWriter os = new PrintWriter(socket.getOutputStream());
		os.println("al");
		os.println("two");
		os.flush();
		while (true) {
			try {
				// 创建一个流套接字并将其连接到指定主机上的指定端口号
				DataInputStream input = new DataInputStream(socket.getInputStream());
				// 读取服务器端数据
				byte[] buffer;
				buffer = new byte[input.available()];
				if (buffer.length != 0) {
					System.out.println("length=" + buffer.length);
					// 读取缓冲区
					input.read(buffer);
					// 转换字符串
					String three = new String(buffer);
					System.out.println("内容=" + three);
					if (three.equals("1111\n")) {
						System.out.println("发送返回心跳包");
						os = new PrintWriter(socket.getOutputStream());
						os.println("1112");
						os.flush();
					}
				}
			} catch (Exception e) {
				System.out.println("客户端异常:" + e.getMessage());
				os.close();
			}
		}
	}

}
