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

    public static String read(int step){
        String instruction = "step not found!";

        //is it the last line?
        while (scanner.hasNext()){
            int xuhao = 0;
            String LineNow = scanner.nextLine();
            //identify step number
            for (int i = 0;i < LineNow.length();i ++) {
                //the end of step number?
                if (LineNow.charAt(i) == ')') {
                    System.out.println("");
                    break;
                }else {
                    //continued step number
                    System.out.print(xuhao);
                    xuhao = xuhao * 10 + Integer.parseInt(valueOf(LineNow.charAt(i)));
                }
            }
            if (xuhao == step) {
                instruction = LineNow;
                break;
            }
        }
        return instruction;
    }

    public static void write(){

    }
}
