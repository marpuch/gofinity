package com.googlepages.marpuch.gofinity.gui.images;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import lombok.Getter;

import com.googlepages.marpuch.gofinity.entity.BoardContent;

public class AbstractBoardImage {

	@Getter	protected final BufferedImage boardImage;
	protected final Graphics2D graphics;
	protected final BoardContent boardContent;
	protected final int singleFieldSize;
	protected final int imageSize;

	public AbstractBoardImage(final BoardContent boardContent, final int singleFieldSize) {
		super();
		this.boardContent = boardContent;
		this.singleFieldSize = singleFieldSize;
		imageSize = boardContent.getSize() * singleFieldSize;
		boardImage = new BufferedImage(imageSize, imageSize, BufferedImage.TYPE_INT_ARGB);
		graphics = (Graphics2D) boardImage.getGraphics();
	}

	/**
	 * Clears the BufferedImage.
	 * @see http://blog.keilly.com/2007/09/clear-bufferedimage-in-java.html
	 */
	protected void clearImage() {
		Composite backup = graphics.getComposite();
		graphics.setComposite(
				AlphaComposite.getInstance(AlphaComposite.CLEAR, 0.0f));
		Rectangle2D.Double rect =
			new Rectangle2D.Double(0, 0, boardImage.getWidth(), boardImage.getHeight());
		graphics.fill(rect);
		graphics.setComposite(backup);
	}

}