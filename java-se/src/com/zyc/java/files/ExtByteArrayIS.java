package com.zyc.java.files;

import java.io.ByteArrayInputStream;

/**
 * @author zyc
 * @date 2022/10/16
 */
public class ExtByteArrayIS extends ByteArrayInputStream {

    public ExtByteArrayIS(byte[] buf) {
        super(buf);
    }

    public ExtByteArrayIS(byte[] buf, int offset, int length) {
        super(buf, offset, length);
    }

    public int getMark() {
        return mark;
    }

    public int getPos() {
        return pos;
    }
}
