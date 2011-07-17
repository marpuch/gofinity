package com.googlepages.marpuch.gofinity.gui.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.googlepages.marpuch.gofinity.gui.images.AbstractBoardImage;
import com.googlepages.marpuch.gofinity.gui.images.OverBoardMarkings;
import com.googlepages.marpuch.gofinity.gui.images.SingleBoard;
import com.googlepages.marpuch.gofinity.logic.spec.GameLogicBCI;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private ImageIcon gobanWood = new ImageIcon(getClass().getResource("/icons/board.jpg"));
	private SingleBoard singleBoard;
	private OverBoardMarkings overBoardMarkings;
	private GameLogicBCI gameLogic;

	public GamePanel() {
		super();
		initMouseListener();
	}

	public void initBoard(final GameLogicBCI gameLogic, final int singleFieldSize) {
		if (gameLogic == null)
			return;
		this.gameLogic = gameLogic;
		singleBoard = new SingleBoard(gameLogic, singleFieldSize);
		overBoardMarkings = new OverBoardMarkings(gameLogic, singleFieldSize);
	}

	@Override
	public void paint(final Graphics g) {
		drawBoards((Graphics2D) g);
	}

	private void drawBoards(final Graphics2D g) {
		drawGobanWood(g);
		drawBoard(g, singleBoard);
		drawBoard(g, overBoardMarkings);
	}

	private void drawGobanWood(Graphics2D g) {
		Dimension panelSize = getSize();
		Dimension singleBoardSize = new Dimension(gobanWood.getIconWidth(), gobanWood.getIconHeight());
		for (int x = 0; x < panelSize.width; x += singleBoardSize.width) {
			for (int y = 0; y < panelSize.height; y += singleBoardSize.height) {
				g.drawImage(gobanWood.getImage(), x, y, singleBoardSize.width, singleBoardSize.height, (ImageObserver) null);
			}
		}
	}

	private void drawBoard(final Graphics2D g, final AbstractBoardImage boardImage) {
		if (boardImage == null)
			return;
		Dimension panelSize = getSize();
		Dimension singleBoardSize = new Dimension(boardImage.getBoardImage().getWidth(), boardImage.getBoardImage().getHeight());
		for (int x = 0; x < panelSize.width; x += singleBoardSize.width) {
			for (int y = 0; y < panelSize.height; y += singleBoardSize.height) {
				g.drawImage(boardImage.getBoardImage(), x, y, singleBoardSize.width, singleBoardSize.height, (ImageObserver) null);
			}
		}
	}

	private void initMouseListener() {
		addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(final MouseEvent e) {
				e.consume();
				updateCursorPosition(e.getX(), e.getY());
			}
		});
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(final MouseEvent e) {
				e.consume();
				updateCursorPosition(-1, -1);
			}

			@Override
			public void mouseClicked(final MouseEvent e) {
				e.consume();
				Point point = singleBoard.getBoardCoordinates(e.getX(), e.getY());
				if (gameLogic.putStone(point.x, point.y)) {
					singleBoard.drawBoard();
					overBoardMarkings.handleMouseMove(-1, -1);
					repaint();
				}
			}
		});
	}

	private void updateCursorPosition(final int x, final int y) {
		if (overBoardMarkings == null)
			return;
		overBoardMarkings.handleMouseMove(x, y);
		if (overBoardMarkings.isChanged()) {
			repaint();
		}
	}

}
