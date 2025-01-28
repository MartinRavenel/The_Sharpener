package view;
import javax.swing.JPanel;
import javax.swing.JLabel;

import model.Target;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelGame extends JPanel {
    private FrameGame frame;
    private Target target;
    private JLabel scoreLabel;
    private int score;

    //Constructor
    public PanelGame(FrameGame frame) {
        this.frame = frame;
        this.score = 0;

        this.target = new Target(this.frame.getWidth() / 2, this.frame.getHeight() / 2 , 20);
        this.target.toString();
        this.setBackground(Color.GRAY);

        // Initialize score label
        this.scoreLabel = new JLabel("Score: " + score);
        this.add(scoreLabel);
        this.scoreLabel.setBounds(this.frame.getWidth() - 100, 10, 80, 20);

        // MouseListener
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isTargetHit(e.getX(), e.getY())) {
                    System.out.println("Hit !\tx:" + e.getX() + " y:" + e.getY());
                    System.out.println("-----------");
                    score++;
                    scoreLabel.setText("Score: " + score);
                    changeTarget();
                } else {
                    System.out.println("Miss !\tx:" + e.getX() + " y:" + e.getY());

                }
            }
        });
    }

    // Other Methods
    private boolean isTargetHit(int x, int y) {
        double distance = Math.sqrt(Math.pow(this.target.getX() - x, 2) + Math.pow(this.target.getY() - y, 2));
        return distance <= this.target.getRadius();
    }

    private void changeTarget() {
        /*
        setX [0 + this.target.getRadius() / 2 ; (int)(this.frame.getWidth() -  1.5 * this.target.getRadius())]
        setY [0 + this.target.getRadius() / 2 ; (int)(this.frame.getHeight() - 2.5 * this.target.getRadius())]
        */
        this.target.setX((int) (Math.random() * (this.frame.getWidth() - 1.5 * this.target.getRadius())) + this.target.getRadius() / 2);
        this.target.setY((int) (Math.random() * (this.frame.getHeight() - 2.5 * this.target.getRadius())) + this.target.getRadius() / 2);
        repaint();
        System.out.println(this.whereIsTarget());
    }

	//Drawing method
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Drawing target
        g.setColor(Color.BLACK);
        g.drawOval(this.target.getX() - (this.target.getRadius() / 2),
                    this.target.getY() - (this.target.getRadius() / 2),
                    this.target.getRadius(),
                    this.target.getRadius());
                    
        g.setColor(Color.GREEN);
        g.fillOval(this.target.getX() - (this.target.getRadius() / 2),
					this.target.getY() - (this.target.getRadius() / 2),
					this.target.getRadius(),
					this.target.getRadius());
    }

    //Debug method
    public String whereIsTarget() {
        return "Target (" + this.target.getX() + " ; " + this.target.getY() + ")"
        +      "Frame (" + this.frame.getWidth() + " ; " + this.frame.getHeight() + ")";
    }

}