package com.zyc.java.files;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author zyc
 * @date 2022/10/16
 */
public class BufT {
    private static final Logger log = Logger.getLogger(BufT.class.getName());

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("src/fil.txt");
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            byte[] bytes = new byte[bis.available()];
            int read = bis.read(bytes, 0, 2);
            bis.mark(read);
            System.out.println("读取到的内容：" + new String(bytes, 0, read) + ", 读取到的字节数：" + read);
        } catch (IOException e) {
            log.warning(e.getMessage());
        }
    }
}
