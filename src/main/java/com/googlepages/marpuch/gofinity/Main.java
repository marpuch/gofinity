package com.googlepages.marpuch.gofinity;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;

import com.googlepages.marpuch.gofinity.util.LoggerFactory;
import com.googlepages.marpuch.gofinity.util.Registry;
import com.sdm.util.ui.fw.Dc;
import com.sdm.util.ui.fw2.AbstractDialogApplication;
import com.sdm.util.ui.fw2.DialogDescription;
import com.sdm.util.ui.fw2.DialogManager;
import com.sdm.util.ui.fw2.OpenDialogEvent;

public class Main extends AbstractDialogApplication
{
	private static final Log log = LoggerFactory.create();

	/**
	 * Main class of the gofinity project. Run this class with the
	 * -Dswing.defaultlaf=com.seaglasslookandfeel.SeaGlassLookAndFeel flag set.
	 * 
	 * @param args
	 *            Command line arguments.
	 */
	public static void main(final String[] args)
	{
		log.debug("Starting gofinity...");
		Main main = new Main();
		main.start(args);
	}

	@Override
	public void start(final String[] args) {
		super.start(args);

		Registry.init();

		Map<String, DialogDescription> knownDialogs = DialogDescription
		.loadKnownDialogs("cuf_main.properties");
		mDialogManager.setKnownDialogs(knownDialogs);
		mDialogManager.setCallback(new DialogManager.DialogCallback() {

			@Override
			public void dialogOpened(final Dc pDc,
					final Map<String, Object> pArgs) {
				// nothing
			}

			@Override
			public void dialogClosed(final Dc pDc, final boolean pWasClosed,
					final Map<String, Object> pArgs) {
				if (mDialogManager.getActiveDialogs().isEmpty()) {
					stop();
				}
			}

		});

		Map<String, Object> map = new HashMap<String, Object>();
		OpenDialogEvent openDialogEvent = new OpenDialogEvent(this,	"FrameDc", map);
		postAppEvent(openDialogEvent);
	}

	@Override
	public void stop() {
		log.debug("Stoping gofinity.");
		System.exit(0);
	}

}
