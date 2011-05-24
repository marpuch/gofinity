package com.googlepages.marpuch.gofinity.gui.cuf.util;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.googlepages.marpuch.gofinity.util.Precondition;
import com.sdm.util.model.ValueModel;

/**
 * This class defines a cuf adapter - a class that updates the value model when
 * the widget values change and also updates the widget when the value model
 * values change.
 * 
 * Cuf does not come with a default adapter for handling JSliders so we must
 * implement one ourself.
 * 
 * @author Marek Puchalski
 */
public class SliderAdapter {

	public SliderAdapter(final JSlider slider, final ValueModel<Integer> model) {
		Precondition.notNull(slider, "slider");
		Precondition.notNull(model, "model");

		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(final ChangeEvent e) {
				if (slider.getValueIsAdjusting())
					return;
				else
					model.setValue(slider.getValue());
			}
		});
		model.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(final ChangeEvent e) {
				slider.setValue(model.getValue());
			}
		});
		model.setValue(slider.getValue());
	}

}
