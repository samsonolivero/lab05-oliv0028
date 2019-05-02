import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
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

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


@SuppressWarnings("serial")
public class HammingDistanceFrame extends JFrame
{
	private ArrayList<String> datalist = new ArrayList<String>();
	private JComboBox<String> formSelect = new JComboBox<String>();
	
	
	private void initializeDataList() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		String string = br.readLine();
		
		while((string = br.readLine()) != null)
		{
			datalist.add(string);
			br.readLine();
		}
		br.close();
	}
	
	private DefaultComboBoxModel<String> getComboBoxModel(List<String> data) throws IOException
	{
		
		ArrayList<String> stIDs = new ArrayList<String>();
		
		for(int i = 0; i < datalist.size(); i++)
		{
			stIDs.add(datalist.get(i));
		}
		
		
		String[] comboBoxModel = stIDs.toArray(new String[stIDs.size()]);
	    return new DefaultComboBoxModel<>(comboBoxModel);
	}
	
	
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 1000;
	
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
	
	//The Whole Panel
	//JPanel panel0 = new JPanel(new GridLayout(0, 2));
	
	JPanel project = new JPanel(new GridLayout(6,1));
	
	JPanel enterDistance = new JPanel(new GridLayout(2, 1));
	//JPanel sliderPanel = new JPanel();
	JPanel stations = new JPanel(new GridLayout(2,1));
	//JPanel displayStations = new JPanel(new GridLayout(1,1));
	JPanel comparison = new JPanel(new GridLayout(0, 2));
	JPanel distances = new JPanel(new GridLayout(7,  2));
	
	//JPanel addStationPanel = new JPanel(new GridLayout(0, 2));
	
	JPanel freeSpace = new JPanel(new GridLayout(3,0));
	
	
	
	
		
	//==================================================================================================================
	// Panels for component grouping and organization:
	//==================================================================================================================

	/** panel to hold the non-GraphicalCalculatorPanel panels */
	// JPanel panel0 = new JPanel(new GridLayout(2, 2));
	/** panel for operand text entry */
	// JPanel panel1 = new JPanel();
	/** panel for the radio buttons */
	
	
	JSlider hamDistance = new JSlider(JSlider.HORIZONTAL, 1, 4, 2);
	
	JTextArea textArea = new JTextArea();
	JScrollPane sp = new JScrollPane(textArea);
	
	
	JButton showStation = new JButton("Show Station");
	JButton calculateHD = new JButton("Calculate HD");
	JButton addStation = new JButton("Add Station");
	
	JTextField enterHD = new JTextField("");
	
	JTextField hd0 = new JTextField("");
	JTextField hd1 = new JTextField("");
	JTextField hd2 = new JTextField("");
	JTextField hd3 = new JTextField("");
	JTextField hd4 = new JTextField("");
	
	public void setDistances(HammingDistance hd)
	{
		hd0.setText("1");
		hd1.setText("" + hd.getDistance1());
		hd2.setText("" + hd.getDistance2());
		hd3.setText("" + hd.getDistance3());
		hd4.setText("" + hd.getDistance4());
	}
	
	
	JTextField currStation = new JTextField("");
	JTextField compareStID = new JTextField("");
	
	JLabel enterDist = new JLabel("Enter Hamming Dist:");
	//JLabel currDist = new JLabel("");
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
        this.setLayout(new GridLayout(0,2));
        
        try 
        {
			this.initializeDataList();
		} 
        catch (IOException e2)
        {
		
			e2.printStackTrace();
		}
        
        //Divides the entire thing by two
        this.add(project);
        //panel0.add(freeSpace);
        
        
        //enter distance panel
        enterDistance.add(enterDist);
        enterHD.setEditable(false);
        enterDistance.add(enterHD);
        
        //Add Slider
        hamDistance.setMajorTickSpacing(1);
    	hamDistance.setPaintTicks(true);
    	
    	
        
    	// Set the labels to be painted on the slider
        hamDistance.setPaintLabels(true);
        hamDistance.setPaintTicks(true);
        enterDistance.add(hamDistance);   
        
        //Creates Function for Slider
        hamDistance.addChangeListener(new ChangeListener() 
        {              
        	public void stateChanged(ChangeEvent e) 
        	{                  
        	enterHD.setText(Integer.toString(hamDistance.getValue()));               
        	}            
        	});
       
        project.add(enterDistance);

        
        //Station Button
        stations.add(showStation);
        

        //Add Text Area 
        textArea.setEditable(false);
        stations.add(sp);
        
        showStation.addActionListener((e) ->
        {
        	textArea.setText("");
        	int select = formSelect.getSelectedIndex();
        	String currStID = datalist.get(select); //TODO GET DROPBOX.getText();
         	
        	HammingDistance object = new HammingDistance();
        	
        	int selectedDistance = hamDistance.getValue();
        	
        	try 
        	{
				object.getHammingDistance(currStID);
				
				switch(selectedDistance)
				{
				case 1:
					for(int i = 0; i < object.printDistance1().size(); i++)
					{
						textArea.append(object.printDistance1().get(i) + "\n");
					}
						
		
					break;
				case 2:
					for(int i = 0; i < object.printDistance2().size(); i++)
					{
						textArea.append(object.printDistance2().get(i) + "\n");
					}
				
					break;
				case 3:
					for(int i = 0; i < object.printDistance3().size(); i++)
					{
						textArea.append(object.printDistance3().get(i) + "\n");
					}
					break;
				case 4:
					for(int i = 0; i < object.printDistance4().size(); i++)
					{
						textArea.append(object.printDistance4().get(i) + "\n");
					}
					
					break;
					
				}
				
				
			} catch (IOException e1) 
        	{
				e1.printStackTrace();
			}
        	
        });
       
        
        project.add(stations);
        
        //TODO Add DropBox
        comparison.add(compareWith);
        
        
        // Add in the form selector:
     	DefaultComboBoxModel<String> comboBoxModel;
		try {
			comboBoxModel = getComboBoxModel(datalist);
			formSelect.setModel(comboBoxModel);
	   		formSelect.setSelectedIndex(datalist.indexOf("YUKO"));
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
     	
		
   		formSelect.addActionListener((e) -> 
   		{
     		int select = formSelect.getSelectedIndex();
     		compareStID.setText(datalist.get(select));
     		
   		});
     	comparison.add(formSelect);
        project.add(comparison);
        
        
        //Adds all the distances and their selected values
        //Also Makes the hd variables uneditable
        hd0.setEditable(false);
        hd1.setEditable(false);
        hd2.setEditable(false);
        hd3.setEditable(false);
        hd4.setEditable(false);
        
        distances.add(calculateHD);
        distances.add(new JLabel(""));
        distances.add(dist0);
        distances.add(hd0);
        distances.add(dist1);
        distances.add(hd1);
        distances.add(dist2);
        distances.add(hd2);
        distances.add(dist3);
        distances.add(hd3);
        distances.add(dist4);
        distances.add(hd4);
        
        calculateHD.addActionListener((e) -> 
        {
        	int select = formSelect.getSelectedIndex();
        	String currStID = datalist.get(select); //TODO GET DROPBOX.getText();
         	
        	HammingDistance object = new HammingDistance();
        	
        	try 
        	{
				object.getHammingDistance(currStID);
				this.setDistances(object);
				
			} catch (IOException e1) 
        	{
				e1.printStackTrace();
			}
        	
     
        	
        			
        
        	
        }
        );
       
        
        //TODO Set Default Station
        /*
		datalist.add(newData);
		int select = datalist.size() - 1;
		*/
        distances.add(addStation);
        distances.add(currStation);  
        addStation.addActionListener((e) ->
        {
        	String newStID;
        	
        	if(currStation.getText().length() == 4)
        	{
        		newStID = currStation.getText().toUpperCase();
        		boolean noRepeat = true;
            	for(int i = 0; i < datalist.size(); i++)
            	{
            		if(newStID.equalsIgnoreCase(datalist.get(i)))
            		{
            			noRepeat = false;
            		}
            	}
            	
            	int select;
            	if(noRepeat)
            	{
            		datalist.add(newStID.toUpperCase());
            		Collections.sort(datalist);
            		select = Collections.binarySearch(datalist, newStID);
            		
            	}
            	else
            	{
            		select = Collections.binarySearch(datalist, newStID);
            	}
            	
            		
            	
            	
            	
            	
            	
            	
            	
    			DefaultComboBoxModel<String> newComboBoxModel;
    			try {
    				newComboBoxModel = getComboBoxModel(datalist);
    				formSelect.setModel(newComboBoxModel);
    				formSelect.setSelectedIndex(select);
    				
    				
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
    			
        	}
        	else
        	{
        		currStation.setText("ERROR TRY AGAIN");
        	}
        	
        	
        	
        	
        	
        });
        
        project.add(distances);
        
       
        //adds the two panels to the jframe
        
       
        this.add(hdPanel);
        
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        
        
        
	}
	
	public static void main(String[] args)
	{
		new HammingDistanceFrame();
		
		
	}
}
