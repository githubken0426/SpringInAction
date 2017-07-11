package org.ken.fsd.util;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

public class GeneratorSignUtil {

	private static Logger logger = Logger.getLogger(GeneratorSignUtil.class);

	/**
	 * 生成签名
	 * 
	 * @param request
	 * @param token
	 * @return
	 */
	public static String generateSign(HttpServletRequest request,
			String timestamp, String key) {
		try {
			String url = request.getRequestURL().toString();
			String input = url + timestamp + key;
			logger.debug("url-> " + input);
			return DigestUtils.md5Hex(input.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 生成签名
	 * 
	 * @param account
	 * @param timestamp
	 * @param key
	 * @return 2017-1-19 上午10:21:04
	 */
	public static String generateSign(String timestamp, String partnerId,
			String secretKey, String mobile, String apiId, String productid) {
		try {
			String input = timestamp + partnerId + secretKey + mobile + apiId
					+ productid;
			logger.debug("input-> " + input);
			return DigestUtils.md5Hex(input.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 生成联通签名
	 * 
	 * @param account
	 * @param timestamp
	 * @param key
	 * @return 2017-1-19 上午10:21:04
	 */
	public static String generateWoSign(String param) {
		try {
			logger.debug("params-> " + param);
			return DigestUtils.md5Hex(param.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String generateTokenFor16(String userName) {
		return generateToken(userName).substring(8, 24);
	}

	/**
	 * md5加密
	 * 
	 * @param parm
	 * @return
	 */
	public static String gernateToMD5(String parm) {
		return DigestUtils.md5Hex(parm);
	}

	public static String stringCap(String str) {
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	/**
	 * 生成token
	 * 
	 * @param userName
	 * @return
	 */
	public static String generateToken(String userName) {
		return DigestUtils.md5Hex(userName + System.currentTimeMillis());
	}

	public static String generateUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}