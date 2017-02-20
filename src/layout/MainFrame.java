package layout;

import program.IOHandling;
import program.TimeCount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lenovo on 2017-2-17.
 */
public class MainFrame extends JFrame {

    public MainFrame(){
        Panel panel = new Panel();
        panel.setBounds(0,0,400,400);

        setVisible(true);
        setBounds(400,0,400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);


        setContentPane(new Panel());
    }

    public static void main(String[] args){
        MainFrame mainFrame = new MainFrame();
    }
}

class Panel extends JPanel implements Runnable{

    private static TimeCount timeCount;
    private static IOHandling ioHandling;

    private static JLabel jLabel;

    private static int step;

    public Panel(){
        timeCount = new TimeCount();
        ioHandling = new IOHandling("hh.txt");

        step = 0;

        setVisible(true);
        setLayout(null);

        jLabel = new JLabel(timeCount.getTimeNumber()+"");
        jLabel.setBounds(150,200,200,100);
        jLabel.setFont(new Font("Consolas",1,20));

        JButton jButton = new JButton("start");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeCount.startCountUp();
            }
        });
        jButton.setBounds(50,50,100,50);
        jButton.setVisible(true);
        jButton.setBackground(Color.white);

        this.add(jButton);
        this.add(jLabel);

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (timeCount.getTimeNumber() == 0) {
                step ++;
                String[] currentStep = ioHandling.read(step);
                timeCount.startCountDown(Double.parseDouble(currentStep[0]));
            }
            jLabel.setText(timeCount.getTimeNumber() + "");

        }
    }
}