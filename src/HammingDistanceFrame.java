import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class HammingDistanceFrame extends JFrame
{
	
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 800;
	
	@SuppressWarnings("unused")
	private final class HammingDistancePanel extends JPanel implements MouseListener
	{
		private static final int PANEL_WIDTH = FRAME_WIDTH;
		private static final int PANEL_HEIGHT = 300;
		
		public HammingDistancePanel()
		{
			this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
			this.addMouseListener(this);
		}
		
		Point[] textPoints;
		
		private void setupTextPoints()
		{
			textPoints = new Point[7];

			
		}
		
		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);

		}
		
		@Override
		public void mouseClicked(MouseEvent e)
		{
			// If the mouse clicked within a region, set that region to be the selected region.
			int eX = e.getX();
			int eY = e.getY();
			
			// Repaint the panel (this will implicitly call paintComponent):
			this.repaint();
		}
		
		/** DO NOT MODIFY - DOES NOTHING */
		@Override
		public void mousePressed(MouseEvent e) {}

		/** DO NOT MODIFY - DOES NOTHING */
		@Override
		public void mouseReleased(MouseEvent e) {}

		/** DO NOT MODIFY - DOES NOTHING */
		@Override
		public void mouseEntered(MouseEvent e) {}

		/** DO NOT MODIFY - DOES NOTHING */
		@Override
		public void mouseExited(MouseEvent e) {}
	}
	
	HammingDistancePanel hdPanel = new HammingDistancePanel();
	
	
	
	
		
	//==================================================================================================================
	// Panels for component grouping and organization:
	//==================================================================================================================

	/** panel to hold the non-GraphicalCalculatorPanel panels */
	// JPanel panel0 = new JPanel(new GridLayout(2, 2));
	/** panel for operand text entry */
	// JPanel panel1 = new JPanel();
	/** panel for the radio buttons */
	
	
	
	JButton showStation = new JButton("Show Station");
	JButton calculateHD = new JButton("Calculate HD");
	JButton addStation = new JButton("Add Station");
	
	JTextField enterHD = new JTextField("");
	JTextField hd0 = new JTextField("");
	JTextField hd1 = new JTextField("");
	JTextField hd2 = new JTextField("");
	JTextField hd3 = new JTextField("");
	JTextField hd4 = new JTextField("");
	
	JLabel enterDist = new JLabel("Enter Hamming Dist:");
	JLabel compareWith = new JLabel("Compare with:");
	JLabel dist0 = new JLabel("Distance 0");
	JLabel dist1 = new JLabel("Distance 1");
	JLabel dist2 = new JLabel("Distance 2");
	JLabel dist3 = new JLabel("Distance 3");
	JLabel dist4 = new JLabel("Distance 4");
	
	
	public HammingDistanceFrame() 
	{
        super("HammingDistanceFrame");

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLayout(new GridBagLayout());
        
        GridBagConstraints layoutConst = new GridBagConstraints();
        
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        
        layoutConst.insets = new Insets(10, 10, 10, 10);
        
        
        //adding JButtons
        hdPanel.add(showStation);
        hdPanel.add(calculateHD);
        hdPanel.add(addStation);
        
        
        this.add(hdPanel);
        
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setVisible(true);
        
        
        
        
	}
	
	public static void main(String[] args)
	{
		new HammingDistanceFrame();
		
		
	}
}
