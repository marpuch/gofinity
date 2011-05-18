package com.googlepages.marpuch.gofinity.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;

import com.googlepages.marpuch.gofinity.entity.BoardContent;
import com.googlepages.marpuch.gofinity.entity.FieldContent;


public class GamePanel extends JPanel
{
	private SingleBoard singleBoard;

	public GamePanel() {
		super();
	}

	public void initSingleBoard(final int singleFieldSize) {
		// TODO move elsewhere
		BoardContent bc = new BoardContent(9);
		bc.setFieldContent(1, 1, FieldContent.WHITE);
		bc.setFieldContent(3, 4, FieldContent.BLACK);
		bc.setFieldContent(0, 4, FieldContent.BLACK);
		bc.setFieldContent(4, 0, FieldContent.WHITE);
		bc.setFieldContent(0, 0, FieldContent.WHITE);
		this.singleBoard = new SingleBoard(bc, singleFieldSize);
	}

	@Override
	public void paint(final Graphics g) {
		drawBoards((Graphics2D) g);
	}

	private void drawBoards(final Graphics2D g) {
		if (singleBoard == null)
			return;
		Dimension panelSize = getSize();
		Dimension singleBoardSize = new Dimension(singleBoard.getBoardImage().getWidth(), singleBoard.getBoardImage().getHeight());
		for (int x = 0; x < panelSize.width; x += singleBoardSize.width)
		{
			for (int y = 0; y < panelSize.height; y+= singleBoardSize.height)
			{
				g.drawImage(singleBoard.getBoardImage(), x, y, singleBoardSize.width, singleBoardSize.height, (ImageObserver) null);
			}
		}
	}
}
