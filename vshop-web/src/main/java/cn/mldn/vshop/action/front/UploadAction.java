package cn.mldn.vshop.action.front;

import cn.mldn.util.action.ActionUploadUtil;

public class UploadAction {
	public void upload(String ename) throws Exception {
		System.out.println("***************** ename = " + ename);
		ActionUploadUtil auu = new ActionUploadUtil("upload/emp") ;
		System.out.println(auu.createSingleFileName());
		auu.saveSingleFile(); 	// 文件保存
	}
}
