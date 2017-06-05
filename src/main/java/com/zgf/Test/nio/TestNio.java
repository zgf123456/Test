package com.zgf.Test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

public class TestNio {
	public static void main(String[] args) throws IOException {
		System.out.printf("aaa");
		InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8080);
		SocketChannel socketChannel = SocketChannel.open(inetSocketAddress);

		System.out.printf("bbb");

		ByteBuffer buffer = ByteBuffer.allocate(74);
		WritableByteChannel writableByteChannel = Channels.newChannel(System.out);

		System.out.printf("ccc");
		while(socketChannel.read(buffer) != -1) {
			System.out.printf("sdddddd");
			buffer.flip();
			writableByteChannel.write(buffer);
			buffer.clear();
		}
		System.out.printf("ddd");
	}
}
