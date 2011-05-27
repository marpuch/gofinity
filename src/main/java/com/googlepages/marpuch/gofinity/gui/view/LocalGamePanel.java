package com.googlepages.marpuch.gofinity.gui.view;

import java.awt.CardLayout;
import javax.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.Sizes;
/*
 * Created by JFormDesigner on Mon May 23 21:34:25 CEST 2011
 */



/**
 * @author User #3
 */
public class LocalGamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public LocalGamePanel() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
		mPGameParameters = new JPanel();
		mSeparator1 = compFactory.createSeparator("Game parameters");
		mLabel1 = new JLabel();
		mSSize = new JSlider();
		mLabel2 = new JLabel();
		mSHandicap = new JSlider();
		mLabel3 = new JLabel();
		mCheckBox1 = new JCheckBox();
		mLabel9 = new JLabel();
		mCbKomi = new JComboBox();
		mSeparator2 = compFactory.createSeparator("Time settings");
		mLabel5 = new JLabel();
		mSInitialTime = new JSpinner();
		mLabel7 = new JLabel();
		mLabel6 = new JLabel();
		mSOvertime = new JSpinner();
		mLabel8 = new JLabel();
		mPanel1 = new JPanel();
		mBtnCloseParam = new JButton();
		mBtnPlay = new JButton();
		mPGame = new MainPanel();
		CellConstraints cc = new CellConstraints();

		//======== this ========
		setName("this");
		setLayout(new CardLayout());

		//======== mPGameParameters ========
		{
			mPGameParameters.setName("pGameParameters");
			mPGameParameters.setLayout(new FormLayout(
				new ColumnSpec[] {
					FormFactory.DEFAULT_COLSPEC,
					new ColumnSpec(Sizes.DLUX3),
					new ColumnSpec("max(min;50dlu)"),
					new ColumnSpec(Sizes.DLUX3),
					new ColumnSpec(ColumnSpec.FILL, Sizes.DEFAULT, 1.0)
				},
				new RowSpec[] {
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.LINE_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.LINE_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.LINE_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.LINE_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.UNRELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.LINE_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.LINE_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.LINE_GAP_ROWSPEC,
					new RowSpec(RowSpec.CENTER, Sizes.DEFAULT, 1.0),
					FormFactory.LINE_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC
				}));

			//---- mSeparator1 ----
			mSeparator1.setName("separator1");
			mPGameParameters.add(mSeparator1, cc.xywh(1, 1, 5, 1));

			//---- mLabel1 ----
			mLabel1.setText("Board size");
			mLabel1.setName("label1");
			mPGameParameters.add(mLabel1, cc.xy(1, 3));

			//---- mSSize ----
			mSSize.setMaximum(25);
			mSSize.setMinimum(3);
			mSSize.setValue(9);
			mSSize.setMinorTickSpacing(1);
			mSSize.setPaintLabels(true);
			mSSize.setPaintTicks(true);
			mSSize.setMajorTickSpacing(2);
			mSSize.setSnapToTicks(true);
			mSSize.setName("sSize");
			mPGameParameters.add(mSSize, cc.xywh(3, 3, 3, 1));

			//---- mLabel2 ----
			mLabel2.setText("White handicap");
			mLabel2.setName("label2");
			mPGameParameters.add(mLabel2, cc.xy(1, 5));

			//---- mSHandicap ----
			mSHandicap.setMaximum(10);
			mSHandicap.setPaintTicks(true);
			mSHandicap.setPaintLabels(true);
			mSHandicap.setMinorTickSpacing(1);
			mSHandicap.setMajorTickSpacing(2);
			mSHandicap.setValue(0);
			mSHandicap.setSnapToTicks(true);
			mSHandicap.setName("sHandicap");
			mPGameParameters.add(mSHandicap, cc.xywh(3, 5, 3, 1));

			//---- mLabel3 ----
			mLabel3.setText("Place handicap automaticaly");
			mLabel3.setName("label3");
			mPGameParameters.add(mLabel3, cc.xy(1, 7));

			//---- mCheckBox1 ----
			mCheckBox1.setName("checkBox1");
			mPGameParameters.add(mCheckBox1, cc.xy(3, 7));

			//---- mLabel9 ----
			mLabel9.setText("Komi");
			mLabel9.setName("label9");
			mPGameParameters.add(mLabel9, cc.xy(1, 9));

			//---- mCbKomi ----
			mCbKomi.setModel(new DefaultComboBoxModel(new String[] {
				"0",
				"0,5",
				"5,5",
				"6,5"
			}));
			mCbKomi.setSelectedIndex(1);
			mCbKomi.setName("cbKomi");
			mPGameParameters.add(mCbKomi, cc.xy(3, 9));

			//---- mSeparator2 ----
			mSeparator2.setName("separator2");
			mPGameParameters.add(mSeparator2, cc.xywh(1, 11, 5, 1));

			//---- mLabel5 ----
			mLabel5.setText("Initial time");
			mLabel5.setName("label5");
			mPGameParameters.add(mLabel5, cc.xy(1, 13));

			//---- mSInitialTime ----
			mSInitialTime.setName("sInitialTime");
			mPGameParameters.add(mSInitialTime, cc.xy(3, 13));

			//---- mLabel7 ----
			mLabel7.setText("[hh:mm]");
			mLabel7.setName("label7");
			mPGameParameters.add(mLabel7, cc.xy(5, 13));

			//---- mLabel6 ----
			mLabel6.setText("Overtime");
			mLabel6.setName("label6");
			mPGameParameters.add(mLabel6, cc.xy(1, 15));

			//---- mSOvertime ----
			mSOvertime.setName("sOvertime");
			mPGameParameters.add(mSOvertime, cc.xy(3, 15));

			//---- mLabel8 ----
			mLabel8.setText("[hh:mm]");
			mLabel8.setName("label8");
			mPGameParameters.add(mLabel8, cc.xy(5, 15));

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
						FormFactory.DEFAULT_ROWSPEC
					}));

				//---- mBtnCloseParam ----
				mBtnCloseParam.setText("Close");
				mBtnCloseParam.setMnemonic('C');
				mBtnCloseParam.setName("btnCloseParam");
				mPanel1.add(mBtnCloseParam, cc.xy(1, 1));

				//---- mBtnPlay ----
				mBtnPlay.setText("Play");
				mBtnPlay.setIcon(new ImageIcon(getClass().getResource("/icons/start_game.gif")));
				mBtnPlay.setMnemonic('P');
				mBtnPlay.setName("btnPlay");
				mPanel1.add(mBtnPlay, cc.xy(3, 1));
			}
			mPGameParameters.add(mPanel1, cc.xy(5, 19, CellConstraints.RIGHT, CellConstraints.DEFAULT));
		}
		add(mPGameParameters, "card1");

		//---- mPGame ----
		mPGame.setName("pGame");
		add(mPGame, "card2");
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel mPGameParameters;
	private JComponent mSeparator1;
	private JLabel mLabel1;
	private JSlider mSSize;
	private JLabel mLabel2;
	private JSlider mSHandicap;
	private JLabel mLabel3;
	private JCheckBox mCheckBox1;
	private JLabel mLabel9;
	private JComboBox mCbKomi;
	private JComponent mSeparator2;
	private JLabel mLabel5;
	private JSpinner mSInitialTime;
	private JLabel mLabel7;
	private JLabel mLabel6;
	private JSpinner mSOvertime;
	private JLabel mLabel8;
	private JPanel mPanel1;
	private JButton mBtnCloseParam;
	private JButton mBtnPlay;
	private MainPanel mPGame;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
