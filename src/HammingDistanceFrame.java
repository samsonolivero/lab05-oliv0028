import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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
	
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 700;
	
	@SuppressWarnings("unused")
	private final class HammingDistancePanel extends JPanel implements MouseListener
	{
		
		
	}
		
	//==================================================================================================================
	// Panels for component grouping and organization:
	//==================================================================================================================

	/** panel to hold the non-GraphicalCalculatorPanel panels */
	JPanel panel0 = new JPanel(new GridLayout(2, 2));
	/** panel for operand text entry */
	JPanel panel1 = new JPanel();
	/** panel for the radio buttons */
	JPanel panel2 = new JPanel(new GridLayout(3, 0));
	/** panel for the set operand/operator buttons  */
	JPanel panel3 = new JPanel(new GridLayout(3, 0));
	/** panel for the error message */
	JPanel panel4 = new JPanel();

	
}



/**
 * Interactive panel that the user clicks on to modify portions of an equation. The panel effectively works as
 * a simple equation editor. The panel has 5 regions that may be clicked - 3 operand regions and 2 operator
 * regions. That is, the Panel displays an expression with 5 editable regions. Regions are marked by a black
 * bounding box and when the region is clicked it is "selected" and highlighted yellow.
 *
 * The equation represented by this panel is of the form:
 * 	operand0 operator0 operand1 operator1 operand2 = result
 */
@SuppressWarnings("unused")
private final class GraphicalCalculatorPanel extends JPanel implements MouseListener
{
	/**
	 * Width and height for the panel. Width matches the enclosing frame.
	 */
	private static final int PANEL_WIDTH = FRAME_WIDTH;
	private static final int PANEL_HEIGHT = 300;

	/**
	 * Size of the regions.
	 */
	private static final int REGION_WIDTH = 50;
	private static final int REGION_HEIGHT = 50;

	/**
	 * Define top-left corner of first region and x increment between corners.
	 */
	private static final int REGION_START_X = 50;
	private static final int REGION_START_Y = 50;
	private static final int REGION_INC_X = 60;


	/**
	 * Color to highlight the selected region:
	 */
	Color highlight = new Color(255, 255, 0, 127);

	/**
	 * The editable regions. These are stored as rectangles to represent where to draw them as well as to
	 * represent the area on the panel that selects the region when clicked.
	 *
	 * regions[0] refers to the left-most region displayed
	 */
	Rectangle[] regions;

	/**
	 * The points at which the parts of the equation are drawn (operators, operands, = sign, result). The regions
	 * are drawn around the displayed text for the editable parts of the equation.
	 */
	Point[] textPoints;

	/**
	 * The region selected that should be highlighted yellow.
	 */
	private int selectedRegion = 0;

	/**
	 * The operands of the equation. Used for evaluation and for drawing the expression.
	 */
	private int[] operands = {0, 0, 0};

	/**
	 * The operators of the equation. Used for evaluation and for drawing the expression.
	 */
	private String[] operators = {"+", "+"};

	/**
	 * Creates the panel and sets up the listeners and member variables.
	 */
	public GraphicalCalculatorPanel()
	{
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setupRegions();
		this.setupTextPoints();
		this.addMouseListener(this);
	}

	
	

/** panel for displaying and interacting with the expression */
GraphicalCalculatorPanel gcPanel = new GraphicalCalculatorPanel();


//==================================================================================================================
// Operand Entry:
//==================================================================================================================

/** Text field for the user's number input */
JTextField operandEntry = new JTextField("00000");

/**
 * Button to attempt to set the selected region in the Graphical panel to the value in the operand
 * entry text field.
 */
JButton setOperand = new JButton("Set Operand");

//==================================================================================================================
// Operator Entry:
//==================================================================================================================

/** Group of operation buttons */
ButtonGroup ops = new ButtonGroup();

/** add operation radio button */
JRadioButton add = new JRadioButton("+");
/** divide operation radio button */
JRadioButton subtract = new JRadioButton("-");
/** multiply operation radio button */
JRadioButton multiply = new JRadioButton("*");

/**
 * Button to attempt to set the selected region in the Graphical panel to the selected operator (as defined by
 * the radio buttons).
 */
JButton setOperator = new JButton("Set Operator");

//==================================================================================================================
// Misc.
//==================================================================================================================

/** Text that display an error message */
JLabel errorMessage = new JLabel();

//==================================================================================================================
// Main and constructor:
//==================================================================================================================

/**
 * This method builds and operates the GUI window.
 * @param title The title of the window.
 */
public GraphicalCalculatorFrame() 
{
    super("GraphicalCalculatorFrame");

    this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    this.setLayout(new GridLayout(2, 0));

    
    // TODO: add components to panels
    panel1.add(operandEntry);
    
    panel2.add(setOperand);
    panel2.add(setOperator);
    
    panel3.add(add);
    panel3.add(subtract);
    panel3.add(multiply);
    
    panel4.add(errorMessage);
    // TODO: add radio buttons to the button group
    ops.add(add);
    ops.add(subtract);
    ops.add(multiply);
    
    
   
    
    //default to + operator
    add.setSelected(true); //remember, the button group ensures only one button is selected
    
    // TODO: add sub-panels into panel 0
    panel0.add(panel1);
    panel0.add(panel2);
    panel0.add(panel2);
    panel0.add(panel3);
    panel0.add(panel4);
    
    // Adds all panels to frame:
    panel0.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT - 300));

    this.add(panel0);
    this.add(gcPanel);

    // Set ActionListeners on buttons:

    /*
     * Attempts to set the selected region in gcPanel to the operand value in the operandEntry textbox.
     * If the set operation fails, display the error message "Failed to set operand value".
     * If the set operation succeeds, clear any error messages.
     */
   
    setOperand.addActionListener((e) -> 
    {
    	String operand = operandEntry.getText();
     	boolean ifSuccessful = gcPanel.setSelectedRegionContents(operand);
    	if(ifSuccessful)
    	{
    		System.out.flush();
    	}
    	else
    	{
    		System.out.println("Failed to set operand value");
    		
    	}
    		// TODO: attempt to modify the selected region in gcPanel with the new operand value.
    	
    
    	
    }
    );

    /*
     * Attempts to set the selected region in gcPanel to the selected operator (which radio button is pressed).
     * Pass the string:
     * 	"+" if the add button is selected
     *  "-" if the subtract button is selected
     *  "*" if the multiply button is selected
     *
     * If the set operation fails, display the error message "Failed to set operator value".
     * If the set operation succeeds, clear any error messages.
     */
    setOperator.addActionListener((e) -> 
    {
    	// TODO: attempt to modify the selected region in gcPanel with the new operator value.
    	String operator;
    	if(add.isSelected())
    	{
    		operator = "+";
    	}
    	else if(subtract.isSelected())
    	{
    		operator = "-";
    	}
    	else
    	{
    		operator = "*";
    	}
    	
    	
     	boolean ifSuccessful = gcPanel.setSelectedRegionContents(operator);
    	if(ifSuccessful)
    	{
    		System.out.flush();
    	}
    	else
    	{
    		System.out.println("Failed to set operator value");
    		
    	}
    		// TODO: attempt to modify the selected region in gcPanel with the new operand value.
    	
    	
    }
    );
    
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
		
  
   

}
/**
 * Main method to the program. Creates a new GraphicalCalculatorFrame object,
 * calling its constructor.
 *
 * @param args The program arguments.
 */
public static void main(String[] args)
{
	new GraphicalCalculatorFrame();
}
}
}
