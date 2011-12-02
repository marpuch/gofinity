package com.googlepages.marpuch.gofinity.gui.images;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import lombok.Getter;

import com.googlepages.marpuch.gofinity.entity.BoardContent;
import com.googlepages.marpuch.gofinity.entity.FieldContent;
import com.googlepages.marpuch.gofinity.entity.GameParameters;
import com.googlepages.marpuch.gofinity.logic.spec.GameLogicBCI;

public class AbstractBoardImage {

	private static final ImageIcon blackStoneFull = new ImageIcon(AbstractBoardImage.class.getResource("/icons/black64.png"));
	private static final ImageIcon whiteStoneFull = new ImageIcon(AbstractBoardImage.class.getResource("/icons/white64.png"));

	@Getter protected final BufferedImage boardImage;
	protected final Graphics2D graphics;
	protected final BoardContent boardContent;
	protected final int singleFieldSize;
	protected final int imageSize;
	protected final GameParameters gameParameters;
	protected final int radius;
	protected final Image blackStoneScaled;
	protected final Image whiteStoneScaled;

	public AbstractBoardImage(final GameLogicBCI gameLogic, final int singleFieldSize) {
		super();
		this.boardContent = gameLogic.getBoardContent();
		this.singleFieldSize = singleFieldSize;
		this.gameParameters = gameLogic.getGameParameters();
		this.radius = singleFieldSize;
		imageSize = boardContent.getSize() * singleFieldSize;
		boardImage = new BufferedImage(imageSize, imageSize, BufferedImage.TYPE_INT_ARGB);
		graphics = (Graphics2D) boardImage.getGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		blackStoneScaled = blackStoneFull.getImage().getScaledInstance(radius, radius, Image.SCALE_SMOOTH);
		whiteStoneScaled = whiteStoneFull.getImage().getScaledInstance(radius, radius, Image.SCALE_SMOOTH);
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

	protected void drawStoneToImageCoordinates(final int xCoordinate, final int yCoordinate,
			final FieldContent fieldContent) {
		if (FieldContent.WHITE.equals(fieldContent))
		{
			graphics.drawImage(whiteStoneScaled, xCoordinate, yCoordinate, radius, radius, null);
		}
		else
		{
			graphics.drawImage(blackStoneScaled, xCoordinate, yCoordinate, radius, radius, null);
		}
	}

	protected void drawStoneToImageCoordinates(final int xCoordinate, final int yCoordinate, final FieldContent fieldContent, final float alpha)
	{
		Composite backup = graphics.getComposite();
		graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		drawStoneToImageCoordinates(xCoordinate, yCoordinate, fieldContent);
		graphics.setComposite(backup);
	}

	protected int getCoordinate(final int boardPosition) {
		return boardPosition * singleFieldSize;
	}

	protected int getBoardCoordinate(final int panelCoordinate) {
		if (panelCoordinate < 0)
			return -1;
		int trimmedCoordinate = panelCoordinate % imageSize;
		return trimmedCoordinate / singleFieldSize;
	}

	public Point getBoardCoordinates(final int xCoordinate, final int yCoordinate) {
		return new Point(getBoardCoordinate(xCoordinate), getBoardCoordinate(yCoordinate));
	}
}