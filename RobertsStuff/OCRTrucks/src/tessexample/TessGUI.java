package tessexample;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TessGUI {
	
	private JFrame myWindow;
	
	private JMenuBar myMenuBar;
	
	private JFileChooser myFileChooser;
	
	private JPanel myMainPanel;
	
	private JScrollPane myScroll;
	
	private JTextArea myTextArea;
	
	public TessGUI() {
		super();
		myWindow = new JFrame("TessGUI");
		myFileChooser = new JFileChooser(".");
		myFileChooser.setMultiSelectionEnabled(true);
		myFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		myMainPanel = new JPanel();
		myTextArea = createTextArea();
		myScroll = createScroll();
		myMenuBar = createMenuBar();
		myMainPanel.add(myScroll);
		
	}
	
	public JScrollPane createScroll() {
		JScrollPane scroll = new JScrollPane(myTextArea);
		scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(300, 500));
		return scroll;
	}
	
	public JTextArea createTextArea() {
		JTextArea myTextArea = new JTextArea();
		myTextArea.setEditable(false);
		return myTextArea;
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar menubar = new JMenuBar( );
		JMenuItem selectFiles = new JMenuItem("Select Files");
		menubar.add(selectFiles);
		selectFiles.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                final int result = myFileChooser.showOpenDialog(selectFiles);
                if (result == JFileChooser.APPROVE_OPTION) {
                		try {
                			File[] files = myFileChooser.getSelectedFiles();
                			for (File file: files) {
                				TessClass.Tesseract(file);
                				myTextArea.setText(myTextArea.getText() + WriteExcel.removeFileExtension(file.getName()) + " has been created.\n");
                			}
                		} catch (final IOException e){
                				System.err.println(e.getMessage());
                		}
                }
            }
        });
		return menubar;
	}
	 
	
	public void start() {
		myWindow.setLayout(new FlowLayout());
		myWindow.add(myMainPanel);
		myWindow.setJMenuBar(myMenuBar);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setVisible(true);
        myWindow.setPreferredSize(myWindow.getPreferredSize());
        myWindow.setMinimumSize(myWindow.getPreferredSize());
        myWindow.pack();
	}
	
	public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TessGUI().start();
            }
        });    
    }
}
