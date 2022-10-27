package com.zyc.java;

import com.zyc.java.files.dir.DirU;

/**
 * @author zyc
 * @date 2022/10/23
 */
public class FactoryImpl extends Factory<DirU> {

    @Override
    public DirU get() {
        return new DirU();
    }
}
