package com.abc.example;

public class BinaryCheck {
	 
    public static boolean isBinaryNumber(int binary){
    	if (binary == 0)
    		return true;
         
        boolean status = true;
        String str = String.valueOf(binary);
        
        for (int i=0; i<str.length(); i++){
            int tmp = binary%10;
            if(tmp != 0 && tmp != 1){
                status = false;
                break;
            }
            binary = binary/10;
        }
        return status;
    }
     
    public static void main(String a[]){
        BinaryCheck mbc = new BinaryCheck();
        System.out.println("Is 1 binary? : "+ isBinaryNumber(1));
        System.out.println("Is 2 binary? : "+ isBinaryNumber(2));
        System.out.println("Is 1000111 binary? : "+ isBinaryNumber(1000111));
        System.out.println("Is 10300111 binary? :" + isBinaryNumber(10300111));
        System.out.println("Is 4000111 binary? :" + isBinaryNumber(4000111));
    }
}
