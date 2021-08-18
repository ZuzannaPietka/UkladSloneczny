
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class AppFrame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	public JButton pauseButton = new JButton("Pause");
	public Animation animArea;
	public JButton fasterButton = new JButton("FASTER!!!");
	public JButton slowerButton = new JButton("slower...");
	public JButton ToggleOrbitButton = new JButton("Toggle orbit");
	public JPanel nowyPanel;
	public ArrayList <JButton> szybciej;
	public static JTextField pole = new JTextField ("Wpisz..");
	int q;
	
	public AppFrame() {
		setTitle("Animation");
		setSize(1500, 850);
		setResizable(false);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		initGUI();
	}
	
	public void initGUI() {
	this.setLayout(new BorderLayout());
	
		this.nowyPanel = new JPanel();
		this.add(nowyPanel, BorderLayout.SOUTH);
		
		animArea = new Animation();
		
		this.add(animArea, BorderLayout.CENTER);
		
		this.pauseButton = new JButton("Start/Stop");
		this.nowyPanel.add(this.pauseButton);
		this.pauseButton.addActionListener(this);;
		
		this.slowerButton = new JButton("Wolniej");
		this.nowyPanel.add(this.slowerButton);
		this.slowerButton.addActionListener(this);
		
		this.fasterButton = new JButton("Szybciej");
		this.nowyPanel.add(this.fasterButton);
		this.fasterButton.addActionListener(this);
		
		
		
	}
public static void nowe () {

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
	Object source = arg0.getSource();
		
		if (source == fasterButton)
			animArea.switchFaster();
		if (source == slowerButton)
			animArea.switchSlower();
			
			
		
		if (source == pauseButton)
		animArea.switchAnimationState();
		
		
		
		
		
}
}
