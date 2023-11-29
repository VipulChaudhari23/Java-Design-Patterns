package com.maveric.loggerproblem;

import java.text.SimpleDateFormat;
import java.util.Date;

// LoggerDecorator class adding date and time information to the messages
class LoggerDecorator implements ILogger {
	private final ILogger logger;

	public LoggerDecorator(ILogger logger) {
		this.logger = logger;
	}

	@Override
	public void info(String msg) {
		String decoratedMsg = getFormattedLogMessage("Info", msg);
		logger.info(decoratedMsg);
	}

	@Override
	public void error(String msg) {
		String decoratedMsg = getFormattedLogMessage("Error", msg);
		logger.error(decoratedMsg);
	}

	private String getFormattedLogMessage(String logLevel, String msg) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = dateFormat.format(new Date());
		return logLevel + "-" + formattedDate + ": " + msg + "\n";
	}
}

public class LoggerUsage {
	public static void main(String[] args) {
		ILogger originalLogger = new LoggerImpl();
		ILogger loggerWithDateTime = new LoggerDecorator(originalLogger);

		loggerWithDateTime.info("successful");
		loggerWithDateTime.error("something went wrong");
	}
}
