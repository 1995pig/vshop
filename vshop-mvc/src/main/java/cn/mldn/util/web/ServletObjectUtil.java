package cn.mldn.util.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.mldn.util.upload.FileUploadTools;

public class ServletObjectUtil {
	private static ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal<HttpServletRequest>() ;
	private static ThreadLocal<HttpServletResponse> responseThreadLocal = new ThreadLocal<HttpServletResponse>() ;
	private static ThreadLocal<FileUploadTools> uploadThreadLocal = new ThreadLocal<FileUploadTools>() ;
	private ServletObjectUtil() {} ;
	public static void setUpload(FileUploadTools upload) {
		uploadThreadLocal.set(upload);
	}
	public static void setRequest(HttpServletRequest request) {
		requestThreadLocal.set(request);
	}
	public static void setResponse(HttpServletResponse response) {
		responseThreadLocal.set(response);
	}
	public static void clear() {
		requestThreadLocal.remove(); 
		responseThreadLocal.remove();
		uploadThreadLocal.remove(); 
	}
	public static FileUploadTools getUpload() {
		return uploadThreadLocal.get() ;
	}
	public static HttpServletRequest getRequest() {
		return requestThreadLocal.get() ;
	}
	public static HttpServletResponse getResponse() {
		return responseThreadLocal.get() ;
	}
	public static HttpSession getSession() {
		return requestThreadLocal.get().getSession() ;
	}
	public static ServletContext getServletContext() {
		return requestThreadLocal.get().getServletContext() ;
	}
}
