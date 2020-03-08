package OOP.LoggerLibrary.Appenders;

import OOP.LoggerLibrary.Enums.ReportLevel;
import OOP.LoggerLibrary.Layouts.Interfaces.Layout;

public class ConsoleAppender extends AppenderImpl {


    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    public ConsoleAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        System.out.println(this.format(date, reportLevel, message));
    }



}
