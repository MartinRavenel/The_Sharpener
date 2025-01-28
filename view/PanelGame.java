package view;

import model.Target;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelGame extends JPanel {

    private final int TARGET_DIAMETER = 20;
    private FrameGame frame;
    private Target target;
    private JLabel scoreLabel;
    private int score;

    //Constructor
    public PanelGame(FrameGame frame) {
        this.frame = frame;
        this.score = 0;

        this.target = new Target(this.frame.getWidth() / 2, this.frame.getHeight() / 2 , this.TARGET_DIAMETER);
        this.setBackground(Color.GRAY);


        this.scoreLabel = new JLabel("Score: " + score);
        this.add(scoreLabel);
        this.scoreLabel.setBounds(this.frame.getWidth() - 100, 10, 80, this.TARGET_DIAMETER);

        // MouseListener
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isTargetHit(e.getX(), e.getY())) {
                    System.out.println("Hit !  (" + e.getX() + " ; " + e.getY() + ")" + "\n-----------");
                    scoreLabel.setText("Score: " + score++);
                    changeTarget();
                } else {
                    System.out.println("Miss ! (" + e.getX() + " ; " + e.getY() + ")");

                }
            }
        });
    }

    // Other Methods
    private boolean isTargetHit(int x, int y) {
        double distanceSquared = Math.pow(this.target.getX() - x, 2) + Math.pow(this.target.getY() - y, 2);
        double radiusSquared = Math.pow(this.target.getDiameter() / 2, 2);
        return distanceSquared <= radiusSquared;
    }

    private void changeTarget() {
        /*
        X is in [0 + this.target.getDiameter() / 2 ; (int)(this.frame.getWidth()  - 1.5 * this.target.getDiameter())]
        Y is in [0 + this.target.getDiameter() / 2 ; (int)(this.frame.getHeight() - 2.5 * this.target.getDiameter())]
        */
        this.target.setX((int) (Math.random() * (this.frame.getWidth()  - 1.5 * this.target.getDiameter())) + this.target.getDiameter() / 2);
        this.target.setY((int) (Math.random() * (this.frame.getHeight() - 2.5 * this.target.getDiameter())) + this.target.getDiameter() / 2);
        this.repaint();
        System.out.println(this.toStringHitbox());
    }

	//Drawing method
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Drawing target
        g.setColor(Color.BLACK);
        g.drawOval( this.target.getX() - (this.target.getDiameter() / 2 ),
                    this.target.getY() - (this.target.getDiameter() / 2 ),
                    this.target.getDiameter(),
                    this.target.getDiameter());
                    
        g.setColor(Color.GREEN);
        g.fillOval( this.target.getX() - (this.target.getDiameter() / 2 ),
					this.target.getY() - (this.target.getDiameter() / 2 ),
					this.target.getDiameter(),
					this.target.getDiameter());
    }

    //Debug method
    public String toStringHitbox() {
        return "Target (" + this.target.getX() + " ; " + this.target.getY()     + ")\t"
        +      "X range : (" + (this.target.getX() - this.target.getDiameter() / 2 ) + " ; " + (this.target.getX() + this.target.getDiameter() / 2 ) + ") "
        +      "Y range : (" + (this.target.getY() - this.target.getDiameter() / 2 ) + " ; " + (this.target.getY() + this.target.getDiameter() / 2 ) + ") "
        +      "Frame ("  + this.frame.getWidth() + " ; " + this.frame.getHeight() + ")";
    }

}