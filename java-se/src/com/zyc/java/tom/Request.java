package com.zyc.java.tom;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zyc
 * @date 2022/10/15
 */
public class Request {
    private InputStream in;
    private String uri;

    public Request(InputStream in) {
        this.in = in;
    }

    public void parse() {
        StringBuffer req = new StringBuffer(2048);
        int len;
        byte[] bytes = new byte[1024];
        try {
            len = in.read(bytes);
        } catch (IOException e) {
            len = -1;
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < len; i++) {
            req.append((char) bytes[i]);
        }
        System.out.println(req);
        uri = parseUri(req.toString());
    }

    private String parseUri(String reqUri) {
        int i1, i2;
        i1 = reqUri.indexOf(" ");
        if (i1 != -1) {
            i2 = reqUri.indexOf(" ", i1 + 1);
            if (i2 > i1) {
                return reqUri.substring(i1 + 1, i2);
            }
        }
        return null;
    }

    public String getUri() {
        return uri;
    }
}
