module Course_Practice {
    requires javafx.base;
    requires javafx.swt;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.swing;

    exports cn.edu.ncu.quanhao.char2;
exports cn.edu.ncu.quanhao.FiveChess;
    opens cn.edu.ncu.quanhao.char2;
}