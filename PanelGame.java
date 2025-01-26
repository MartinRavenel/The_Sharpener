import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelGame extends JPanel {
    private FrameGame frame;
    private Target target;

	//Constructor
    public PanelGame(FrameGame frame) {
        this.frame = frame;

        this.target = new Target(this.frame.getWidth() / 2, this.frame.getHeight() / 2 , 20);
        this.target.toString();
        this.setBackground(Color.GRAY);

        // MouseListener
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isTargetHit(e.getX(), e.getY())) {
                    System.out.println("Cible touchée !");
					changeTarget();

                } else {
                    System.out.println("Cible manquée !");
                }
            }
        });
    }

	public void changeTarget()
	{
        int newX = (int) (Math.random() * this.frame.getWidth());
        int newY = (int) (Math.random() * this.frame.getHeight());
        this.target = new Target(newX, newY, 20);
        this.repaint();
	}

    // Other Methods
    private boolean isTargetHit(int x, int y) {
        double distance = Math.sqrt(Math.pow(this.target.getX() - x, 2) + Math.pow(this.target.getY() - y, 2));
		
        return distance <= this.target.getRayon() / 2;
    }

	//Drawing method
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);

        // Dessiner la cible
        g.fillOval(this.target.getX() - (this.target.getRayon() / 2),
					this.target.getY() - (this.target.getRayon() / 2),
					this.target.getRayon(),
					this.target.getRayon());
    }


}