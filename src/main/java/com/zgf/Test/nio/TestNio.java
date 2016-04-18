package com.zgf.Test.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

public class TestNio {
	public static void main(String[] args) throws IOException {
		// RandomAccessFile file = new RandomAccessFile("/Users/zgf/Documents/work/前端应用组文档/10线上巡检日志/2016-04-14/sql.longtime.0414.log", "r");
//		FileInputStream fin = new FileInputStream(new File("/Users/zgf/Documents/work/前端应用组文档/10线上巡检日志/2016-04-14/sql.longtime.0414.log"));
//		FileChannel inChannel = fin.getChannel();
//		ByteBuffer buf = ByteBuffer.allocate(32);
//		int read = inChannel.read(buf);
//		
//		while(read != -1){
//			buf.flip();
//			
//			while(buf.hasRemaining()){
//				System.out.print(buf.getChar());
//			}
//			System.out.println();
//			buf.putChar('a');
//			buf.clear();
//			read  = inChannel.read(buf);
//		}
		
		Selector.open();
	}
}
