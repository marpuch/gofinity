package com.googlepages.marpuch.gofinity.gui.view;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.*;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.*;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.googlepages.marpuch.gofinity.entity.GameParameters;
import com.googlepages.marpuch.gofinity.logic.spec.GameLogicBCI;
import com.googlepages.marpuch.gofinity.util.Registry;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.Sizes;

/**
 * @author User #3
 */
public class MainPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private GameLogicBCI gameLogic;

	public MainPanel() {
		initComponents();
		initBoardResizing();
	}

	public void init(final GameParameters gameParameters) {
		gameLogic = Registry.getObject(GameLogicBCI.class);
		gameLogic.init(gameParameters);
		mGamePanel1.initBoard(gameLogic, mSlider1.getValue());
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
		mSlider1 = new JSlider();
		mPanel1 = new JPanel();
		mGamePanel1 = new GamePanel();
		mPanel2 = new JPanel();
		mSeparator1 = compFactory.createSeparator("Game status");
		mLabel4 = new JLabel();
		mLabel1 = new JLabel();
		mLabel5 = new JLabel();
		mLabel2 = new JLabel();
		mLBlackPrisoners = new JLabel();
		mLabel7 = new JLabel();
		mLWhitePrisoners = new JLabel();
		mLabel8 = new JLabel();
		mLBlackTime = new JLabel();
		mLabel11 = new JLabel();
		mLWhiteTime = new JLabel();
		mLabel12 = new JLabel();
		mPanel3 = new JPanel();
		mButton1 = new JButton();
		mButton2 = new JButton();
		mButton3 = new JButton();
		CellConstraints cc = new CellConstraints();

		//======== this ========
		setPreferredSize(new Dimension(600, 400));
		setName("this");
		setLayout(new FormLayout(
			new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				new ColumnSpec(Sizes.DLUX3),
				new ColumnSpec(ColumnSpec.FILL, Sizes.DEFAULT, 1.0),
				new ColumnSpec(Sizes.DLUX3),
				FormFactory.DEFAULT_COLSPEC
			},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.FILL, Sizes.DEFAULT, 1.0),
				FormFactory.LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC
			}));

		//---- mSlider1 ----
		mSlider1.setOrientation(SwingConstants.VERTICAL);
		mSlider1.setMinimum(10);
		mSlider1.setValue(30);
		mSlider1.setSnapToTicks(true);
		mSlider1.setMajorTickSpacing(10);
		mSlider1.setMinorTickSpacing(2);
		mSlider1.setPaintTicks(true);
		mSlider1.setName("slider1");
		add(mSlider1, cc.xywh(1, 1, 1, 4));

		//======== mPanel1 ========
		{
			mPanel1.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
			mPanel1.setName("panel1");
			mPanel1.setLayout(new BorderLayout());

			//---- mGamePanel1 ----
			mGamePanel1.setName("gamePanel1");
			mPanel1.add(mGamePanel1, BorderLayout.CENTER);
		}
		add(mPanel1, cc.xywh(3, 1, 1, 4));

		//======== mPanel2 ========
		{
			mPanel2.setName("panel2");
			mPanel2.setLayout(new FormLayout(
				new ColumnSpec[] {
					new ColumnSpec("max(default;50dlu)"),
					new ColumnSpec(Sizes.DLUX3),
					FormFactory.DEFAULT_COLSPEC,
					new ColumnSpec(Sizes.dluX(20)),
					new ColumnSpec("max(default;50dlu)"),
					new ColumnSpec(Sizes.DLUX3),
					FormFactory.DEFAULT_COLSPEC
				},
				new RowSpec[] {
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.LINE_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.LINE_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.LINE_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC
				}));

			//---- mSeparator1 ----
			mSeparator1.setName("separator1");
			mPanel2.add(mSeparator1, cc.xywh(1, 1, 7, 1));

			//---- mLabel4 ----
			mLabel4.setIcon(new ImageIcon(getClass().getResource("/icons/black_stone.png")));
			mLabel4.setName("label4");
			mPanel2.add(mLabel4, cc.xy(1, 3, CellConstraints.CENTER, CellConstraints.DEFAULT));

			//---- mLabel1 ----
			mLabel1.setText("Black");
			mLabel1.setFont(new Font("Tahoma", Font.PLAIN, 26));
			mLabel1.setName("label1");
			mPanel2.add(mLabel1, cc.xy(3, 3));

			//---- mLabel5 ----
			mLabel5.setIcon(new ImageIcon(getClass().getResource("/icons/white_stone.png")));
			mLabel5.setName("label5");
			mPanel2.add(mLabel5, cc.xy(5, 3, CellConstraints.CENTER, CellConstraints.DEFAULT));

			//---- mLabel2 ----
			mLabel2.setText("White");
			mLabel2.setFont(new Font("Tahoma", Font.PLAIN, 26));
			mLabel2.setName("label2");
			mPanel2.add(mLabel2, cc.xy(7, 3));

			//---- mLBlackPrisoners ----
			mLBlackPrisoners.setText("0");
			mLBlackPrisoners.setName("lBlackPrisoners");
			mPanel2.add(mLBlackPrisoners, cc.xy(1, 5, CellConstraints.CENTER, CellConstraints.DEFAULT));

			//---- mLabel7 ----
			mLabel7.setText("prisoners");
			mLabel7.setName("label7");
			mPanel2.add(mLabel7, cc.xy(3, 5));

			//---- mLWhitePrisoners ----
			mLWhitePrisoners.setText("0");
			mLWhitePrisoners.setName("lWhitePrisoners");
			mPanel2.add(mLWhitePrisoners, cc.xy(5, 5, CellConstraints.CENTER, CellConstraints.DEFAULT));

			//---- mLabel8 ----
			mLabel8.setText("prisoners");
			mLabel8.setName("label8");
			mPanel2.add(mLabel8, cc.xy(7, 5));

			//---- mLBlackTime ----
			mLBlackTime.setText("1h 22min");
			mLBlackTime.setName("lBlackTime");
			mPanel2.add(mLBlackTime, cc.xy(1, 7, CellConstraints.CENTER, CellConstraints.DEFAULT));

			//---- mLabel11 ----
			mLabel11.setText("time left");
			mLabel11.setName("label11");
			mPanel2.add(mLabel11, cc.xy(3, 7));

			//---- mLWhiteTime ----
			mLWhiteTime.setText("32 min 3 sek");
			mLWhiteTime.setName("lWhiteTime");
			mPanel2.add(mLWhiteTime, cc.xy(5, 7, CellConstraints.CENTER, CellConstraints.DEFAULT));

			//---- mLabel12 ----
			mLabel12.setText("time left");
			mLabel12.setName("label12");
			mPanel2.add(mLabel12, cc.xy(7, 7));
		}
		add(mPanel2, cc.xy(5, 1));

		//======== mPanel3 ========
		{
			mPanel3.setName("panel3");
			mPanel3.setLayout(new FormLayout(
				new ColumnSpec[] {
					FormFactory.DEFAULT_COLSPEC,
					new ColumnSpec(Sizes.DLUX3),
					FormFactory.DEFAULT_COLSPEC,
					new ColumnSpec(Sizes.DLUX3),
					new ColumnSpec(ColumnSpec.FILL, Sizes.DEFAULT, 1.0),
					new ColumnSpec(Sizes.DLUX3),
					FormFactory.DEFAULT_COLSPEC
				},
				new RowSpec[] {
					FormFactory.DEFAULT_ROWSPEC
				}));

			//---- mButton1 ----
			mButton1.setText("Pass");
			mButton1.setMnemonic('P');
			mButton1.setIcon(new ImageIcon(getClass().getResource("/icons/pass.gif")));
			mButton1.setName("button1");
			mPanel3.add(mButton1, cc.xy(1, 1));

			//---- mButton2 ----
			mButton2.setText("Resign");
			mButton2.setMnemonic('R');
			mButton2.setIcon(new ImageIcon(getClass().getResource("/icons/resign.gif")));
			mButton2.setName("button2");
			mPanel3.add(mButton2, cc.xy(3, 1));

			//---- mButton3 ----
			mButton3.setText("Quit");
			mButton3.setMnemonic('Q');
			mButton3.setName("button3");
			mPanel3.add(mButton3, cc.xy(7, 1));
		}
		add(mPanel3, cc.xy(5, 4));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	private void initBoardResizing() {
		mGamePanel1.initBoard(gameLogic, mSlider1.getValue());
		mSlider1.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(final ChangeEvent e) {
				mGamePanel1.initBoard(gameLogic, mSlider1.getValue());
				mGamePanel1.repaint();
			}
		});
		addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(final MouseWheelEvent e) {
				if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
					mSlider1.setValue(mSlider1.getValue() - 2
							* e.getWheelRotation());
					e.consume();
				}
			}
		});
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JSlider mSlider1;
	private JPanel mPanel1;
	private GamePanel mGamePanel1;
	private JPanel mPanel2;
	private JComponent mSeparator1;
	private JLabel mLabel4;
	private JLabel mLabel1;
	private JLabel mLabel5;
	private JLabel mLabel2;
	private JLabel mLBlackPrisoners;
	private JLabel mLabel7;
	private JLabel mLWhitePrisoners;
	private JLabel mLabel8;
	private JLabel mLBlackTime;
	private JLabel mLabel11;
	private JLabel mLWhiteTime;
	private JLabel mLabel12;
	private JPanel mPanel3;
	private JButton mButton1;
	private JButton mButton2;
	private JButton mButton3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
