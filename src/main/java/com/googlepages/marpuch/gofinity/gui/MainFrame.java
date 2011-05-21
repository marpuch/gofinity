package com.googlepages.marpuch.gofinity.gui;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;



/**
 * @author User #3
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

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
