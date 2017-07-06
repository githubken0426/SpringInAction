package spring.util;

import java.io.File;
import java.io.IOException;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 上传文件
 * 
 * @author Administrator
 *
 * 2016-6-24 下午01:52:51
 */
public final class FileUpload {
	
	/**
	 * fileUpload方式上传文件
	 * 
	 * @param request
	 * @param imgFile
	 * @param fileName
	 * @throws IOException
	 */
	public static void fileUpload(MultipartHttpServletRequest request,CommonsMultipartFile imgFile,String fileName) throws IOException{
//		CommonsMultipartFile  imgFile  = (CommonsMultipartFile)request.getFile(param);
		//获得文件名
//		String fileName = imgFile.getOriginalFilename();
		System.out.println("上传文件大小:"+imgFile.getSize());
		//判断上传文件是否为空
		if(imgFile != null && !imgFile.isEmpty()){
			String path = request.getSession().getServletContext().getRealPath("/");
			path+="resources"+File.separator+"profileImg"+File.separator;
			System.out.println("保存文件的目录："+path);
			//判断所需目录 是否存在 如果不存在 新建一个目录
			File filePath = new File(path);
			if (filePath.mkdirs()) {
				System.out.println("mkdirs方法创建目录成功");
			} else {
				System.out.println("mkdirs方法创建目录失败");
			}
		    //生成文件
			File file = new File(path + File.separator+fileName);
			try {
				//保存新文件
				FileCopyUtils.copy(imgFile.getBytes(), file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
