package com.darling.auto.utils;

/**
 * @description:
 * @author: dll
 * @date: Created in 2021/11/9 16:39
 * @version:
 * @modified By:
 */
public class AAA {


    public static void main(String[] args) throws Exception {
        String sessId = "pdxhsoebmmgcrmng5efi4tjx9dp5f27j";
        String encrypt = DES.encrypt(sessId);
        System.out.println("encrypt = " + encrypt);
    }

}
