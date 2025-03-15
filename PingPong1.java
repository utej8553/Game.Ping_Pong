import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PingPong1 extends JPanel implements ActionListener, KeyListener {
    private int compX = 250, compY = 250;
    private int DirX = 2, DirY = -2;
    private int paddleX = 200;
    private final int paddleY = 360;
    private final int PADDLE_WIDTH = 100;
    private final int PADDLE_HEIGHT = 10;
    private Timer timer;

    public PingPong1() {
        setPreferredSize(new Dimension(500, 400));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        timer = new Timer(5, this);
        timer.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillOval(compX, compY, 20, 20);
        g.fillRect(paddleX, paddleY, PADDLE_WIDTH, PADDLE_HEIGHT);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Main obj = new Main();
        frame.add(obj);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void movePaddle(int direction) {
        if (direction == -1 && paddleX > 0) {
            paddleX -= 20;
        } else if (direction == 1 && paddleX < 400) {
            paddleX += 20;
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            movePaddle(-1);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            movePaddle(1);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void actionPerformed(ActionEvent e) {
        compX += DirX;
        compY += DirY;
        if (compY <= 0) DirY *= -1;
        if (compX <= 0 || compX >= 480) DirX *= -1;
        if (compY + 20 >= paddleY && compX >= paddleX && compX <= paddleX + PADDLE_WIDTH) DirY *= -1;
        if (compY > 380) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Over!");
            System.exit(0);
        }
        repaint();
    }
}
