package com.monkeyc.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestBufferedReader {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("键盘");
            String line = reader.readLine();
            System.out.println(line);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
