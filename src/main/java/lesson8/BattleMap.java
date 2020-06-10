package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {
    private GameWindow gameWindow;

    private int gameMode;
    private int fieldSizeX;
    private int fieldSizeY;
    private int dotsToWin;

    private int cellHeight;
    private int cellWidth;
    private int AGE_CELL_DRAW = 6;

    private int ovalWith = (int) (cellWidth/1.5f);
    private boolean isInit = false;

    public BattleMap(GameWindow gameWindow) {
        Color myColor = new Color(210, 250, 255);
        this.gameWindow = gameWindow;
        setBackground(myColor);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (isInit) {
                    mouseReleasedUpdate(e);
                }
            }
        });
    }

    private void mouseReleasedUpdate(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if(!Logic.gameFinished){
            Logic.setHumanCoords(cellX, cellY);
        }


        System.out.printf("cellX: %d  cellY: %d \n", cellX, cellY);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;
        ovalWith = (int) (cellWidth/1.5f);

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }


        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if(Logic.map[i][j]==Logic.DOT_X){
                    drawX(g, j, i);
                }
            }
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if(Logic.map[i][j]==Logic.DOT_O){
                    drawO(g, j, i);
                }
            }
        }

    }

    private void drawX(Graphics g, int cellX, int cellY) {
//
        Graphics2D g2 =(Graphics2D) g;
        g2.setStroke(new BasicStroke(10.0f));

        g2.setColor(Color.red);
        g2.drawLine((cellX * cellWidth) + (cellWidth/AGE_CELL_DRAW), (cellY * cellHeight) + (cellWidth/AGE_CELL_DRAW),
                ((cellX + 1) * cellWidth) - (cellWidth/AGE_CELL_DRAW), ((cellY + 1) * cellHeight) - (cellHeight/AGE_CELL_DRAW));

        g2.drawLine(((cellX +1)* cellWidth) - (cellWidth/AGE_CELL_DRAW), (cellY * cellHeight) + (cellWidth/AGE_CELL_DRAW),
                (cellX * cellWidth)  + (cellWidth/AGE_CELL_DRAW), ((cellY + 1) * cellHeight)  - (cellHeight/AGE_CELL_DRAW));


    }
    private void drawO (Graphics g, int cellX, int cellY) {
//
        ovalWith = (int) (cellWidth/1.5f);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10.0f));

        g2.setColor(Color.blue);
        g2.drawOval((cellX * cellWidth)+ (cellWidth/AGE_CELL_DRAW), (cellY * cellHeight) + (cellWidth/AGE_CELL_DRAW),cellWidth/2, cellWidth/2) ;

    }

        public void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int dotsToWin) {
        this.gameMode = gameMode;
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.dotsToWin = dotsToWin;

        isInit = true;
        repaint();
    }
}
