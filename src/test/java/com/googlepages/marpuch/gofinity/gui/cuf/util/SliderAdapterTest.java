package com.googlepages.marpuch.gofinity.gui.cuf.util;

import javax.swing.JSlider;

import org.junit.Assert;
import org.junit.Test;

import com.sdm.util.model.ValueHolder;
import com.sdm.util.model.ValueModel;

/**
 * JUnit test of the cuf JSlider adapter.
 * 
 * @author Marek Puchalski
 */
public class SliderAdapterTest {

	/**
	 * Assert, that the sliders initial value is taken over to the value model
	 * when initialized.
	 */
	@Test
	public void testSliderAdapterOk01() {
		JSlider slider = new JSlider(0, 100, 10);
		ValueModel<Integer> vm = new ValueHolder<Integer>();
		new SliderAdapter(slider, vm);
		Assert.assertEquals(Integer.valueOf(10), vm.getValue());
	}

	/**
	 * Assert, that the sliders values are taken over to the value model.
	 */
	@Test
	public void testSliderAdapterOk02() {
		JSlider slider = new JSlider(0, 100, 10);
		ValueModel<Integer> vm = new ValueHolder<Integer>();
		new SliderAdapter(slider, vm);
		slider.setValue(20);
		Assert.assertEquals(Integer.valueOf(20), vm.getValue());
	}

	/**
	 * Assert, that the value models values are propagated to the slider.
	 */
	@Test
	public void testSliderAdapterOk03() {
		JSlider slider = new JSlider(0, 100, 10);
		ValueModel<Integer> vm = new ValueHolder<Integer>();
		new SliderAdapter(slider, vm);
		vm.setValue(20);
		Assert.assertEquals(20, slider.getValue());
	}

}
