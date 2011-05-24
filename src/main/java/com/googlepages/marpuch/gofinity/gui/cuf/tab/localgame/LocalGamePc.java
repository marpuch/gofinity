package com.googlepages.marpuch.gofinity.gui.cuf.tab.localgame;

import java.util.Map;

import javax.swing.JSlider;

import com.googlepages.marpuch.gofinity.gui.cuf.util.SliderAdapter;
import com.sdm.util.ui.builder.SwingXMLBuilder;
import com.sdm.util.ui.fw.Dc;
import com.sdm.util.ui.fw2.AbstractDialogPc;

public class LocalGamePc extends AbstractDialogPc {

	private LocalGameDc dc;
	private SwingXMLBuilder builder;

	@Override
	public void init(final Dc dc, final Map<String, ? super Object> args) {
		super.init(dc, args);

		this.dc = (LocalGameDc) dc;
		this.builder = this.dc.getBuilder();
	}

	@Override
	public Object getVisualPresentation() {
		return builder.getByShortName("LocalGamePanel");
	}

	public void bindSliders() {
		new SliderAdapter(getBoardSizeSlider(), dc.getBoardSizeVM());
	}

	// //////////////////////////////////////////
	// CUF getters

	private JSlider getBoardSizeSlider() {
		return (JSlider) builder.getByShortName("sSize");
	}
}
