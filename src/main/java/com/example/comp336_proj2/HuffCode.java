package com.example.comp336_proj2;

public class HuffCode implements Comparable<HuffCode> {

    char huffChar;
    int frequency;
    String huffCode;
    int codeLength;

    public HuffCode(char huffChar) {
        this.huffChar = huffChar;
    }

    public HuffCode(char huffChar, int frequency) {
        this.huffChar = huffChar;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "HuffCode{" + "character=" + (int) huffChar + ", counter=" + frequency + ", huffCode=" + huffCode
                + ", codeLength=" + codeLength + '}';
    }

    @Override
    public int compareTo(HuffCode t) {
        return huffCode.compareTo(t.huffCode);
    }

}
