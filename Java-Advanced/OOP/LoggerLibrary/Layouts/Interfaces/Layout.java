package OOP.LoggerLibrary.Layouts.Interfaces;

import OOP.LoggerLibrary.Enums.ReportLevel;

public interface Layout {

    String format(String date, ReportLevel reportLevel, String message);
}
