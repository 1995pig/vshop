package cn.mldn.util.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.fileupload.FileItem;

import cn.mldn.util.upload.FileUploadTools;
import cn.mldn.util.web.ServletObjectUtil;

public class ActionUploadUtil {
	private String dir ;	// 定义文件的保存目录
	private String singleFileName ;	// 保存单个的上传文件名称
	private Set<String> multiFileName  ;
	private FileUploadTools uploadTools = ServletObjectUtil.getUpload() ;	// 取得SmartUpload组件
	public ActionUploadUtil(String dir) {	// 不同的Action保存图片的位置是不同的
		this.dir = dir ;
	}
	public String createSingleFileName() throws Exception {	// 是获取一个上传文件的自动命名
		if (this.uploadTools.getUploadFiles().size() > 0) {	// 有文件上传
			this.singleFileName = (String) this.createMultiFileName().toArray()[0] ;
			return this.singleFileName ;
		} else {
			return "nophoto.jpg" ;	// 表示没有图片
		}
	}
	public Set<String> createMultiFileName() throws Exception {
		this.multiFileName = new HashSet<String>() ;
		if (this.uploadTools.getUploadFiles().size() > 0) {
			Iterator<Map.Entry<String, FileItem>> iter = this.uploadTools.getUploadFiles().entrySet().iterator() ;
			while(iter.hasNext()) {
				this.multiFileName.add(iter.next().getKey()) ;
			}
		} else {
			this.multiFileName.add("nophoto.jpg") ;
		}
		return this.multiFileName ;
	}
	public void saveMultiFile() throws Exception {
		this.uploadTools.saveAll(ServletObjectUtil.getServletContext().getRealPath("/" + this.dir + "/")) ;
	}
	public void saveSingleFile() throws Exception {	// 保存单独文件
		this.uploadTools.saveAll(ServletObjectUtil.getServletContext().getRealPath("/" + this.dir + "/")) ;
	}
	public boolean isUpload() throws Exception {	// 判断是否有文件上传
		return this.uploadTools.getUploadFiles().size() > 0 ;
	}
}
