package lesson8;
        ;

import lesson8.BattleMap;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static final int WINDOW_POS_X = 400;
    static final int WINDOW_POS_Y = 400;
    static final int WINDOW_WIDTH = 505;
    static final int WINDOW_HEIGHT = 555;
    String a = "fdf";

    private SettingsWindow settingsWindow;
    private BattleMap battleMap;

    public GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");

        settingsWindow = new SettingsWindow(this);
        battleMap = new BattleMap(this);
        add(battleMap, BorderLayout.CENTER);


        JPanel panel = new JPanel(new GridLayout(3, 2));
        JButton buttonStartNewGame = new JButton("StartNewGame");
        buttonStartNewGame.setBackground(Color.cyan);
        panel.add(buttonStartNewGame);

        JButton buttonExit = new JButton("Exit");
        buttonExit.setBackground(Color.PINK);
        panel.add(buttonExit);

        JButton buttonPlay = new JButton(a);
        buttonPlay.setBackground(Color.PINK);
        panel.add(buttonPlay);

        buttonExit.addActionListener(e -> {
            System.exit(0);
        });

        buttonStartNewGame.addActionListener(e -> {
            settingsWindow.setVisible(true);
        });

        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int dotsToWin) {
//        System.out.printf("gameMode: %d, fieldSizeX: %d, fieldSizeY: %d, dotsToWin: %d\n", gameMode, fieldSizeX, fieldSizeY, dotsToWin);
        battleMap.startNewGame(gameMode, fieldSizeX, fieldSizeY, dotsToWin);

    }
}
