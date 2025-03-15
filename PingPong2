import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PingPong2 extends JPanel implements ActionListener, KeyListener {
    private int ballX = 250, ballY = 250;
    private int ballDirX = 2, ballDirY = -2;
    private int paddleX = 200;
    private final int paddleY = 360;
    private final int PADDLE_WIDTH = 100, PADDLE_HEIGHT = 10;
    private Timer timer;
    private int score = 0;
    private int paddleBotX = 200;
    private final int paddleBotY = 50;
    private final int PADDLEBOT_WIDTH = 100, PADDLEBOT_HEIGHT = 10;
    private int HighScore = 0;

    public PingPong2() {
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
        g.fillOval(ballX, ballY, 20, 20);
        g.fillRect(paddleX, paddleY, PADDLE_WIDTH, PADDLE_HEIGHT);
        g.fillRect(paddleBotX, paddleBotY, PADDLEBOT_WIDTH, PADDLEBOT_HEIGHT);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 30);
        g.drawString("Highest Score: " + HighScore, 330, 30);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong Game");
        Main game = new Main();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void movePaddle(int direction) {
        if (direction == -1 && paddleX > 0) {
            paddleX -= 20;
        } else if (direction == 1 && paddleX < getWidth() - PADDLE_WIDTH) {
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
        ballX += ballDirX;
        ballY += ballDirY;
        if (paddleBotX + PADDLEBOT_WIDTH / 2 < ballX) {
            paddleBotX += 2;
        } else {
            paddleBotX -= 2;
        }
        if (ballX <= 0 || ballX >= getWidth() - 20) ballDirX *= -1;
        if (ballY <= 0) ballDirY *= -1;
        if (ballY + 20 >= paddleY && ballX + 20 >= paddleX && ballX <= paddleX + PADDLE_WIDTH) {
            ballDirY *= -1;
            score++;
            HighScore = Math.max(HighScore, score);
        }
        if (ballY <= paddleBotY + PADDLEBOT_HEIGHT && ballX + 20 >= paddleBotX && ballX <= paddleBotX + PADDLEBOT_WIDTH) {
            ballDirY *= -1;
        }
        if (ballY + 20 >= getHeight()) {
            timer.stop();
            int choice;
            if(score==HighScore) {
                choice = JOptionPane.showConfirmDialog(this, "Game Over! New HighScore reached, Score: " + score + "\nPlay Again?", "Game Over", JOptionPane.YES_NO_OPTION);
            } else {
                choice = JOptionPane.showConfirmDialog(this, "Game Over! Score: " + score + "\nPlay Again?", "Game Over", JOptionPane.YES_NO_OPTION);
            }
            if (choice == JOptionPane.YES_OPTION) {
                resetGame();
            } else {
                System.exit(0);
            }
        }

        repaint();
    }

    private void resetGame() {
        ballX = 250;
        ballY = 250;
        ballDirX = 2;
        ballDirY = -2;
        paddleX = 200;
        paddleBotX = 200;
        score = 0;
        timer.start();
    }
}
