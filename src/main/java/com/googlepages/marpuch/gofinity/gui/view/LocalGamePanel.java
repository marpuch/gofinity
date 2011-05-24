package com.googlepages.marpuch.gofinity.gui.view;

import java.awt.CardLayout;

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
		mPanel1 = new JPanel();
		mSeparator1 = compFactory.createSeparator("Game parameters");
		mLabel1 = new JLabel();
		mSSize = new JSlider();
		mLabel2 = new JLabel();
		mSHandicap = new JSlider();
		mLabel3 = new JLabel();
		mCheckBox1 = new JCheckBox();
		mLabel4 = new JLabel();
		mCheckBox2 = new JCheckBox();
		mBtnPlay = new JButton();
		mPanel2 = new MainPanel();
		CellConstraints cc = new CellConstraints();

		//======== this ========
		setName("this");
		setLayout(new CardLayout());

		//======== mPanel1 ========
		{
			mPanel1.setName("panel1");
			mPanel1.setLayout(new FormLayout(
					new ColumnSpec[] {
							FormFactory.DEFAULT_COLSPEC,
							new ColumnSpec(Sizes.DLUX3),
							new ColumnSpec("max(default;50dlu):grow")
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
							FormFactory.LINE_GAP_ROWSPEC,
							new RowSpec(RowSpec.CENTER, Sizes.DEFAULT, 1.0),
							FormFactory.LINE_GAP_ROWSPEC,
							FormFactory.DEFAULT_ROWSPEC
					}));

			//---- mSeparator1 ----
			mSeparator1.setName("separator1");
			mPanel1.add(mSeparator1, cc.xywh(1, 1, 3, 1));

			//---- mLabel1 ----
			mLabel1.setText("Board size");
			mLabel1.setName("label1");
			mPanel1.add(mLabel1, cc.xy(1, 3));

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
			mPanel1.add(mSSize, cc.xy(3, 3));

			//---- mLabel2 ----
			mLabel2.setText("White handicap");
			mLabel2.setName("label2");
			mPanel1.add(mLabel2, cc.xy(1, 5));

			//---- mSHandicap ----
			mSHandicap.setMaximum(10);
			mSHandicap.setPaintTicks(true);
			mSHandicap.setPaintLabels(true);
			mSHandicap.setMinorTickSpacing(1);
			mSHandicap.setMajorTickSpacing(2);
			mSHandicap.setValue(0);
			mSHandicap.setSnapToTicks(true);
			mSHandicap.setName("sHandicap");
			mPanel1.add(mSHandicap, cc.xy(3, 5));

			//---- mLabel3 ----
			mLabel3.setText("Place handicap automaticaly");
			mLabel3.setName("label3");
			mPanel1.add(mLabel3, cc.xy(1, 7));

			//---- mCheckBox1 ----
			mCheckBox1.setName("checkBox1");
			mPanel1.add(mCheckBox1, cc.xy(3, 7));

			//---- mLabel4 ----
			mLabel4.setText("Allow self-atari");
			mLabel4.setName("label4");
			mPanel1.add(mLabel4, cc.xy(1, 9));

			//---- mCheckBox2 ----
			mCheckBox2.setName("checkBox2");
			mPanel1.add(mCheckBox2, cc.xy(3, 9));

			//---- mBtnPlay ----
			mBtnPlay.setText("Play");
			mBtnPlay.setIcon(new ImageIcon(getClass().getResource("/icons/start_game.gif")));
			mBtnPlay.setName("btnPlay");
			mPanel1.add(mBtnPlay, cc.xy(3, 13, CellConstraints.RIGHT, CellConstraints.DEFAULT));
		}
		add(mPanel1, "card1");

		//---- mPanel2 ----
		mPanel2.setName("panel2");
		add(mPanel2, "card2");
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel mPanel1;
	private JComponent mSeparator1;
	private JLabel mLabel1;
	private JSlider mSSize;
	private JLabel mLabel2;
	private JSlider mSHandicap;
	private JLabel mLabel3;
	private JCheckBox mCheckBox1;
	private JLabel mLabel4;
	private JCheckBox mCheckBox2;
	private JButton mBtnPlay;
	private MainPanel mPanel2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
