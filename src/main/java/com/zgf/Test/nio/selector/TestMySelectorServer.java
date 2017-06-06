package com.zgf.Test.nio.selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by zgf on 17/6/6.
 *
 *
 *
 * 与没使用NIO之前的区别
 *
 * 1. 没使用NIO
 *  每accept一次，就要new一个线程处理
 *
 * 2. 使用NIO
 *  单一线程即可处理完服务，节省服务器资源。
 *
 *
 */
public class TestMySelectorServer {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(1234));
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("register keys " + selector.keys());

        while (true) {
            int selectNum = selector.select();
            if (selectNum == 0) {
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();

                    SocketChannel socketChannel = channel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    buffer.clear();
                    while (socketChannel.read(buffer) > 0) {
                        buffer.flip();
                        while (buffer.hasRemaining()) {
                            System.out.print((char) buffer.get());
                        }
                        System.out.println();
                        buffer.clear();
                    }
                }
//                else if (!selectionKey.isConnectable()) {
//                    selectionKey.cancel();
//                }
                iterator.remove();
            }
        }
    }
}
