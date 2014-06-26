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
    private static String floatToBitString(float input) {
        String bitStr = Integer.toBinaryString(Float.floatToIntBits(input));
        //bitStr = String.format("%32s", bitStr).replace(" ","0");
        bitStr = ("00000000000000000000000000000000"+bitStr).substring(Math.min(bitStr.length(), 32));
        return bitStr;
    }
    
    private static float bitStringToFloat(String input) {
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
    
    private static String floatArrayToBitString(float[] input) {
        String str = "";
        for (int i = 0; i < input.length; i++) {
            str += floatToBitString(input[i]);
        }
        return str;
    }
    
    private static float[] bitStringToFloatArray(String input) {
        float[] floats = new float[input.length()/32];
        for (int i = 0; i < floats.length; i++) {
            int endIndex = input.length()-32*i;
            int arrIndex = floats.length - i - 1;
            floats[arrIndex] = bitStringToFloat(input.substring(Math.max(0, endIndex-32), endIndex));
        }
        return floats;
    }
    
    private static String booleanArrayToBitString(boolean[] input) {
        String str = "";
        for (int i = 0; i < input.length; i++) {
            str = (input[i] ? "1" : "0") + str;
        }
        return str;
    }
    
    private static boolean[] bitStringToBooleanArray(String input) {
        boolean[] bools = new boolean[input.length()];
        for (int i = 0; i < bools.length; i++) {
            bools[bools.length - i - 1] = input.charAt(i) == '1';
        }
        return bools;
    }
    
    private static String charStringToBitString(String input) {
        String str = "";
        for (int i = 0; i < input.length(); i++) {
            int charValue = -59 + (int)input.charAt(i);
            String bitStr = Integer.toBinaryString(charValue);
            bitStr = ("00000000"+bitStr).substring(Math.min(bitStr.length()+2, 10));
            str += bitStr;
        }
        
        return str;
    }
    
    private static String bitStringToCharString(String input) {
        String str = "";
        for (int i = 0; i < input.length(); i += 6) {
            int endIndex = input.length() - i;
            int charValue = 59 + Integer.parseInt(input.substring(Math.max(0,endIndex-6), endIndex), 2);
            str = String.valueOf((char)charValue) + str;
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