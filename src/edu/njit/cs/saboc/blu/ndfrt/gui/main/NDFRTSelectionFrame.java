/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.njit.cs.saboc.blu.ndfrt.gui.main;

import edu.njit.cs.saboc.blu.core.gui.frame.AbnSelectionFrameFactory;
import edu.njit.cs.saboc.blu.core.gui.frame.BLUFrame;
import edu.njit.cs.saboc.blu.ndfrt.gui.abnselection.NDFDisplayFrameListener;
import edu.njit.cs.saboc.blu.ndfrt.gui.abnselection.NDFRTVersionSelectPanel;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 *
 * @author hl395
 */
public class NDFRTSelectionFrame implements AbnSelectionFrameFactory{

    @Override
    public JInternalFrame returnSelectionFrame(BLUFrame jFrame) {
        JInternalFrame jif = new JInternalFrame();
        jif.setSize(1400, 700);
        JPanel jp= new NDFRTVersionSelectPanel(new NDFDisplayFrameListener(jFrame) {
            
            @Override
            public void displayFrame(JInternalFrame frame) {
                jFrame.addFrame(frame);
            }
        });
        jif.add(jp);
        jif.setVisible(true);
        return jif;
    }


    
}
