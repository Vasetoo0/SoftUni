package OOP.LoggerLibrary;

import OOP.LoggerLibrary.Appenders.ConsoleAppender;
import OOP.LoggerLibrary.Appenders.FileAppender;
import OOP.LoggerLibrary.Appenders.Interfaces.Appender;
import OOP.LoggerLibrary.Enums.ReportLevel;
import OOP.LoggerLibrary.Layouts.Interfaces.Layout;
import OOP.LoggerLibrary.Layouts.SimpleLayout;
import OOP.LoggerLibrary.Layouts.XmlLayout;
import OOP.LoggerLibrary.Loggers.Interfaces.Logger;
import OOP.LoggerLibrary.Loggers.MessageLogger;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Appender[] appenders = new Appender[n];

        int index = 0;
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            Appender appender = null;

            Layout layout = null;

            if(tokens[1].equals("SimpleLayout")) {
                layout = new SimpleLayout();
            } else {
                layout = new XmlLayout();
            }

            if(tokens[0].equals("ConsoleAppender")) {
                appender = new ConsoleAppender(layout);
            } else {
                appender = new FileAppender(layout);
            }

            if(tokens.length == 3) {
                appender.setReportLevel(ReportLevel.valueOf(tokens[2]));
            }

            appenders[index++] = appender;
        }

        Logger logger = new MessageLogger(appenders);

        String line;

        while (!"END".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("\\|");

            switch (ReportLevel.valueOf(tokens[0])) {
                case INFO:
                    logger.logInfo(tokens[1],tokens[2]);
                    break;
                case WARNING:
                    logger.logWarning(tokens[1],tokens[2]);
                    break;
                case ERROR:
                    logger.logError(tokens[1],tokens[2]);
                    break;
                case CRITICAL:
                    logger.logCritical(tokens[1],tokens[2]);
                    break;
                case FATAL:
                    logger.logFatal(tokens[1],tokens[2]);
                    break;
            }
        }

        System.out.println(logger.toString());


    }
}
