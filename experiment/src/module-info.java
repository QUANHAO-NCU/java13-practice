module experiment {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;
    requires javafx.swt;
    requires java.management;
    exports cn.edu.ncu.quanhao.FiveChess;
    exports cn.edu.ncu.quanhao.Sierpinski;
    exports cn.edu.ncu.quanhao.SierpinskiRectangle;
    exports cn.edu.ncu.quanhao.Sierpinsky2;
    exports cn.edu.ncu.quanhao.Sierpinsky3;
    opens cn.edu.ncu.quanhao.FiveChess;
    opens cn.edu.ncu.quanhao.Sierpinski;
    opens cn.edu.ncu.quanhao.SierpinskiRectangle;
    opens cn.edu.ncu.quanhao.Sierpinsky2;
    opens cn.edu.ncu.quanhao.Sierpinsky3;
    exports cn.edu.ncu.quanhao.Sierpinsky3.controller;
    opens cn.edu.ncu.quanhao.Sierpinsky3.controller;

}