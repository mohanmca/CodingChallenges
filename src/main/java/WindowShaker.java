import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Collections;

public class WindowShaker {
    public static void main(String[] args) throws InterruptedException, AWTException, FileNotFoundException {

        setSystemErrorToFile();
        Frame frame = new Frame();
        frame.add(new TextArea(), BorderLayout.CENTER);
        frame.setSize(300,200);
        frame.setVisible(true);
        Robot r = new Robot();
        do {
            r.keyPress(KeyEvent.VK_SHIFT);
            r.keyRelease(KeyEvent.VK_SHIFT);
            Thread.sleep(40000);
        } while(true);
    }
    public static void setSystemErrorToFile() throws FileNotFoundException {
        OutputStream output = new FileOutputStream("output.txt");
        PrintStream pout = new PrintStream(output);
        System.setErr(pout);

    }
}
