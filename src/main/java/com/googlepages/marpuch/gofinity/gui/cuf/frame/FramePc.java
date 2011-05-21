package com.googlepages.marpuch.gofinity.gui.cuf.frame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;

import javax.swing.JFrame;

import com.sdm.util.ui.builder.SwingXMLBuilder;
import com.sdm.util.ui.fw.Dc;
import com.sdm.util.ui.fw2.AbstractAppPc;

public class FramePc extends AbstractAppPc implements SwingXMLBuilder.Backlink {

	private SwingXMLBuilder builder;
	private FrameDc dc;

	@Override
	public void init(final Dc pDc, final Map<String, ? super Object> pArgs) {
		super.init(pDc, pArgs);
		dc = (FrameDc) pDc;
		initFrame();
	}

	private void initFrame() {
		JFrame frame = getFrame();
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent pE) {
				dc.quit();
			}
		});
	}

	@Override
	public void setSwingXMLBuilder(final SwingXMLBuilder pBuilder) {
		builder = pBuilder;
	}

	public void show() {
		getFrame().setVisible(true);
	}

	public void hide() {
		getFrame().setVisible(false);

	}

	// //////////////////////////////////////////
	// CUF getters

	private JFrame getFrame() {
		return (JFrame) builder.getContainerByName("Frame");
	}
}
