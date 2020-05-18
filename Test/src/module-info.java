module Test {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;
    requires javafx.swt;
    requires java.management;
    exports sierpingsky;
    opens sierpingsky;
    exports sierpingsky.Controller;
    opens sierpingsky.Controller;
}