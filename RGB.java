import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class RGB {
	private static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private static final int SCREEN_X = gd.getDisplayMode().getWidth();
    private static final int SCREEN_Y = gd.getDisplayMode().getHeight();


    // Frame
    private static JFrame frame;
    private static JPanel back;
    private static JPanel menu;
    private static JPanel window;

    //Display color (window)
    private static int w_r = 200;
    private static int w_g = 200;
    private static int w_b = 100;
    private static int w_a = 150;

    //Font
    private static String font = "Times New Roman";

	public static void main(String[] args) {
		frame = new JFrame("RGB");
		setFrame();

		back = new JPanel(new GridLayout(1, 2));
		back.setBackground(new Color(255, 255, 255));

		menu = new JPanel(new GridBagLayout());
		menu.setBounds(0, 0, SCREEN_X/2, SCREEN_Y);
		menu.setBorder(BorderFactory.createMatteBorder(SCREEN_Y/100, SCREEN_X/150, SCREEN_Y/100, SCREEN_X/150, new Color(200, 200, 200)));

		window = new JPanel();
		window.setBounds(SCREEN_X/2, 0, SCREEN_X/2, SCREEN_Y);
		
    	refresh();
		createMenu();
	}
	private static void setFrame() {
        frame.setSize(SCREEN_X, SCREEN_Y);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private static void refresh() {


    	window.setBackground(new Color (w_r, w_g, w_b, w_a));
		back.add(menu);
		back.add(window);

		frame.add(back);
		frame.setVisible(true);
    }
    private static void createMenu() {
    	JLabel current = new JLabel("Current RGBA: ");
		current.setFont(new Font(font, Font.BOLD, SCREEN_X/100));

		JLabel cRGBA = new JLabel();
		cRGBA.setFont(new Font(font, Font.PLAIN, SCREEN_X/100));
		cRGBA.setText("R = " + String.valueOf(w_r) + ", G = " + String.valueOf(w_g) + 
						", B = " + String.valueOf(w_b) + ", A = " + String.valueOf(w_a));

		JLabel nextR = new JLabel("New R: ");
		nextR.setFont(new Font(font, Font.BOLD, SCREEN_X/100));

		JTextField inputR = new JTextField("");
		inputR.setFont(new Font(font, Font.PLAIN, SCREEN_X/100));
		inputR.setColumns(5);

		JLabel nextG = new JLabel("New G: ");
		nextG.setFont(new Font(font, Font.BOLD, SCREEN_X/100));

		JTextField inputG = new JTextField("");
		inputG.setFont(new Font(font, Font.PLAIN, SCREEN_X/100));
		inputG.setColumns(5);

		JLabel nextB = new JLabel("New B: ");
		nextB.setFont(new Font(font, Font.BOLD, SCREEN_X/100));

		JTextField inputB = new JTextField("");
		inputB.setFont(new Font(font, Font.PLAIN, SCREEN_X/100));
		inputB.setColumns(5);

		JLabel nextA = new JLabel("New A: ");
		nextA.setFont(new Font(font, Font.BOLD, SCREEN_X/100));

		JTextField inputA = new JTextField("");
		inputA.setFont(new Font(font, Font.PLAIN, SCREEN_X/100));
		inputA.setColumns(5);

		JButton change = new JButton("Change Color");
		change.setFont(new Font(font, Font.PLAIN, SCREEN_X/100));

		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		menu.add(current, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		menu.add(cRGBA, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		menu.add(nextR, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		menu.add(inputR, gc);

		gc.gridx = 0;
		gc.gridy = 2;
		menu.add(nextG, gc);

		gc.gridx = 1;
		gc.gridy = 2;
		menu.add(inputG, gc);

		gc.gridx = 0;
		gc.gridy = 3;
		menu.add(nextB, gc);

		gc.gridx = 1;
		gc.gridy = 3;
		menu.add(inputB, gc);

		gc.gridx = 0;
		gc.gridy = 4;
		menu.add(nextA, gc);

		gc.gridx = 1;
		gc.gridy = 4;
		menu.add(inputA, gc);

		gc.gridx = 0;
		gc.gridy = 5;
		gc.gridwidth = 2;
		menu.add(change, gc);

		refresh();

		change.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int newR = Integer.valueOf(inputR.getText());
            	int newG = Integer.valueOf(inputG.getText());
            	int newB = Integer.valueOf(inputB.getText());
            	int newA = Integer.valueOf(inputA.getText());
            	boolean pass = checkNew(newR, newG, newB, newA);
            	if (pass) {
            		w_r = newR;
            		w_b = newB;
            		w_g = newG;
            		w_a = newA;
            	}
		    	menu.removeAll();
		    	frame.repaint();
            	createMenu();
            }
    	});
	}

	private static boolean checkNew(int R, int G, int B, int A) {
		if (R < 0 || R > 255) return false;
		if (G < 0 || G > 255) return false;
		if (B < 0 || B > 255) return false;
		if (A < 0 || B > 255) return false;
		return true;
	}
}