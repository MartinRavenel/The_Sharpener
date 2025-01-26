import javax.swing.JFrame;

public class FrameGame extends JFrame
{
	private PanelGame panelGame;
	public FrameGame()
	{
		setTitle("The Sharpener");
		setSize(500, 400);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);


		this.panelGame = new PanelGame(this);
		this.add(this.panelGame);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}