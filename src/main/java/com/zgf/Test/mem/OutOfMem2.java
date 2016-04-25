package com.zgf.Test.mem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class OutOfMem2 implements Runnable {

	// java opts
	// 内存800M 此参数不能调整.
	// -Xms800m -Xmx800m

	// 以下仅供参考.可以随意发挥
	// -server -Xms800m -Xmx800m -XX:PermSize=64M -XX:MaxNewSize=256m
	// -server -Xms800m -Xmx800m -XX:PermSize=32M -XX:MaxNewSize=128m
	// -XX:MaxTenuringThreshold=15

	// count:15000000
	// count:14500000
	// count:13500000
	// count:13000000
	// count:12500000
	// count:12000000
	// count:10000000
	// count:12583595
	// count:13729922
	// count:11443503
	// count:12511443
	// count:9262474
	// count:13585677

	public AtomicLong counts;

	public OutOfMem2(AtomicLong counts) {
		this.counts = counts;
	}

	public static void main(String[] args) throws InterruptedException {
		AtomicLong counts = new AtomicLong(0);
		List<Thread> tList = new ArrayList<Thread>();
		for (int i = 0; i < 5; i++) {
			OutOfMem2 kill = new OutOfMem2(counts);
			Thread t = new Thread(kill);
			t.start();
			tList.add(t);
		}
		for (int i = 0; i < tList.size(); i++) {
			tList.get(i).join();
		}
		System.out.println("count:" + counts.longValue());
	}

	@Override
	public void run() {
		long start = System.currentTimeMillis();
		int k = 0;
		while (true) {
			k++;
			System.out.println("times:" + (System.currentTimeMillis() - start));
			List<String> outOfMemList = new ArrayList<String>(500000);
			int flag = 0;
			Long start2 = System.currentTimeMillis();
			for (int j = 0; j < 500000; j++) {
				if (System.currentTimeMillis() - start >= 1000 * 60) {
					flag = 1;
					break;
				}
				counts.incrementAndGet();

				outOfMemList.add(new String(new Date().toLocaleString()) + new String(new Date().toLocaleString())
						+ new String(new Date().toLocaleString()));
				if (j % 100000 == 0) {
					// System.out.println(threadLocal.get());
					System.out.println(k + "|" + "list-size:" + outOfMemList.size());
					System.out.println(k + "|" + "run :" + j);
				}

			}
			System.out.println("for:" + (System.currentTimeMillis() - start2));
			if (flag == 1) {
				break;
			}
		}
		// System.out.println("thread-exit-" +
		// Thread.currentThread().getName());
	}

}