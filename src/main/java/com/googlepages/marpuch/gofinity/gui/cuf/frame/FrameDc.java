package com.googlepages.marpuch.gofinity.gui.cuf.frame;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;

import com.googlepages.marpuch.gofinity.util.LoggerFactory;
import com.googlepages.marpuch.gofinity.util.ResourceUtils;
import com.sdm.util.ui.builder.SwingXMLBuilder;
import com.sdm.util.ui.fw.Dc;
import com.sdm.util.ui.fw2.AbstractAppDc;
import com.sdm.util.ui.fw2.CloseDialogEvent;

public class FrameDc extends AbstractAppDc {

	private static final Log log = LoggerFactory.create();

	private SwingXMLBuilder builder;
	private FramePc pc;

	@Override
	public void init(final Dc parent, final Map<String, ? super Object> args) {
		super.init(parent, args);
		log.debug("init");
		initBuilder();
		initPc(args);
	}

	private void initBuilder() {
		InputStream in = ResourceUtils
		.getClassPathResourceAsStream("com/googlepages/marpuch/gofinity/gui/cuf/frame/frame.xml");
		Map<String, Object> nonVisual = new HashMap<String, Object>();
		nonVisual.put("FrameDc", this);
		builder = SwingXMLBuilder.create(in, nonVisual);
	}

	private void initPc(final Map<String, ? super Object> args) {
		pc = (FramePc) builder.getNonVisualObject("FramePc");
		Map<String, Object> map = new HashMap<String, Object>(args);
		pc.init(this, map);
	}

	@Override
	public boolean canPassivate() {
		log.debug("canPassivate");
		// TODO ask other dialogs if can passivate
		return mDialogManager.canPassivate();
	}

	@Override
	public void doActivate(final Map<String, ? super Object> pArgs) {
		log.debug("doActivate");
		pc.show();
	}

	@Override
	public void doPassivate(final Map<String, ? super Object> pArgs) {
		log.debug("doPassivate");
		// TODO: passivate child dialogs
		pc.hide();

	}

	public void quit() {
		CloseDialogEvent close = new CloseDialogEvent(this, this, true);
		postAppEvent(close);
	}

}
