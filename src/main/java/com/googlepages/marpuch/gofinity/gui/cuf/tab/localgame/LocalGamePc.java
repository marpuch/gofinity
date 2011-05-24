package com.googlepages.marpuch.gofinity.gui.cuf.tab.localgame;

import java.awt.CardLayout;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JSlider;

import com.googlepages.marpuch.gofinity.entity.GameParameters;
import com.googlepages.marpuch.gofinity.gui.cuf.util.SliderAdapter;
import com.googlepages.marpuch.gofinity.gui.view.MainPanel;
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

	public void startGame(final GameParameters gameParameters) {
		getGamePanel().init(gameParameters);
		switchToGamePanel();
	}

	private void switchToGamePanel() {
		JPanel panel = getRootPanel();
		CardLayout layout = (CardLayout) panel.getLayout();
		layout.next(panel);
	}

	// //////////////////////////////////////////
	// CUF getters

	private JSlider getBoardSizeSlider() {
		return (JSlider) builder.getByShortName("sSize");
	}

	private JPanel getRootPanel() {
		JPanel panel = getGamePanel();
		return (JPanel) panel.getParent();
	}

	private MainPanel getGamePanel() {
		return (MainPanel) builder.getComponentByAnyName("pGame");
	}
}
