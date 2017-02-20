package program;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.lang.String.valueOf;

/**
 * Created by lenovo on 2017-2-19.
 */
public class IOHandling {

    private static InputStream in;
    private static Scanner scanner;
    private static PrintWriter printWriter;

    public IOHandling(String filename){
        try {
            in = new FileInputStream(filename);
        }catch (IOException i){
            System.out.println("File does not exist!");
        }
        scanner = new Scanner(in);
    }

    public static String[] read(int step){
        String[] instructions = {"0","step not found!"};

        //is it the last line?
        while (scanner.hasNext()){
            int xuhao = 0;
            String LineNow = scanner.nextLine();
            //identify step number
            for (int i = 0;i < LineNow.length();i ++) {
                //the end of step number?
                if (LineNow.charAt(i) == ')') {
                    break;
                }else {
                    //continued step number
                    xuhao = xuhao * 10 + Integer.parseInt(valueOf(LineNow.charAt(i)));
                }
            }
            if (xuhao == step) {
                instructions[1] = LineNow;
                break;
            }
        }
        int spaceAmount = 0;
        int timeNumber = 0;
        boolean startReadTime = false;
        for (int i = 0;i < instructions[1].length();i ++) {
            //the end of step number?
            if (instructions[1].charAt(i) == ' ' & spaceAmount == 0) {
                startReadTime = true;
                spaceAmount ++;
                continue;
            }

            if (startReadTime) {
                if (instructions[1].charAt(i) == ' ') {
                    System.out.println("");
                    startReadTime = false;
                    break;
                } else {
                    //continued time number
                    timeNumber = timeNumber * 10 + Integer.parseInt(String.valueOf(instructions[1].charAt(i)));
                }
            }
        }
        instructions[0] = String.valueOf(timeNumber);
        return instructions;
    }

    public static void write(){

    }
}
