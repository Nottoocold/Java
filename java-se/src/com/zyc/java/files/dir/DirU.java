package com.zyc.java.files.dir;

import java.io.File;

public class DirU {

	/**
	 * 递归创建目录
	 * 
	 * @param path
	 */
	public void mkdirs(String path) {
		if (path != null && !path.isEmpty() && !path.isBlank()) {
			File dict = new File(path);
			boolean mkdirs = dict.mkdirs();
			System.out.println(mkdirs);
		}
	}
	
	/**
	 * 删除目录
	 * @param dir
	 * @return
	 */
	public boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		if (dir.delete()) {
			System.out.println("目录已被删除！");
			return true;
		} else {
			System.out.println("目录删除失败！");
			return false;
		}
	}
	
	/**
	 * 列出指定路径下的文件
	 * @param path
	 */
	public void list(String path) {
		File dirFile = new File(path);
		if (!dirFile.exists()) {
			System.out.println("文件不存在");
			return;
		}
		list(dirFile);
		
	}
	
	private void list(File dir) {
		System.out.println(dir);
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                list(new File(dir, children[i]));
            }
        }
	}
	
	
}
