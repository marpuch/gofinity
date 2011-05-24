package com.googlepages.marpuch.gofinity.gui.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.googlepages.marpuch.gofinity.entity.GameParameters;
import com.googlepages.marpuch.gofinity.logic.spec.GameLogicBCI;
import com.googlepages.marpuch.gofinity.util.Registry;
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
		mSlider1 = new JSlider();
		mPanel1 = new JPanel();
		mGamePanel1 = new GamePanel();
		CellConstraints cc = new CellConstraints();

		//======== this ========
		setPreferredSize(new Dimension(600, 400));
		setName("this");
		setLayout(new FormLayout(
				new ColumnSpec[] {
						FormFactory.DEFAULT_COLSPEC,
						new ColumnSpec(Sizes.DLUX3),
						new ColumnSpec(ColumnSpec.FILL, Sizes.DEFAULT, 1.0)
				},
				new RowSpec[] {
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.LINE_GAP_ROWSPEC,
						new RowSpec(RowSpec.FILL, Sizes.DEFAULT, 1.0)
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
		add(mSlider1, cc.xywh(1, 1, 1, 3));

		//======== mPanel1 ========
		{
			mPanel1.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
			mPanel1.setName("panel1");
			mPanel1.setLayout(new BorderLayout());

			//---- mGamePanel1 ----
			mGamePanel1.setName("gamePanel1");
			mPanel1.add(mGamePanel1, BorderLayout.CENTER);
		}
		add(mPanel1, cc.xy(3, 3));
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
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
