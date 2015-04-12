package com.abc.example.sample;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class ByteBufferExample {
	
    public static void testEndian() {
        ByteBuffer bbuf = ByteBuffer.allocate(10);
        
        int capacity = bbuf.capacity(); // 10
        System.out.println(capacity);
      
        bbuf.order(ByteOrder.LITTLE_ENDIAN);
        bbuf.put("java2s.com".getBytes());
      
        System.out.println(Arrays.toString(bbuf.array()));
	}
    
    public static void logo(ByteOrder order) {
        int[] logo = { 0xAABBCCDD, 0x11223344 };
        byte[] logoLE = new byte[logo.length * 4];

        ByteBuffer rec = ByteBuffer.wrap(logoLE).order(order);

        for (int i = 0; i < logo.length; i++)
            rec.putInt(logo[i]);

        // Debug printouts...
        System.out.println("\nlogo:");
        for (int b : logo)
            System.out.println(Integer.toHexString((b < 0 ? b + 256 : b)));

        System.out.println("\nlogoLE:");
        int tmp = 0;
        for (byte b : logoLE) {
            System.out.print(Integer.toHexString((b < 0 ? b + 256 : b)));
            if (++tmp % 4 == 0)
                System.out.println();
        }
    }
    
    public static void main(String[] args) {
    	testEndian();
    	logo(ByteOrder.LITTLE_ENDIAN);
    	logo(ByteOrder.BIG_ENDIAN);
    }
}
