package com.googlepages.marpuch.gofinity;

import org.apache.commons.logging.Log;

import com.googlepages.marpuch.gofinity.gui.MainFrame;
import com.googlepages.marpuch.gofinity.util.LoggerFactory;
import com.googlepages.marpuch.gofinity.util.Registry;

public class Main
{
	private static final Log log = LoggerFactory.create();

	public static void main(final String[] args)
	{
		log.debug("Starting gofinity...");

		Registry.init();

		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
