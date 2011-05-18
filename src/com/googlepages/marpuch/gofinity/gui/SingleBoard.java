package com.googlepages.marpuch.gofinity.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import lombok.Getter;

import com.googlepages.marpuch.gofinity.entity.BoardContent;
import com.googlepages.marpuch.gofinity.entity.FieldContent;

public class SingleBoard {

	@Getter private final BufferedImage boardImage;
	private final BoardContent boardContent;
	private final Graphics2D graphics;

	private final int singleRowHeight;
	private final int radius;

	public SingleBoard(final BoardContent boardContent, final int singleRowHeight) {
		this.boardContent = boardContent;
		this.singleRowHeight = singleRowHeight;
		this.radius = singleRowHeight - 1;

		int boardSize = boardContent.getSize() * singleRowHeight;
		boardImage = new BufferedImage(boardSize, boardSize, BufferedImage.TYPE_INT_RGB);
		graphics = (Graphics2D) boardImage.getGraphics();
		drawBoard();
	}

	public void drawBoard()
	{
		cleanBoard();
		drawLines();
		drawStones();
	}

	private void cleanBoard() {
		// TODO localize me
		graphics.setColor(Color.lightGray);
		graphics.fillRect(0, 0, boardImage.getWidth(), boardImage.getHeight());
	}

	private void drawLines() {
		// TODO localize me
		graphics.setColor(Color.black);
		// vertical
		int xCoordinate = singleRowHeight/2;
		for (int i = 0; i < boardContent.getSize(); i++)
		{
			graphics.drawLine(xCoordinate, 0, xCoordinate, boardImage.getHeight());
			if (i == 0)
				graphics.drawLine(xCoordinate+1, 0, xCoordinate+1, boardImage.getHeight());
			xCoordinate += singleRowHeight;
		}
		// horizontal
		int yCoordinate = singleRowHeight/2;
		for (int i = 0; i < boardContent.getSize(); i++)
		{
			graphics.drawLine(0, yCoordinate, boardImage.getWidth(), yCoordinate);
			if (i == 0)
				graphics.drawLine(0, yCoordinate+1, boardImage.getWidth(), yCoordinate+1);
			yCoordinate += singleRowHeight;
		}
	}

	private void drawStones() {
		for (int x = 0; x < boardContent.getSize(); x++)
		{
			for (int y = 0; y < boardContent.getSize(); y++)
			{
				drawStone(x, y, boardContent.getFieldContent(x, y));
			}
		}
	}

	private void drawStone(final int x, final int y, final FieldContent fieldContent) {
		if (fieldContent.equals(fieldContent.WHITE) || fieldContent.equals(fieldContent.BLACK))
		{
			int xCoordinate = getCoordinate(x);
			int yCoordinate = getCoordinate(y);
			drawStoneToImageCoordinates(xCoordinate, yCoordinate, fieldContent);
		}
	}

	private int getCoordinate(final int boardPosition) {
		return boardPosition * singleRowHeight + 1;
	}

	private void drawStoneToImageCoordinates(final int xCoordinate, final int yCoordinate,
			final FieldContent fieldContent) {
		if (FieldContent.WHITE.equals(fieldContent))
		{
			// TODO localize
			graphics.setColor(Color.white);
			graphics.fillOval(xCoordinate, yCoordinate, radius, radius);
			// TODO localize
			graphics.setColor(Color.black);
			graphics.drawOval(xCoordinate, yCoordinate, radius, radius);
		}
		else
		{
			// TODO localize
			graphics.setColor(Color.black);
			graphics.fillOval(xCoordinate, yCoordinate, radius, radius);
		}
	}
}

