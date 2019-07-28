package OOP.LoggerLibrary.Layouts;

import OOP.LoggerLibrary.Enums.ReportLevel;
import OOP.LoggerLibrary.Layouts.Interfaces.Layout;

public class SimpleLayout implements Layout {

    public SimpleLayout(){}

    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s", date, reportLevel ,message);
    }
}
