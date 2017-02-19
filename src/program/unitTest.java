package program;

import java.io.IOException;

/**
 * Created by lenovo on 2017-2-19.
 */
public class unitTest {

    public static void main(String[] args) throws IOException {
        IOHandling ioHandling = new IOHandling("hh.txt");
        String instruction = ioHandling.read(13);
        System.out.println(instruction);
    }
}
