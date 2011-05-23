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
		mBtnStart = new JButton();
		mBtnStartNetwork = new JButton();
		mTabbedPane = new JTabbedPane();
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

			//---- mBtnStart ----
			mBtnStart.setIcon(new ImageIcon(getClass().getResource("/icons/start_game.gif")));
			mBtnStart.setToolTipText("Start game");
			mBtnStart.setName("btnStart");
			mToolbar.add(mBtnStart);

			//---- mBtnStartNetwork ----
			mBtnStartNetwork.setIcon(new ImageIcon(getClass().getResource("/icons/start_network_game.gif")));
			mBtnStartNetwork.setToolTipText("Start network game");
			mBtnStartNetwork.setName("btnStartNetwork");
			mToolbar.add(mBtnStartNetwork);
		}
		add(mToolbar, cc.xywh(1, 1, 3, 1));

		//======== mTabbedPane ========
		{
			mTabbedPane.setName("tabbedPane");
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
	private JButton mBtnStart;
	private JButton mBtnStartNetwork;
	private JTabbedPane mTabbedPane;
	private JLabel mLStatus;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
