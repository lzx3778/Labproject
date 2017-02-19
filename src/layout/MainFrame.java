package layout;

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

    private static JLabel jLabel;

    public Panel(){
        timeCount = new TimeCount();
        setVisible(true);
        setLayout(null);

        jLabel = new JLabel(timeCount.getTimeNumber()+"");
        jLabel.setBounds(150,200,200,100);
        jLabel.setFont(new Font("Consolas",1,20));

        JButton jButton = new JButton("up");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeCount.startCountUp();
            }
        });
        jButton.setBounds(50,50,100,50);
        jButton.setVisible(true);
        jButton.setBackground(Color.white);

        JButton jButton2 = new JButton("down");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeCount.startCountDown(timeCount.getTimeNumber());
            }
        });
        jButton2.setBounds(50,100,100,50);
        jButton2.setVisible(true);
        jButton2.setBackground(Color.white);

        JButton jButton3 = new JButton("stop");
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeCount.stop();
            }
        });
        jButton3.setBounds(50,150,100,50);
        jButton3.setVisible(true);
        jButton3.setBackground(Color.white);

        this.add(jButton);
        this.add(jButton2);
        this.add(jButton3);
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
            jLabel.setText(timeCount.getTimeNumber()+"");
        }
    }
}