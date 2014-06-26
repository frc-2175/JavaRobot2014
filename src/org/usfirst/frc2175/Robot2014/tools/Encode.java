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
        return Integer.toBinaryString(Float.floatToIntBits(input));
    }
    
    private static float bitStringToFloat(String input) {
        return Float.intBitsToFloat(Integer.parseInt(input, 2));
    }
    
    private static String floatArrayToBitString(float[] input) {
        String str = "";
        for (int i = 0; i < input.length; i++) {
            str += floatToBitString(input[i]);
        }
        return str;
    }
    
    private static float[] bitStringToFloatArray(String input) {
        float[] floats = new float[input.length()/8];
        for (int i = 0; i < floats.length; i++) {
            floats[i] = bitStringToFloat(input.substring(i*8, i*8+7));
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
            bools[i] = input.charAt(i) == "1".charAt(0);
        }
        return bools;
    }
    
    private static String charStringToBitString(String input) {
        String str = "";
        for (int i = 0; i < input.length(); i++) {
            int charValue = -59 + input.charAt(i);
            str += Integer.toBinaryString(charValue).substring(2);
        }
        return str;
    }
    
    private static String bitStringToCharString(String input) {
        String str = "";
        for (int i = 0; i < input.length(); i += 6) {
            int charValue = 59 + Integer.parseInt(input.substring(i, i+5), 2);
            str += Integer.valueOf(charValue).toString();
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
        
        DecodedInfo(boolean[] bools, float[] floats) {
            this.bools = bools;
            this.floats = floats;
        }
    }
    
    public static DecodedInfo decode(String input) {
        int splitIndex = input.lastIndexOf("#".charAt(0));
        String boolCharStr = input.substring(0, splitIndex);
        String floatCharStr = input.substring(splitIndex + 1);
        String boolBitStr = charStringToBitString(boolCharStr);
        String floatBitStr = charStringToBitString(floatCharStr);
        boolean[] bools = bitStringToBooleanArray(boolBitStr);
        float[] floats = bitStringToFloatArray(floatBitStr);
        return new DecodedInfo(bools, floats);
    }
}