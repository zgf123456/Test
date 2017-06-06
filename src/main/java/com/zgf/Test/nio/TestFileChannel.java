package com.zgf.Test.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by zgf on 17/6/5.
 * <p>
 * 通道是访问I/O服务的导管，I/O可以分为广义的两大类：File I/O和Stream I/O。
 * 那么相应的，通道也有两种类型，它们是文件（File）通道和套接字（Socket）通道。
 * 文件通道指的是FileChannel，套接字通道则有三个，分别是SocketChannel、ServerSocketChannel和DatagramChannel。
 * <p>
 * 通道可以以多种方式创建。Socket通道可以有直接创建Socket通道的工厂方法
 * ，但是一个FileChannel对象却只能通过在一个打开的RandomAccessFile、FileInputStream或FileOutputStream对象上调用getChannel()方法来获取
 * ，开发者不能直接创建一个FileChannel。
 */
public class TestFileChannel {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/zgf/Documents/temp/rsa_private_key.pem");
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(1024);

        int readLen;
        do {
            readLen = fc.read(bb);
            System.out.println(readLen);
            bb.flip();
            while (bb.hasRemaining()) {
                System.out.print((char) bb.get());
            }
            bb.clear();
        } while (readLen != -1);
        fc.close();
    }
}
