package com.googlepages.marpuch.gofinity.gui.cuf.tab.localgame;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

import org.apache.commons.logging.Log;

import com.googlepages.marpuch.gofinity.entity.GameParameters;
import com.googlepages.marpuch.gofinity.gui.cuf.tab.TabDialogDc;
import com.googlepages.marpuch.gofinity.util.LoggerFactory;
import com.googlepages.marpuch.gofinity.util.ResourceUtils;
import com.sdm.util.model.ValueModel;
import com.sdm.util.ui.builder.SwingXMLBuilder;
import com.sdm.util.ui.fw.Dc;

public class LocalGameDc extends TabDialogDc {

	private static final Log log = LoggerFactory.create();

	@Getter private SwingXMLBuilder builder;
	private LocalGamePc pc;

	@Override
	public void init(final Dc parent, final Map<String, ? super Object> args) {
		super.init(parent, args);
		log.debug("init");
		initBuilder();
		initPc(args);
		initValueModels();
	}

	private void initBuilder() {
		InputStream in = ResourceUtils
		.getClassPathResourceAsStream("com/googlepages/marpuch/gofinity/gui/cuf/tab/localgame/localgame.xml");
		Map<String, Object> nonVisual = new HashMap<String, Object>();
		nonVisual.put("LocalGameDc", this);
		builder = SwingXMLBuilder.create(in, nonVisual);
	}

	private void initPc(final Map<String, ? super Object> args) {
		pc = (LocalGamePc) builder.getNonVisualObject("LocalGamePc");
		Map<String, Object> map = new HashMap<String, Object>(args);
		pc.init(this, map);
	}

	private void initValueModels() {
		getGameParametersVM().setValue(new GameParameters());
		pc.bindSliders();
	}

	@Override
	public Object getVisualPresentation() {
		return builder.getByShortName("LocalGamePanel");
	}

	@Override
	public void doActivate(final Map<String, ? super Object> pArgs) {
		log.debug("doActivate");
	}

	@Override
	public void doPassivate(final Map<String, ? super Object> pArgs) {
		log.debug("doPassivate");
	}

	@Override
	public String getTabName() {
		return "Local game";
	}

	public void startGame(){
		log.debug("startGame");
		GameParameters gameParameters = getGameParametersVM().getValue().clone();
		if (log.isDebugEnabled())
			log.debug(gameParameters.toString());
		pc.startGame(gameParameters);
	}

	// //////////////////////////////////////////
	// CUF getters

	@SuppressWarnings("unchecked")
	ValueModel<GameParameters> getGameParametersVM() {
		return (ValueModel<GameParameters>) builder.getNonVisualObject("GameParametersVM");
	}

	@SuppressWarnings("unchecked")
	ValueModel<Integer> getBoardSizeVM() {
		return (ValueModel<Integer>) builder.getNonVisualObject("BoardSizeVM");
	}
}
