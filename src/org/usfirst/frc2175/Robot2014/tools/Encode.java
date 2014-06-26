package org.usfirst.frc2175.Robot2014.tools;

/**
 * Encode.java
 * 
 * This class mirrors the encode.py module used on the tablet side
 * (which runs Python, not Java)
 * 
 * @author aren
 */
public class Encode {
    public static String floatToBitString(float input) {
        String bitStr = Integer.toBinaryString(Float.floatToIntBits(input));
        //bitStr = String.format("%32s", bitStr).replace(" ","0");
        bitStr = ("00000000000000000000000000000000"+bitStr).substring(Math.min(bitStr.length(), 32));
        return bitStr;
    }
    
    public static float bitStringToFloat(String input) {
        // Integer.parseInt() doesn't handle 2s complement properly >:(
        // hence this hack
        if (input.length() > 31) {
            char signBit = input.charAt(input.length()-32);
            String newInput = input.substring(input.length()-31);
            int intBits = Integer.parseInt(newInput, 2);
            if (signBit == '1') intBits += Integer.MIN_VALUE;
            return Float.intBitsToFloat(intBits);
        }
        else return Float.intBitsToFloat(Integer.parseInt(input, 2));
    }
    
    public static String floatArrayToBitString(float[] input) {
        String str = "";
        for (int i = 0; i < input.length; i++) {
            str += floatToBitString(input[i]);
        }
        return str;
    }
    
    public static float[] bitStringToFloatArray(String input) {
        float[] floats = new float[input.length()/32];
        for (int i = 0; i < floats.length; i++) {
            floats[i] = bitStringToFloat(input.substring(i*32, (i+1)*32));
        }
        return floats;
    }
    
    private static String booleanArrayToBitString(boolean[] input) {
        String str = "";
        for (int i = 0; i < input.length; i++) {
            str += input[i] ? "1" : "0";
        }
        return str;
    }
    
    private static boolean[] bitStringToBooleanArray(String input) {
        boolean[] bools = new boolean[input.length()];
        for (int i = 0; i < bools.length; i++) {
            bools[i] = input.charAt(i) == '1';
        }
        return bools;
    }
    
    public static String charStringToBitString(String input) {
        String str = "";
        for (int i = 0; i < input.length(); i++) {
            int charValue = -59 + (int)input.charAt(i);
            String bitStr = Integer.toBinaryString(charValue);
            bitStr = ("00000000"+bitStr).substring(Math.min(bitStr.length()+2, 10));
            //System.out.println(charValue);
            //System.out.println(bitStr);
            str += bitStr;
        }
        
        //System.out.println(str);
        
        return str;
    }
    
    public static String bitStringToCharString(String input) {
        String str = "";
        for (int i = 0; i < input.length(); i += 6) {
            int charValue = 59 + Integer.parseInt(input.substring(i, Math.min(i+6,input.length())), 2);
            System.out.println(charValue);
            str += String.valueOf((char)charValue);
        }
        return str;
    }
    
    public static String encode(boolean[] bools, float[] floats) {
        String boolStr = bitStringToCharString(booleanArrayToBitString(bools));
        String floatStr = bitStringToCharString(floatArrayToBitString(floats));
        return boolStr + "#" + floatStr;
    }
    
    public static class DecodedInfo {
        public boolean[] bools;
        public float[] floats;
        
        public DecodedInfo(boolean[] bools, float[] floats) {
            this.bools = bools;
            this.floats = floats;
        }
    }
    
    public static DecodedInfo decode(String input) {
        int splitIndex = input.lastIndexOf('#');
        String boolCharStr = input.substring(0, splitIndex);
        String floatCharStr = input.substring(splitIndex+1);
        String boolBitStr = charStringToBitString(boolCharStr);
        String floatBitStr = charStringToBitString(floatCharStr);
        boolean[] bools = bitStringToBooleanArray(boolBitStr);
        float[] floats = bitStringToFloatArray(floatBitStr);
        return new DecodedInfo(bools, floats);
    }
}