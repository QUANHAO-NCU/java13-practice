package cn.edu.ncu.quanhao.CaesarCode.FiveChess;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * 视图控件集合
 *
 * @author QuanHao
 */

public class ChessPane extends Pane {
    public Canvas canvasChessPane;
    public GraphicsContext gc;
    public FiveChess fiveChess;
    public Canvas indicatorPane;
    public GraphicsContext indicatorGc;
    public Canvas winnerMessagePane;
    public GraphicsContext winnerMessageGc;
    public Canvas resetChessBoardTipsPane;
    public GraphicsContext resetChessBoardTipsGc;

    public ChessPane(FiveChess fiveChess) {
        this.fiveChess = fiveChess;
        double cell = fiveChess.getCellLen();
        drawPane(cell);
        drawChess(cell);
        Canvas indicator = indicator(cell);
        Canvas winnerMessagePane = winMessage();
        Canvas resetChessBoardTips = resetChessBoardTips();
        getChildren().addAll(canvasChessPane, indicator, winnerMessagePane, resetChessBoardTips);
    }


    /**
     * 画棋盘
     */
    public void drawPane(double cell) {
        this.canvasChessPane = new Canvas((fiveChess.getWidth() + 2) * cell, (fiveChess.getHeight() + 2) * cell);
        canvasChessPane.setLayoutY(10.0);
        canvasChessPane.setLayoutY(10.0);//设置棋盘坐标
        gc = canvasChessPane.getGraphicsContext2D();
        gc.clearRect(0, 0, canvasChessPane.getWidth(), canvasChessPane.getHeight());
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.GOLD);
        for (int i = 0; i < fiveChess.getWidth(); i++) {
            for (int j = 0; j < fiveChess.getHeight(); j++) {
                gc.strokeRect(10 + i * cell, 10 + j * cell, cell, cell);
                gc.fillRect(10 + i * cell, 10 + j * cell, cell, cell);
            }
        }
    }

    /**
     * 画棋子
     */
    public void drawChess(double cell) {
        char[][] chessBoard = fiveChess.getChessBoard();
        for (int i = 0; i < fiveChess.getHeight(); i++) {
            for (int j = 0; j < fiveChess.getHeight(); j++) {
                if (chessBoard[i][j] == 'B') {
                    gc.setFill(Color.BLACK);
                    gc.fillOval(10 + i * cell - cell / 2, 10 + j * cell - cell / 2, cell, cell);
                } else if (chessBoard[i][j] == 'W') {
                    gc.setFill(Color.WHITE);
                    gc.fillOval(10 + i * cell - cell / 2, 10 + j * cell - cell / 2, cell, cell);
                    gc.strokeOval(10 + i * cell - cell / 2, 10 + j * cell - cell / 2, cell, cell);
                } else if (chessBoard[i][j] == 'E') {
                    gc.setFill(Color.GOLD);
                    gc.setStroke(Color.BLACK);
                    gc.strokeRect(10 + i * cell, 10 + j * cell, cell, cell);
                    gc.fillRect(10 + i * cell, 10 + j * cell, cell, cell);
                }
            }
        }
    }

    /**
     * 画当前棋手的指示器
     */
    public Canvas indicator(double cell) {
        this.indicatorPane = new Canvas(400, 150);
        indicatorPane.setLayoutX(580.0);
        indicatorPane.setLayoutY(20.0);
        this.indicatorGc = indicatorPane.getGraphicsContext2D();
        indicatorGc.setStroke(Color.BLACK);
        indicatorGc.strokeRect(0.0, 0.0, 400, 150);
        indicatorGc.setFill(Color.LAVENDER);
        indicatorGc.fillRect(0.0, 0.0, 400, 150);
        indicatorGc.setFill(Color.BLACK);
        indicatorGc.fillOval(175, 15, 65, 65);
        indicatorGc.setFill(Color.WHITE);
        indicatorGc.fillOval(315, 15, 65, 65);
        indicatorGc.setStroke(Color.LAVENDER);
        indicatorGc.strokePolygon(
                new double[]{175 + 65 / 2, 175 + 65 / 2 - 20, 175 + 65 / 2 + 20},
                new double[]{95, 120, 120}, 3);//绘制三角形指示器
        indicatorGc.strokePolygon(
                new double[]{315 + 65 / 2, 315 + 65 / 2 - 20, 315 + 65 / 2 + 20},
                new double[]{95, 120, 120}, 3);
        indicatorGc.setFill(Color.BLACK);
        indicatorGc.setFont(new Font("Microsoft YaHei", 32));
        indicatorGc.fillText("当前棋手：", 30, 105, 150);
        return indicatorPane;
    }

    /**
     * 切换指示器
     */
    public void setIndicator(double cell) {

        this.indicatorGc.setFill(Color.GOLD);
        if (fiveChess.getCurrentSide() == 'W') {
            indicatorGc.fillPolygon(
                    new double[]{315 + 65 / 2, 315 + 65 / 2 - 20, 315 + 65 / 2 + 20},
                    new double[]{95, 120, 120}, 3);
            this.indicatorGc.setFill(Color.LAVENDER);
            indicatorGc.fillPolygon(
                    new double[]{175 + 65 / 2, 175 + 65 / 2 - 20, 175 + 65 / 2 + 20},
                    new double[]{95, 120, 120}, 3);
        }
        if (fiveChess.getCurrentSide() == 'B') {
            indicatorGc.fillPolygon(
                    new double[]{175 + 65 / 2, 175 + 65 / 2 - 20, 175 + 65 / 2 + 20},
                    new double[]{95, 120, 120}, 3);
            this.indicatorGc.setFill(Color.LAVENDER);
            indicatorGc.fillPolygon(
                    new double[]{315 + 65 / 2, 315 + 65 / 2 - 20, 315 + 65 / 2 + 20},
                    new double[]{95, 120, 120}, 3);
        }
    }

    /**
     * 显示获胜方
     */
    public Canvas winMessage() {
        this.winnerMessagePane = new Canvas(400, 140);
        winnerMessagePane.setLayoutX(580);
        winnerMessagePane.setLayoutY(190);
        this.winnerMessageGc = winnerMessagePane.getGraphicsContext2D();
        winnerMessageGc.setFill(Color.WHITE);
        winnerMessageGc.fillRect(0, 0, 400, 400);
        winnerMessageGc.setFont(Font.font("Microsoft YaHei", 32));
        winnerMessageGc.setFill(Color.BLACK);
        return winnerMessagePane;
    }

    /**
     * 设置获胜方信息
     */
    public void setMessage(char side) {
        if (side == 'B') {
            this.winnerMessageGc.setTextAlign(TextAlignment.CENTER);
            winnerMessageGc.setFill(Color.GOLD);
            winnerMessageGc.fillRect(0, 0, 400, 400);
            winnerMessageGc.setFill(Color.BLACK);
            this.winnerMessageGc.fillText("黑方棋手取得胜利！", 200, 86, 400);
        }
        if (side == 'W') {
            this.winnerMessageGc.setTextAlign(TextAlignment.CENTER);
            winnerMessageGc.setFill(Color.GOLD);
            winnerMessageGc.fillRect(0, 0, 400, 400);
            winnerMessageGc.setFill(Color.BLACK);
            this.winnerMessageGc.fillText("白方棋手取得胜利！", 200, 86, 400);
        }
        if (side == 'R') {
            winnerMessageGc.setFill(Color.WHITE);
            winnerMessageGc.fillRect(0, 0, 400, 400);
        }
    }

    /**
     * “再来一局”的提示信息
     */
    public Canvas resetChessBoardTips() {
        this.resetChessBoardTipsPane = new Canvas(400, 140);
        resetChessBoardTipsPane.setLayoutX(580);
        resetChessBoardTipsPane.setLayoutY(380);
        this.resetChessBoardTipsGc = resetChessBoardTipsPane.getGraphicsContext2D();
        resetChessBoardTipsGc.setFill(Color.WHITE);
        resetChessBoardTipsGc.fillRect(0, 0, 400, 140);
        return resetChessBoardTipsPane;
    }

    /**
     * 设置“再来一局”的提示信息
     */
    public void setResetChessBoardTipsGc(char c) {
        if (c == 'R') {
            resetChessBoardTipsGc.setFill(Color.GOLD);
            resetChessBoardTipsGc.fillRect(0, 0, 400, 140);
            this.resetChessBoardTipsGc.setFill(Color.BLACK);
            this.resetChessBoardTipsGc.setFont(new Font("Microsoft YaHei", 32));
            this.resetChessBoardTipsGc.fillText("再来一局?（将清空棋盘）", 23, 82, 400);
        }
        if (c == 'E') {
            this.resetChessBoardTipsGc.setFill(Color.WHITE);
            resetChessBoardTipsGc.fillRect(0, 0, 400, 140);
        }
    }
}


