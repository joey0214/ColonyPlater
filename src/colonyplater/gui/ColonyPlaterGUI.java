/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colonyplater.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author xizho3
 */
public class ColonyPlaterGUI extends JFrame implements  ActionListener
{
    private JMenuBar menuBar;
    private Dimension screenDimension; 
    private JMenuItem loadJMenuItem, editJMenuItem,aboutJMenuItem, exitJMenuItem, exportJMenuItem;
    private JMenu fileJMenu, anylsisJMenu, helpJMenu;
    private GridBagConstraints gbc; 
    private JPanel rplateImgPanel,toolsPanel, multipFilesJPanel;
    private int frameWidth, frameHeight; 
    private JLabel titJLabel,xnameJLabel,ynameJLabel,testJLabel;
    private JTextField mainTitleJTextField, xNameJTextField,yNameJTextField; 
    private JButton renameJButton1, renameJButton2, renameJButton3, testJButton;
    private String yourTitleString, yourXnameString, yourYnameString;
    private LoadDialog loadDialog;
    
    public ColonyPlaterGUI() 
    {
        super();
        setTitle("Colony Plater Beta");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        initComponents();
        show();
    }

    private void initComponents() 
    {
        addWindowListener(new WindowAdapter() 
        {
            @Override
            public void windowClosing(WindowEvent e) 
            {
                System.exit(0);
            }
        });
         
        makeMenu();
        
        screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenDimension.width*8/10 , screenDimension.height*8/10 );
        frameHeight = screenDimension.width*8/10; //this.getHeight();
        frameWidth = screenDimension.height*8/10; //this.getWidth();
        
        makePane(); 
        fillToolsPanel(); 
    }

    private void makeMenu() 
    {
        loadJMenuItem = new JMenuItem("Load Image");
        loadJMenuItem.addActionListener(this);
        
        exitJMenuItem = new JMenuItem("Exit");
        exitJMenuItem.addActionListener(this);
        
        exportJMenuItem = new JMenuItem("Export table"); 
        exitJMenuItem.addActionListener(this);
        
        fileJMenu = new JMenu("File");
        fileJMenu.add(loadJMenuItem); 
        fileJMenu.add(exportJMenuItem); 
        fileJMenu.add(exitJMenuItem); 
        
        editJMenuItem = new JMenuItem("Edit");
        editJMenuItem.addActionListener(this);
        
        anylsisJMenu = new JMenu("Analysis"); 
        anylsisJMenu.add(editJMenuItem); 
        
        aboutJMenuItem = new JMenuItem("About"); 
        aboutJMenuItem.addActionListener(this); 
        
        helpJMenu = new JMenu("Help"); 
        helpJMenu.add(aboutJMenuItem); 
        
        menuBar = new JMenuBar();
        menuBar.add(fileJMenu); 
        menuBar.add(anylsisJMenu); 
        menuBar.add(helpJMenu);
        
        setJMenuBar(menuBar);

    }
    
    
    @Override
    public void actionPerformed(ActionEvent ace) 
    {
        if (ace.getSource() == loadJMenuItem )
        {
            loadDialog = new LoadDialog();
            File imageFile = loadDialog.getImage();
            try 
            { 
                Image plotImage = ImageIO.read(imageFile);
                JLabel imageLabel = new JLabel(new ImageIcon(plotImage)); 
                add(imageLabel); 
                setVisible(true);
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(ColonyPlaterGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (ace.getSource() == exitJMenuItem )
        {
            System.exit(0);
        }
        
        if (ace.getSource() == exportJMenuItem)
        {
            //TODO
        }
        
        if (ace.getSource() == editJMenuItem )
        {
            //TODO
        }
        
        if (ace.getSource() == aboutJMenuItem )
        {
            try 
            {
                (new AboutDialog(this)).show();
            } 
            catch (MalformedURLException ex) 
            {
                Logger.getLogger(ColonyPlaterGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (ace.getSource() == renameJButton1)
        {
            yourTitleString = mainTitleJTextField.getText();
            yourTitleString = yourTitleString.trim(); 
        }
        
        if (ace.getSource() == renameJButton2)
        {
            yourXnameString = xNameJTextField.getText();
            yourXnameString = yourXnameString.trim(); 
        }
        
        if (ace.getSource() == renameJButton3)
        {
            yourYnameString = yNameJTextField.getText();
            yourYnameString = yourYnameString.trim();
        }
        
        if (ace.getSource() == testJButton)
        {
            
            
        }
    }

    private void makePane() 
    {
        JComponent pane;
        pane = (JComponent) getContentPane();
        pane.setLayout(new GridBagLayout());
        
        gbc = new GridBagConstraints();
        //set distance between containers
        gbc.insets = new Insets(4, 4, 4, 4);
        
        rplateImgPanel = new JPanel();
        rplateImgPanel.setLayout(new GridBagLayout());
        rplateImgPanel.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(
                EtchedBorder.LOWERED), "Plate Image"));
//        rplotPanel.setPreferredSize(new Dimension((frameWidth *7/10), (frameHeight)));
//        rplateImgPanel.setSize((frameWidth *7/10), (frameHeight));

        toolsPanel = new JPanel();
        toolsPanel.setLayout(new GridBagLayout());
        toolsPanel.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(
                EtchedBorder.LOWERED), "Tools"));
//        toolsPanel.setPreferredSize(new Dimension((frameWidth *3/10), (frameHeight )));
//        toolsPanel.setSize((frameWidth *3/10), (frameHeight ));

//        multipFilesJPanel = new JPanel();
//        multipFilesJPanel.setLayout(new GridBagLayout());
//        multipFilesJPanel.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(
//                EtchedBorder.LOWERED), "Multi Controller"));
//        multipFilesJPanel.setPreferredSize(new Dimension((frameWidth *3/10), (frameHeight / 2)));
//        multipFilesJPanel.setSize((frameWidth *3/10), (frameHeight / 2));
    
        //when the size of frame changed, containes do nothing
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTH;
        add(pane, rplateImgPanel, gbc, 0, 0, 3, 3);
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTH;
        add(pane, toolsPanel, gbc, 3, 0, 1, 3);

//        gbc.weightx = 1;
//        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.BOTH;
//        gbc.anchor = GridBagConstraints.NORTH;
//        add(pane, multipFilesJPanel, gbc, 1, 1, 1, 1);
        
        
        
    }
    
    private void add(Container cn, Component c, GridBagConstraints gbc, 
            int x, int y, int w, int h) 
    {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        cn.add(c, gbc);
    }  

    private void fillToolsPanel() 
    {
//        testJLabel = new JLabel("Test"); 
//        titJLabel = new JLabel("Main title");
//        xnameJLabel = new JLabel("X Axis");
//        ynameJLabel = new JLabel("Y Axis"); 
//        
//        mainTitleJTextField = new JTextField();
//        mainTitleJTextField.setVisible(true);
//        mainTitleJTextField.setEnabled(true);
//        mainTitleJTextField.setEditable(true);
//        mainTitleJTextField.setColumns(10);
//        
//        yNameJTextField = new JTextField(); 
//        yNameJTextField.setVisible(true);
//        yNameJTextField.setEnabled(true);
//        yNameJTextField.setEditable(true);
//        yNameJTextField.setColumns(10);
//        
//        xNameJTextField = new JTextField();
//        xNameJTextField.setVisible(true);
//        xNameJTextField.setEnabled(true);
//        xNameJTextField.setEditable(true);
//        xNameJTextField.setColumns(10);
//        
//        renameJButton1 = new JButton("Rename"); 
//        renameJButton1.addActionListener(this);
//        
//        renameJButton2 = new JButton("Rename"); 
//        renameJButton2.addActionListener(this);
//        
//        renameJButton3 = new JButton("Rename"); 
//        renameJButton3.addActionListener(this);
//        
//        testJButton = new JButton("Test");
//        testJButton.addActionListener(this);
//         
//        gbc.weightx = 0;
//        gbc.weighty = 0;
//        gbc.anchor = GridBagConstraints.NORTH;
//        
//        
//        add(toolsPanel, titJLabel, gbc,          0, 0, 1, 1);
//        add(toolsPanel, mainTitleJTextField, gbc, 1, 0, 1, 1);
//        add(toolsPanel, renameJButton1, gbc,     2, 0, 1, 1);
//        
//        add(toolsPanel, xnameJLabel, gbc,    0, 1, 1, 1);
//        add(toolsPanel, xNameJTextField, gbc, 1, 1, 1, 1);
//        add(toolsPanel, renameJButton2, gbc, 2, 1, 1, 1);
//        
//        add(toolsPanel, ynameJLabel, gbc,    0, 2, 1, 1);
//        add(toolsPanel, yNameJTextField, gbc, 1, 2, 1, 1);
//        add(toolsPanel, renameJButton3, gbc, 2, 2, 1, 1);
//        
//        add(toolsPanel, testJButton, gbc, 0, 3, 1, 1);
        
//        gbc.weightx = 0;
//        gbc.weighty = 0;
//        gbc.anchor = GridBagConstraints.NORTH;
//        JSeparator sep = new JSeparator();
//        sep.setPreferredSize(new Dimension(5, 1));
//        gbc.fill = GridBagConstraints.HORIZONTAL; 
//        gbc.weighty = 1;
//        toolsPanel.add(sep);
////        add(toolsPanel, sep);
////        toolsPanel.add(new JSeparator(GridBagConstraints.HORIZONTAL));
//        
//        gbc.weightx = 0;
//        gbc.weighty = 0;
//        gbc.anchor = GridBagConstraints.NORTH;
//        add(toolsPanel, testJButton, gbc, 0, 3, 1, 1);
    }
    
}
