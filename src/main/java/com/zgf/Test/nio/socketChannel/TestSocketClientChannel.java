package com.zgf.Test.nio.socketChannel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by zgf on 17/6/6.
 */
public class TestSocketClientChannel {
    private static final String STR = "Hello World!";
    private static final String REMOTE_IP = "127.0.0.1";

    public static void main(String[] args) throws Exception {
        final int port = 1234;

        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        sc.connect(new InetSocketAddress(REMOTE_IP, port));
        while (!sc.finishConnect()) {
            System.out.println("同" + REMOTE_IP + "的连接正在建立，请稍等！");
            Thread.sleep(10);
        }
        System.out.println("连接已建立，待写入内容至指定ip+端口！时间为" + System.currentTimeMillis());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    String str = STR + System.currentTimeMillis();
                    ByteBuffer bb = ByteBuffer.allocate(str.length());
                    bb.put(str.getBytes());
                    bb.flip(); // 写缓冲区的数据之前一定要先反转(flip)
                    System.out.println("write " + str);
                    sc.write(bb);
                    bb.clear();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        int threadCount = 5;
        Thread[] nbsts = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            nbsts[i] = new Thread(runnable);
        }

        for (int i = 0; i < threadCount; i++) {
            nbsts[i].start();
        }

        // 一定要join保证线程代码先于sc.close()运行，否则会有AsynchronousCloseException
        for (int i = 0; i < threadCount; i++) {
            nbsts[i].join();
        }

        sc.close();
    }
}
