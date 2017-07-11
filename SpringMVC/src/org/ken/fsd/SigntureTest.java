package org.ken.fsd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.ken.fsd.util.GeneratorSignUtil;

import net.sf.json.JSONObject;

public class SigntureTest {
	static String url = "http://localhost:8089/SpringMVC/v1/open/server";

	public static void main(String[] args) throws Exception {
		/*String partnerid = "gtercn";
		String secretKey = "123456";
		String mobile = "18642690085";
		String productid = "";
		String apiid = "28bd0205deb811e683f15254006bd52a";*/
		String time = getServerTime(url);
		System.out.println(time);
		
		/*String sign = GeneratorSignUtil.generateSign(time, partnerid, secretKey, mobile, apiid, productid);
		System.out.println("main:" + time + "--" + sign);*/

		// Map<String, Object> params =new HashMap<String,Object>();
		// params.put("mobile", mobile);
		// sendPostData("http://localhost/wo_security_api/app/v1/flow/order?account="
		// + account + "&t=" + time + "&sign=" + sign);
	}

	public static void sendPostData(String urlStr, Map<String, Object> params) throws Exception {
		StringBuilder sb = new StringBuilder();
		String BOUNDARY = "----WebKitFormBoundaryT1HoybnYeFOGFlBR";
		/**
		 * 普通的表单数据
		 */
		for (String key : params.keySet()) {
			sb.append("--" + BOUNDARY + "\r\n");
			sb.append("Content-Disposition: form-data; name=\"" + key + "\"" + "\r\n");
			sb.append("\r\n");
			sb.append(params.get(key) + "\r\n");
		}
		sb.replace(sb.lastIndexOf("\r\n"), sb.length(), "");
		byte[] headerInfo = sb.toString().getBytes("UTF-8");
		byte[] endInfo = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("UTF-8");
		System.out.println(sb.toString());
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "form-data; boundary=" + BOUNDARY);
		conn.setDoOutput(true);

		OutputStream out = conn.getOutputStream();
		out.write(headerInfo);
		out.write(endInfo);

		if (conn.getResponseCode() == 200) {
			System.out.println("请求成功");
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}

	public static void sendPostData(String urlStr) throws Exception {
		StringBuilder sb = new StringBuilder();
		String BOUNDARY = "----WebKitFormBoundaryT1HoybnYeFOGFlBR";

		// sb.replace(sb.lastIndexOf("\r\n"), sb.length(), "");
		byte[] headerInfo = sb.toString().getBytes("UTF-8");
		byte[] endInfo = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("UTF-8");
		System.out.println("test:" + sb.toString());

		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "form-data; boundary=" + BOUNDARY);
		conn.setDoOutput(true);

		OutputStream out = conn.getOutputStream();
		out.write(headerInfo);
		out.write(endInfo);

		if (conn.getResponseCode() == 200) {
			System.out.println("请求成功");
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line = reader.readLine();
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}

	public static String getServerTime(String urlStr) throws Exception {
		StringBuilder sb = new StringBuilder();
		String BOUNDARY = "----WebKitFormBoundaryT1HoybnYeFOGFlBR";

		// sb.replace(sb.lastIndexOf("\r\n"), sb.length(), "");
		byte[] headerInfo = sb.toString().getBytes("UTF-8");
		byte[] endInfo = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("UTF-8");
		System.out.println(sb.toString());

		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
		conn.setDoOutput(true);

		OutputStream out = conn.getOutputStream();
		out.write(headerInfo);
		out.write(endInfo);

		if (conn.getResponseCode() == 200) {
			System.out.println("请求成功");
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line = reader.readLine();
		JSONObject json = JSONObject.fromObject(line);
		JSONObject result = JSONObject.fromObject(json.get("result"));
		String time = result.get("server_time").toString();
		return time;
	}

}