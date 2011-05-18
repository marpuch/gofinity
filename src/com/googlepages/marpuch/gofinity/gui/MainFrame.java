package com.googlepages.marpuch.gofinity.gui;

import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.layout.*;
/*
 * Created by JFormDesigner on Sun May 15 13:41:54 CEST 2011
 */



/**
 * @author User #3
 */
public class MainFrame extends JFrame {
	public MainFrame() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		mMenuBar1 = new JMenuBar();
		mMenu1 = new JMenu();
		mMenuItem1 = new JMenuItem();
		mMainPanel1 = new MainPanel();
		CellConstraints cc = new CellConstraints();

		//======== this ========
		setTitle("gofinity");
		setName("this");
		Container contentPane = getContentPane();
		contentPane.setLayout(new FormLayout(
			"default:grow",
			"fill:default:grow"));

		//======== mMenuBar1 ========
		{
			mMenuBar1.setName("menuBar1");

			//======== mMenu1 ========
			{
				mMenu1.setText("File");
				mMenu1.setName("menu1");

				//---- mMenuItem1 ----
				mMenuItem1.setText("Exit");
				mMenuItem1.setName("menuItem1");
				mMenu1.add(mMenuItem1);
			}
			mMenuBar1.add(mMenu1);
		}
		setJMenuBar(mMenuBar1);

		//---- mMainPanel1 ----
		mMainPanel1.setName("mainPanel1");
		contentPane.add(mMainPanel1, cc.xy(1, 1));
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JMenuBar mMenuBar1;
	private JMenu mMenu1;
	private JMenuItem mMenuItem1;
	private MainPanel mMainPanel1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
