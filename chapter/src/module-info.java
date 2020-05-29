module chapter {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;
    requires javafx.swt;

    exports cn.edu.ncu.quanhao.chapter05;
    exports cn.edu.ncu.quanhao.chapter06;
    exports cn.edu.ncu.quanhao.chapter07;
    exports cn.edu.ncu.quanhao.chapter08;
    exports cn.edu.ncu.quanhao.chapter9;
    exports cn.edu.ncu.quanhao.chapter10;
    exports cn.edu.ncu.quanhao.chapter11;
    opens cn.edu.ncu.quanhao.chapter11;
    exports cn.edu.ncu.quanhao.chapter11.controller;
    opens cn.edu.ncu.quanhao.chapter11.controller;
    exports cn.edu.ncu.quanhao.chapter13;
    opens cn.edu.ncu.quanhao.chapter13;
    exports cn.edu.ncu.quanhao.chapter13.controller;
    opens cn.edu.ncu.quanhao.chapter13.controller;


}