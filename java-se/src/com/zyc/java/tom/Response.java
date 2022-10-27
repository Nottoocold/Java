package com.zyc.java.tom;

import java.io.*;

/**
 * @author zyc
 * @date 2022/10/15
 */
public class Response {
    private static final int BUFFER_SIZE = 1024;
    Request request;
    OutputStream output;

    private static final String msgHTML = "HTTP/1.1 404 File Not Found\r\n" +
            "Content-Type: text/html\r\n" +
            "Content-Length: 50\r\n" +
            "\r\n" +
            "<h1>File Not Found</h1>";

    public Response(OutputStream output) {
        this.output = output;
    }

    // response中封装了request，以便获取request中的请求参数
    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            // 读取文件内容
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (file.exists()) {
                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, BUFFER_SIZE);
                while (ch != -1) {
                    output.write(bytes, 0, ch);
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                }
            } else {
                // 文件不存在时，输出404信息
                output.write(msgHTML.getBytes());
            }
        } catch (FileNotFoundException e) {
            // thrown if cannot instantiate a File object
            System.out.println(e.getMessage());
        } finally {
            if (fis != null)
                fis.close();
        }
    }
}