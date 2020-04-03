package cn.edu.ncu.quanhao.FiveChess;

/**
 * 五子棋的抽象模型
 *
 * @author QuanHao
 */
public class FiveChess {
    public double steps;//步数
    public double width;//棋盘长度
    public double height;//棋盘宽度
    public double cellLen;//格子宽度
    public char[][] chessBoard; //棋盘
    public String side;//当前下棋方

    public double getSteps() {
        return steps;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getCellLen() {
        return cellLen;
    }

    public char[][] getChessBoard() {
        return chessBoard;
    }

    //返回当前棋手
    public char getCurrentSide() {
        if (this.side == "Black") return 'B';
        else if (this.side == "White") return 'W';
        else return 'E';
    }

    //交换下棋方
    public void changeSide() {
        if (this.side == "Black") {
            this.side = "White";
            return;
        }
        if (this.side == "White") {
            this.side = "Black";
        }
    }

    public FiveChess(double width, double height, double cellLen) {
        this.width = width;
        this.height = height;
        this.cellLen = cellLen;
        this.chessBoard = new char[(int) this.width][(int) this.height];
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                chessBoard[i][j] = 'E';
            }
        }//棋盘初始化为E（Empty）
        this.side = "Black";
    }

    //重置棋盘
    public void resetChessBoard() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                chessBoard[i][j] = 'E';
            }
        }//棋盘初始化为E（Empty）
    }

    //检查下子坐标的合法性并执行下子操作
    public boolean dropChess(int x, int y) {
        if ((x > 0 && x < this.width) && (y > 0 && y < this.height)) {
            if (this.chessBoard[x][y] == 'E') {
                this.chessBoard[x][y] = this.getCurrentSide();
                return true;
            } else return false;//坐标上已经落子
        } else return false;//坐标在棋盘外
    }

    //判断是否获胜
    public boolean isWin(int x, int y) {
        boolean win = true;
        int counter = 0;
        // 在一条直线上是否连成五子
        int startStraightLineX = 0,
                startStraightLineY = 0, //落点的水平线和竖直线起始坐标
                startForwardSlashLineX = 0, startForwardSlashLineY = 0,//落点正斜线起始位置
                startBackSlashLineX = 0, startBackSlashLineY = 0;//落点反斜线起始位置
        for (int i = x; i >= 0; i--) {
            if (this.chessBoard[i][y] != this.chessBoard[x][y]) {
                break;
            }
            startStraightLineX = i;
        }//水平线的起始点
        for (int i = y; i >= 0; i--) {
            if (this.chessBoard[x][i] != this.chessBoard[x][y]) {
                break;
            }
            startStraightLineY = i;
        }//竖直线的起始点
        for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if (this.chessBoard[i][j] != this.chessBoard[x][y]) {
                break;
            }
            startForwardSlashLineX = i;
            startForwardSlashLineY = j;
        }//正斜线的起始点
        for (int i = x, j = y; i <= this.width && j >= 0; i++, j--) {
            if (this.chessBoard[i][j] != this.chessBoard[x][y]) {
                break;
            }
            startBackSlashLineX = i;
            startBackSlashLineY = j;
        }//反斜线的起始点
        counter = 0;
        for (int i = startStraightLineX, j = y; i < this.width; i++) {
            if (this.chessBoard[i][j] == this.chessBoard[x][y]) {
                counter++;
            }
            if (this.chessBoard[i][j] != this.chessBoard[x][y]) break;
            if (counter == 5)
                return win;
        }//水平线上连成了五子
        counter = 0;
        for (int i = x, j = startStraightLineY; j < this.height; j++) {
            if (this.chessBoard[i][j] == this.chessBoard[x][y]) {
                counter++;
            }
            if (this.chessBoard[i][j] != this.chessBoard[x][y]) break;
            if (counter == 5)
                return win;
        }//竖直线上连成了五子
        counter = 0;
        for (int i = startForwardSlashLineX, j = startForwardSlashLineY; i < this.width && j < this.height; i++, j++) {
            if (this.chessBoard[i][j] == this.chessBoard[x][y]) {
                counter++;
            }
            if (this.chessBoard[i][j] != this.chessBoard[x][y]) break;
            if (counter == 5)
                return win;
        }//正斜线上连成了五子
        counter = 0;
        for (int i = startBackSlashLineX, j = startBackSlashLineY; i >= 0 && j < this.height; i--, j++) {
            if (this.chessBoard[i][j] == this.chessBoard[x][y]) {
                counter++;
            }
            if (this.chessBoard[i][j] != this.chessBoard[x][y]) break;
            if (counter == 5)
                return win;
        }//反斜线上连成了五子

        return !win;
    }
}