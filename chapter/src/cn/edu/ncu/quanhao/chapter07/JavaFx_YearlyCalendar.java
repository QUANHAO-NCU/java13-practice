package cn.edu.ncu.quanhao.chapter07;

        import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.scene.layout.GridPane;
        import javafx.scene.layout.HBox;
        import javafx.stage.Stage;

public class JavaFx_YearlyCalendar extends Application {

    public static boolean isLeap(int year) {
        //判断闰年
        return ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0));
    }

    public static int passYearDay(int year) {
        //计算在所求年份之前相对于基准时间（1900年1月1日过了多少时间）
        int passDay = 0;
        for (int i = 1900; i < year; i++) {
            if (isLeap(i)) {
                passDay += 366;
                continue;
            }
            passDay += 365;
        }
        return passDay;
    }

    public static int passMouthDay(int year, int month) {
        //计算在所求年份的所求月份之前过了多少天
        int passDay = 0;
        for (int i = 1; i < month; i++) {
            passDay += switch (i) {
                case 1, 3, 5, 7, 8, 10, 12 -> 31;
                case 2 -> isLeap(year) ? 29 : 28;
                default -> 30;
            };
        }
        return passDay;
    }

    public static int CalFirstDay(int year, int month) {
        //计算所求月份的1号的星期
        int sumDay = passYearDay(year) + passMouthDay(year, month);
        return sumDay % 7 + 1;//sumDay%7得到的是上个月月末的星期，下个月要加一
    }

    public static int theMouthDay(int year, int month) {
        //计算当月的总天数
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> isLeap(year) ? 29 : 28;
            default -> 30;
        };
    }

    public static String monthlyCalendar(int year, int month) {
        String monthlyCalendar = new String();
        monthlyCalendar += "\t\t\t\t\t\t" + month + "月" + "\n";
        monthlyCalendar += "日\t一\t二\t三\t四\t五\t六\t\n";
        int monthDay = theMouthDay(year, month);
        int weekDay = CalFirstDay(year, month);
        for (int j = 0; j < weekDay % 7; j++) {
            monthlyCalendar += "\t";
        }
        for (int i = 1; i <= monthDay; i++) {
            monthlyCalendar = monthlyCalendar + i + "\t";
            weekDay++;
            if (weekDay % 7 == 0) {
                monthlyCalendar += "\n";
            }
        }
        return monthlyCalendar + "\t";//生成月历的字符串
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gp = new GridPane();
                    primaryStage.show();
                    Label label = new Label("请输入要查看的年份：");
                    HBox hBox = new HBox();
                    TextField field = new TextField();
                    field.setEditable(true);
                    field.setPromptText("请输入要查看的年份：");
                    Button button = new Button("确定");
                    hBox.getChildren().addAll(label, field, button);
                    Scene scene0 = new Scene(hBox, 400, 200);
                    primaryStage.setScene(scene0);//场景一：获取要查询的年份，仅输入数字
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                int year = Integer.valueOf(field.getText().toString());
                for (int i = 0; i < 12; i++) {
                    gp.add(new Label(monthlyCalendar(year, i + 1)), i % 4, i / 4);
                }
                Scene scene1 = new Scene(gp, 800, 600);//场景2：打印该年份的年历
                primaryStage.setScene(scene1);

            }
        });
        //把场景添加到舞台
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
