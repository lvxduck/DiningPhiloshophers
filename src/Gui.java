import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Gui extends JFrame{
    private static final long serialVersionUID = 1L;
    JPanel mainPanel;
    ArrayList<JLabel> listPhilo = new ArrayList<>();
    ArrayList<JLabel> listChop = new ArrayList<>();

    public Gui() {
        this.setTitle("5 triet gia an toi");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 969, 660);
        this.setSize(800,500);

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        mainPanel.setLayout(null);
        setContentPane(mainPanel);

        final int[][] philoPoss = {{350,55},{150,180},{250, 315},{450, 315},{550, 180}};
        for(int i=1; i<=5; i++){
            JLabel philo=new JLabel("Triết gia " + i);
            philo.setOpaque(true);
            philo.setBounds(philoPoss[i-1][0],philoPoss[i-1][1] , 100, 70);
            philo.setForeground(Color.WHITE);
            philo.setBackground(Color.BLACK);
            philo.setHorizontalAlignment(SwingConstants.CENTER);
            philo.setFont(new Font("Arial", Font.BOLD, 12));
            listPhilo.add(philo);
            mainPanel.add(philo);
        }

        final int[][] chopstickPoss = {{220, 140},{200, 270},{360, 331},{500, 270},{500, 145}};
        for(int i=1; i<=5; i++){
            JLabel chop1 = new JLabel("Đũa " + i);
            chop1.setBackground(Color.pink);
            chop1.setOpaque(true);
            chop1.setHorizontalAlignment(SwingConstants.CENTER);
            chop1.setBounds(chopstickPoss[i-1][0], chopstickPoss[i-1][1], 66, 27);
            listChop.add(chop1);
            mainPanel.add(chop1);
        }

        JLabel eatingLabel = new JLabel("EATING: ");
        eatingLabel.setBackground(Color.white);
        eatingLabel.setOpaque(true);
        eatingLabel.setBounds(60, 10,57, 15);
        mainPanel.add(eatingLabel);

        JLabel eatingColor = new JLabel();
        eatingColor.setBackground(Color.red);
        eatingColor.setOpaque(true);
        eatingColor.setBounds(125, 10,30, 15);
        mainPanel.add(eatingColor);

        JLabel thinkingLabel = new JLabel("THINKING: ");
        thinkingLabel.setBackground(Color.white);
        thinkingLabel.setOpaque(true);
        thinkingLabel.setBounds(60, 36,66, 15);
        mainPanel.add(thinkingLabel);

        JLabel thinkingColor = new JLabel();
        thinkingColor.setBackground(Color.BLACK);
        thinkingColor.setOpaque(true);
        thinkingColor.setBounds(125, 36,30, 15);
        mainPanel.add(thinkingColor);
    }
    public void PhilosopherEating (int i) {
        listPhilo.get(i-1).setBackground(Color.red);
    }

    public void PhilosopherThinking (int i) {
        listPhilo.get(i-1).setBackground(Color.black);
    }

    public void philosopherPickRightFork (int i) {
        listChop.get(i-1).setBackground(Color.red);
    }

    public void philosopherPickLeftFork (int i) {
        listChop.get((i-2+5)%5).setBackground(Color.red);
    }

    public void philosopherPutDownRightFork (int i) {
        listChop.get(i-1).setBackground(Color.pink);
    }

    public void philosopherPutDownLeftFork (int i) {
        listChop.get((i-2+5)%5).setBackground(Color.pink);
    }
}
