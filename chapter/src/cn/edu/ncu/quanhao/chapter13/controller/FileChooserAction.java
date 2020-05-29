package cn.edu.ncu.quanhao.chapter13.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


public class FileChooserAction {
    private static String status = "string";//指示当前文本状态
    private static String hexStr = "0123456789ABCDEF";
    private static String[] binaryArray =
            {"0000", "0001", "0010", "0011",
                    "0100", "0101", "0110", "0111",
                    "1000", "1001", "1010", "1011",
                    "1100", "1101", "1110", "1111"};
    private Desktop desktop;
    private Stage stage;
    private File file;
    @FXML
    private Button toBinaryBtn;
    @FXML
    private Button toHexBtn;
    @FXML
    private Button checkBtn;
    @FXML
    private TextArea content;
    @FXML
    private TextField address;

    @FXML
    public void toBinary() throws IOException {
        content.setText(stringToBinary(inputStreamToString(file)));
        status = "binary";
    }

    @FXML
    public void toHex() throws IOException {
        content.setText(stringToHex(inputStreamToString(file)));
        status = "hex";
    }

    @FXML
    public void getFile(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            file = new File(address.getText());
            if (!file.exists()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("找不到对应的文件");
                alert.showAndWait();
            } else {
                setControls(file);
            }
        }

    }

    @FXML
    public void saveFile() throws IOException {
        String result = content.getText();
        if (result.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("选择一个文件打开再执行此项操作！");
            alert.showAndWait();
        } else {
            try (FileWriter fw = new FileWriter(getfile())) {
                switch (status) {
                    case "string":
                        fw.write(result);
                        status = "string";
                        break;
                    case "binary":
                        fw.write(binaryToString(result));
                        status = "binary";
                        break;
                    case "hex":
                        fw.write(hexToString(result));
                        status = "hex";
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("文件写入成功！");
                alert.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void turnToString() throws IOException {
        content.setText(inputStreamToString(file));
        status = "string";
    }

    public File getfile() {
        file = new File(address.getText());
        if (!file.exists()) {
            return null;
        } else {
            return file;
        }

    }

    @FXML
    public void check() throws IOException {
        stage = new Stage();
        desktop = Desktop.getDesktop();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择一个文件");
        File selectedFile = fileChooser.showOpenDialog(stage);
        this.file = selectedFile;
        setControls(file);
    }

    private void setControls(File file) throws IOException {
        address.setText(file.getPath());//文件地址框为文件的地址
        String s = inputStreamToString(file);
        content.setText(s);
        status = "string";

    }

    private String inputStreamToString(File file) throws IOException {
        /**
         * 文件输入流转成字符串
         * */
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        //获取文件的数据输入流,先用UTF格式读取
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(dis));
        br.lines().forEach(e -> {
            list.add(e);
            list.add("\n");
        });
        String s = "";
        for (String i : list) {
            s += i;
        }
        dis.close();
        return s;

    }

    private String stringToBinary(String s) {
        /**
         * String 字符串转化为 二进制 的字符串
         * */
        byte[] bArray = s.getBytes();
        String outStr = "";
        int pos = 0;
        for (byte b : bArray) {

            if (b == 0x0A) {
                outStr += "\n";
            } else {
                pos = (b & 0xF0) >> 4;
                //高四位
                outStr += binaryArray[pos];
                //低四位
                pos = b & 0x0F;
                outStr += binaryArray[pos];
            }
            outStr += " ";
        }
        return outStr;
    }

    private String stringToHex(String s) {
        /**
         * String 字符串数据转换成 十六进制 字符串
         * */
        byte[] bytes = s.getBytes();
        String result = "";
        String hex = "";
        for (int i = 0; i < bytes.length; i++) {
            //字节高4位
            if (bytes[i] == 0x0A) {
                result += "\n";
            } else {
                hex = String.valueOf(hexStr.charAt((bytes[i] & 0xF0) >> 4));
                //字节低4位
                hex += String.valueOf(hexStr.charAt(bytes[i] & 0x0F));
                result += hex + " ";
            }
        }
        return result;
    }

    private String binaryToHexString(String s) {
        /**
         * 二进制 转换成 十六进制
         * */
        byte[] bytes = s.getBytes();
        String result = "";
        String hex = "";
        for (int i = 0; i < bytes.length; i++) {
            //字节高4位
            if (bytes[i] == 0x0A) {
                result += "\n";
            } else {
                hex = String.valueOf(hexStr.charAt((bytes[i] & 0xF0) >> 4));
                //字节低4位
                hex += String.valueOf(hexStr.charAt(bytes[i] & 0x0F));
                result += hex + " ";
            }
        }
        return result;
    }

    public static String hexStringToBinary(String hexString) {
        /**
         * 十六进制 字符串 转化为 二进制 字符串
         * */
        //hexString的长度对2取整，作为bytes的长度
        int len = hexString.length() / 2;
        byte[] bytes = new byte[len];
        byte high = 0;//字节高四位
        byte low = 0;//字节低四位
        String result = "";
        int pos = 0;
        for (int i = 0; i < len; i++) {
            //右移四位得到高位
            high = (byte) ((hexStr.indexOf(hexString.charAt(2 * i))) << 4);
            low = (byte) hexStr.indexOf(hexString.charAt(2 * i + 1));
            byte b = (byte) (high | low);//高地位做或运算
            if (b == 0x0A) {
                result += "\n";
            } else {
                pos = (b & 0xF0) >> 4;
                //高四位
                result += binaryArray[pos];
                //低四位
                pos = b & 0x0F;
                result += binaryArray[pos];
            }
        }
        return result;
    }

    private String binaryToString(String s) {
        String result = "";
        byte[] bytes = s.getBytes();
        Map<String, Byte> r = new HashMap<>() {
            {
                put("0000", (byte) 0);
                put("0001", (byte) 1);
                put("0010", (byte) 2);
                put("0011", (byte) 3);
                put("0100", (byte) 4);
                put("0101", (byte) 5);
                put("0110", (byte) 6);
                put("0111", (byte) 7);
                put("1000", (byte) 8);
                put("1001", (byte) 9);
                put("1010", (byte) 10);
                put("1011", (byte) 11);
                put("1100", (byte) 12);
                put("1101", (byte) 13);
                put("1110", (byte) 14);
                put("1111", (byte) 15);
            }
        };
        String format ="";
        for (byte b : bytes) {
            if(b==10){format+="\n ";}
            else if(b==32) {format+=" ";}
            else format+=(char) b;

        }
        String[] ss = s.split(" ");
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].equals("\n")) {
                result += "\n";
            } else {
                String sss1 = ss[i].substring(0, 4);
                String sss2 = ss[i].substring(4);
                byte high = r.get(sss1);
                byte low = r.get(sss2);
                byte b = (byte) ((high << 4) + (low & 0x0F));
                result += (char) b;
            }

        }
        return result;
    }

    private String hexToString(String s) {
        String result = "";
        byte[] bytes = s.getBytes();
        Map<String, Byte> r = new HashMap<>() {{
            put("0", (byte) 0);
            put("1", (byte) 1);
            put("2", (byte) 2);
            put("3", (byte) 3);
            put("4", (byte) 4);
            put("5", (byte) 5);
            put("6", (byte) 6);
            put("7", (byte) 7);
            put("8", (byte) 8);
            put("9", (byte) 9);
            put("A", (byte) 10);
            put("a", (byte) 10);
            put("B", (byte) 11);
            put("b", (byte) 11);
            put("C", (byte) 12);
            put("c", (byte) 12);
            put("D", (byte) 13);
            put("d", (byte) 13);
            put("E", (byte) 14);
            put("e", (byte) 14);
            put("F", (byte) 15);
            put("f", (byte) 15);
        }};
        String format ="";
        for (byte b : bytes) {
            if(b==10){format+="\n ";}
            else if(b==32) {format+=" ";}
            else format+=(char) b;

        }
        String[] ss = format.split(" ");
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].equals("\n")) {
                result += "\n";
            } else {
                String[] sss = ss[i].split("");
                byte high = r.get(sss[0]);
                byte low = r.get(sss[1]);
                byte b = (byte) ((high << 4) + (low & 0x0F));
                result += (char) b;
            }
        }
        return result;
    }
}
