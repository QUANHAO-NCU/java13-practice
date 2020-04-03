package cn.edu.ncu.quanhao.FiveChess;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * 游戏逻辑控制区
 * */
public class PlayAction implements EventHandler<MouseEvent> {
    public FiveChess fiveChess;
    public ChessPane chessPane;
    public Stage primaryStage;
    public boolean canDrop = true;

    PlayAction(FiveChess fiveChess, ChessPane chessPane, Stage primaryStage) {
        this.fiveChess = fiveChess;
        this.chessPane = chessPane;
        this.primaryStage = primaryStage;
    }

    @Override
    public void handle(MouseEvent event) {
        double cell = fiveChess.getCellLen();
        double x = event.getX();
        double y = event.getY();
        chessPane.setIndicator(cell);//指示当前下棋方
        int i = (int) ((x - 10 + cell / 2) / cell);
        int j = (int) ((y - 10 + cell / 2) / cell);//映射到棋盘坐标
        if (this.canDrop) {//当前是否允许在棋盘落子
            if (fiveChess.dropChess(i, j)) {//落子合法
                chessPane.drawChess(cell);//渲染棋子
                if (fiveChess.isWin(i, j)) {//判断胜负
                    chessPane.setMessage(fiveChess.getCurrentSide());
                    chessPane.setResetChessBoardTipsGc('R');
                    this.canDrop = false;//停止在棋盘下棋
                    return;//流程结束，重新监听鼠标事件
                } else {
                    fiveChess.changeSide();
                    chessPane.setIndicator(cell);//指示当前下棋方
                }
            }
        }
        if ((x > 580 && x < 980) && (y > 380 && y < 520)) {
            //鼠标点击位置在“再来一局”的画布上，触发事件
            fiveChess.resetChessBoard();
            chessPane.drawChess(cell);
            chessPane.setResetChessBoardTipsGc('E');
            chessPane.setMessage('R');
            this.canDrop = true;
            return;
        }
    }
}



