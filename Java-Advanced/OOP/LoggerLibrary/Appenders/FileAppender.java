package OOP.LoggerLibrary.Appenders;

import OOP.LoggerLibrary.CustomFiles.Interfaces.File;
import OOP.LoggerLibrary.CustomFiles.LogFile;
import OOP.LoggerLibrary.Enums.ReportLevel;
import OOP.LoggerLibrary.Layouts.Interfaces.Layout;

import java.io.IOException;

public class FileAppender extends AppenderImpl {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
    }

    protected FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        if(this.file == null) {
        try {
            this.setFile(new LogFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        this.file.appendBuffer(this.format(date, reportLevel, message));
        this.file.write();
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.file.getSize();
    }
}
