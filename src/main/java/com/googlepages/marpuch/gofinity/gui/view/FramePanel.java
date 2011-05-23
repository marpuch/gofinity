package com.googlepages.marpuch.gofinity.gui.view;

import javax.swing.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
/*
 * Created by JFormDesigner on Mon May 23 13:26:54 CEST 2011
 */



/**
 * @author User #3
 */
public class FramePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public FramePanel() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		mToolbar = new JToolBar();
		mButton1 = new JButton();
		mTabbedPane = new JTabbedPane();
		mPanel1 = new JPanel();
		mLStatus = new JLabel();
		CellConstraints cc = new CellConstraints();

		//======== this ========
		setName("this");
		setLayout(new FormLayout(
			new ColumnSpec[] {
				new ColumnSpec(Sizes.DLUX3),
				new ColumnSpec(ColumnSpec.FILL, Sizes.DEFAULT, 1.0),
				new ColumnSpec(Sizes.DLUX3)
			},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.LINE_GAP_ROWSPEC,
				new RowSpec(RowSpec.FILL, Sizes.DEFAULT, 1.0),
				FormFactory.LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.LINE_GAP_ROWSPEC
			}));

		//======== mToolbar ========
		{
			mToolbar.setFloatable(false);
			mToolbar.setRollover(true);
			mToolbar.setName("Toolbar");

			//---- mButton1 ----
			mButton1.setText("Start...");
			mButton1.setName("button1");
			mToolbar.add(mButton1);
		}
		add(mToolbar, cc.xywh(1, 1, 3, 1));

		//======== mTabbedPane ========
		{
			mTabbedPane.setName("tabbedPane");

			//======== mPanel1 ========
			{
				mPanel1.setName("panel1");
				mPanel1.setLayout(new FormLayout(
					new ColumnSpec[] {
						FormFactory.DEFAULT_COLSPEC,
						new ColumnSpec(Sizes.DLUX3),
						FormFactory.DEFAULT_COLSPEC
					},
					new RowSpec[] {
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.LINE_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.LINE_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC
					}));
			}
			mTabbedPane.addTab("test", mPanel1);

		}
		add(mTabbedPane, cc.xy(2, 3));

		//---- mLStatus ----
		mLStatus.setText("text");
		mLStatus.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
		mLStatus.setName("lStatus");
		add(mLStatus, cc.xy(2, 5));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JToolBar mToolbar;
	private JButton mButton1;
	private JTabbedPane mTabbedPane;
	private JPanel mPanel1;
	private JLabel mLStatus;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
