package com.zgf.Test.nio.socketChannel;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by zgf on 17/6/6.
 * <p>
 * 上文讲述了通道、文件通道，这篇文章来讲述一下Socket通道，Socket通道与文件通道有着不一样的特征，分三点说：
 * <p>
 * 1、NIO的Socket通道类可以运行于非阻塞模式并且是可选择的，这两个性能可以激活大程序（如网络服务器和中间件组件）
 * 巨大的可伸缩性和灵活性，因此，再也没有为每个Socket连接使用一个线程的必要了。这一特性避免了管理大量线程所需的上下文交换总开销
 * ，借助NIO类，一个或几个线程就可以管理成百上千的活动Socket连接了并且只有很少甚至没有性能损失
 * <p>
 * 2、全部Socket通道类（DatagramChannel、SocketChannel和ServerSocketChannel）在被实例化时都会创建一个对应的Socket对象
 * ，就是我们所熟悉的来自java.net的类（Socket、ServerSocket和DatagramSocket）
 * ，这些Socket可以通过调用socket()方法从通道类获取，此外，这三个java.net类现在都有getChannel()方法
 * <p>
 * 3、每个Socket通道（在java.nio.channels包中）都有一个关联的java.net.socket对象，反之却不是如此
 * ，如果使用传统方式（直接实例化）创建了一个Socket对象，它就不会有关联的SocketChannel并且它的getChannel()方法将总是返回null
 * <p>
 * 概括地讲，这就是Socket通道所要掌握的知识点知识点，不难，记住并通过自己写代码/查看JDK源码来加深理解。
 */
public class TestSocketServerChannel {
    public static void main(String[] args) throws Exception {
        int port = 1234;
        if (args != null && args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ServerSocket ss = ssc.socket();
        ss.bind(new InetSocketAddress(port));
        System.out.println("开始等待客户端的数据！时间为" + System.currentTimeMillis());
        while (true) {
            SocketChannel sc = ssc.accept();
            if (sc == null) {
                // 如果当前没有数据，等待1秒钟再次轮询是否有数据，在学习了Selector之后此处可以使用Selector
                Thread.sleep(1000);
            } else {
                System.out.println("客户端已有数据到来，客户端ip为:" + sc.socket().getRemoteSocketAddress()
                        + ", 时间为" + System.currentTimeMillis());
                ByteBuffer bb = ByteBuffer.allocate(1024);
                sc.read(bb);
                bb.flip();
                while (bb.hasRemaining()) {
                    System.out.print((char) bb.get());
                }
                System.out.println();
//                sc.close();
//                System.exit(0);
            }
        }
    }
}
