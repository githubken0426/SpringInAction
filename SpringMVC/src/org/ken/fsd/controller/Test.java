package org.ken.fsd.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import net.sf.json.JSONObject;

public class Test {
	static String add_url = "http://localhost:8089/SpringMVC/v1/open/json/find";

	public static void main(String[] args) throws IOException {
		testRequestBody();
	}

	public static void testRequestBody() {
		DataOutputStream out = null;
		try {
			URL url = new URL(add_url);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.connect();

			out = new DataOutputStream(connection.getOutputStream());
			JSONObject obj = new JSONObject();
			obj.put("id", "S001");
			obj.put("ownerId", "A1002");
			obj.put("nickname", "msg");
			
			String param=obj.toString();
			URLEncoder.encode(param,"utf-8");
			out.writeBytes(param);
			
			if (connection.getResponseCode() == 200) {
				System.out.println("请求成功");
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = reader.readLine();
			JSONObject json = JSONObject.fromObject(line);
			JSONObject result = JSONObject.fromObject(json.get("result"));
			
			System.out.println(result.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
