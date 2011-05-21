package com.googlepages.marpuch.gofinity;

import org.apache.commons.logging.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.googlepages.marpuch.gofinity.gui.MainFrame;
import com.googlepages.marpuch.gofinity.util.LoggerFactory;

public class Main
{
	private static final Log log = LoggerFactory.create();

	public static void main(final String[] args)
	{
		log.debug("Starting gofinity...");

		ApplicationContext context = new ClassPathXmlApplicationContext("default-beans.xml");

		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
