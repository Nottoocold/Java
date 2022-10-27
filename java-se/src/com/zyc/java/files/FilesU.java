package com.zyc.java.files;

import java.io.*;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class FilesU {

    /**
     * 写入文件
     */
    public void fw() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("first.txt"))) {
            bw.write("我好帅");
            System.out.println("写入成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 读取文件
     */
    public void fr() {
        try (BufferedReader br = new BufferedReader(new FileReader("first.txt"))) {
            String ret;
            while ((ret = br.readLine()) != null) {
                System.out.println(ret);
                System.out.println("读取成功");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 删除文件
     */
    public void deleteFile() {
        File file = new File("first.txt");
        if (file.delete()) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    /**
     * 搬运文件
     *
     * @param src  源文件
     * @param dest 目的文件
     */
    public void transfer(String src, String dest) {
        File srcFile = new File(src);
        File desrFile = new File(dest);
        if (srcFile.exists()) {
            try (BufferedReader bReader = new BufferedReader(new FileReader(srcFile));
                 BufferedWriter bWriter = new BufferedWriter(new FileWriter(desrFile))) {
                String info = null;
                while ((info = bReader.readLine()) != null) {
                    bWriter.write(info);
                    bWriter.newLine();
                }
            } catch (FileNotFoundException e) {
                System.out.println("文件没找到" + e.getMessage());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * 创建临时文件
     *
     * @param p
     * @param s
     */
    public void createTempFile(String p, String s) {
        try {
            File temp = File.createTempFile(p, s);
            System.out.println("文件路径 " + temp.getAbsolutePath());
            BufferedWriter out = new BufferedWriter(new FileWriter(temp));
            out.write("aString");
            System.out.println("临时文件已创建");
            temp.deleteOnExit();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fastCopy(String src, String dest) {
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest);) {
            FileChannel fcin = fis.getChannel();
            FileChannel fcout = fos.getChannel();
            ByteBuffer buf = ByteBuffer.allocateDirect(1024);
            while (true) {
                int len = fcin.read(buf);
                if (len == -1)
                    break;
                buf.flip();
                fcout.write(buf);
                buf.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void selector() {
        try (Selector selector = Selector.open();
             ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();) {
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT | SelectionKey.OP_WRITE);
            ServerSocket socket = serverSocketChannel.socket();

            selector.select(e -> {
                if (e.isAcceptable()) {
                    System.out.println(e);
                } else if (e.isReadable()) {
                    System.out.println(e);
                } else if (e.isConnectable()) {
                    System.out.println(e);
                } else {
                    System.out.println(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
