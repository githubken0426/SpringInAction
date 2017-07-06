package spring.util;
/**
 * 
 * @author 陈爽
 * 开发时间：2010年6月28日
 * 文件下载工具类
 *
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownload {
	/**
	 * 下载文件
	 * 
	 * @param request
	 * @param response
	 * @param src
	 * @param showFileName
	 * @throws ActionCheckedException
	 * @throws Exception
	 */
	public void downloadFile(HttpServletRequest request,
			HttpServletResponse response, File src, String showFileName)
			throws Exception {
		if (src == null || !src.exists() || src.length() == 0) {
			return;
		}
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;
		long fileLength = src.length();
		bis = new BufferedInputStream(new FileInputStream(src));
		String mimeType = request.getSession().getServletContext()
				.getMimeType(src.getName());
		mimeType = (mimeType != null) ? (mimeType)
				: ("application/octet-stream"); // "application/octet-stream"
		response.setContentType(mimeType);
		response.setHeader("Content-disposition", "attachment; filename="
				+ new String(showFileName.getBytes("GBK"), "ISO-8859-1"));// 打开、保存
		response.setHeader("Content-Length", String.valueOf(fileLength));
		bos = new BufferedOutputStream(response.getOutputStream());

		int c;
		byte[] b = new byte[4096];
		while ((c = bis.read(b)) != -1) {
			bos.write(b, 0, c);
		}
		bis.close();
		bos.close();

	}

}
