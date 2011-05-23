package com.googlepages.marpuch.gofinity.gui.view;

import java.awt.Dimension;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

	public MainPanel() {
		initComponents();
		initBoardResizing();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		mSlider1 = new JSlider();
		mGamePanel1 = new GamePanel();
		CellConstraints cc = new CellConstraints();

		//======== this ========
		setPreferredSize(new Dimension(600, 400));
		setName("this");
		setLayout(new FormLayout(
				new ColumnSpec[] {
						new ColumnSpec(Sizes.DLUX3),
						new ColumnSpec(ColumnSpec.FILL, Sizes.DEFAULT, 1.0),
						new ColumnSpec(Sizes.DLUX3),
						new ColumnSpec("max(default;20dlu)")
				},
				new RowSpec[] {
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.LINE_GAP_ROWSPEC,
						new RowSpec(RowSpec.FILL, Sizes.DEFAULT, 1.0),
						FormFactory.LINE_GAP_ROWSPEC
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
		add(mSlider1, cc.xywh(4, 1, 1, 3));

		//---- mGamePanel1 ----
		mGamePanel1.setName("gamePanel1");
		add(mGamePanel1, cc.xy(2, 3));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	private void initBoardResizing() {
		mGamePanel1.initBoard(mSlider1.getValue());
		mSlider1.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(final ChangeEvent e) {
				mGamePanel1.initBoard(mSlider1.getValue());
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
	private GamePanel mGamePanel1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
