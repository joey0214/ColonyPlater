/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colonyplater.gui;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author xizho3
 */
class LoadDialog 
{
    private  JFileChooser fileChooser; 
    private  File selectedFile;
    private File[] selectedFiles; 
    public LoadDialog()
    {
        fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Load Image File");
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        fileChooser.setCurrentDirectory(new File("."));

        int c = fileChooser.showOpenDialog(this.fileChooser);
        if (c != JFileChooser.APPROVE_OPTION) 
        {
            return;
        }
        else if (c == JFileChooser.APPROVE_OPTION) 
        {
            selectedFile = fileChooser.getSelectedFile();
//            checkFiles(selectedFiles);
           
        }
    }
    
    public File getImage()
    {
        return selectedFile; 
    }
    
//    public File[] getFiles()
//    {
//        return selectedFiles;
//    }
    
    // to check if all selected files have the same suffix in file name
//    private void checkFiles(File[] selectFiles) 
//    {
//        String tester = selectFiles[0].getName().split("\\.")[1]; 
//        if (!"csv".equals(tester.toLowerCase()))
//        {
//            JOptionPane.showMessageDialog(new JFrame(), "Are you sure the selected file is in csv format?");
//        }
//        
//        for (int i = 1; i < selectFiles.length; i++)
//        {
//            String tested = selectFiles[i].getName().split("\\.")[1].toLowerCase();
//            if (tested == null ? tester != null : !tested.equals(tester))
//            {
//                JOptionPane.showMessageDialog(new JFrame(), "Wrong format. Please choose filein csv again.");
//            }
//        }
//        
//    }
    
}
