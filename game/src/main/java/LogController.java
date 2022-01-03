import java.time.LocalDateTime;

public abstract class LogController {
    private static StackTraceElement element;
	private static LogEnums globalLogLvl = LogEnums.INFO;

	/**
	 *	<h1><i>setGlobalLogLvl</i></h1>
	 * <p>Sets globalLogLvl attribute with the Log ENUM. This method changes the level of the log
	 * based on the log level provided.</p>
	 * @param logLvl - Log ENUM that changes the global log level
	 */
	public static void setGlobalLogLvl(LogEnums logLvl) {
		globalLogLvl = logLvl;
	}

	/**
	 *	<h1><i>getGlobalLogLvl</i></h1>
	 * <p>Gets the globalLogLvl attribute with the Log ENUM.</p>
	 * @return Log - returns the current global log level
	 */
	public static LogEnums getGlobalLogLvl() {
		return globalLogLvl;
	}

	/**
	 *	<h1><i>log</i></h1>
	 * <p>This static method gets called every time a line is added to the log.
	 * It gets the line and the level and prints it in the terminal based on the global
	 * level.</p>
	 * @param logLvl - Log ENUM sets the log level of that line
	 * @param logLine - String is the actual log line (you can use [object].toString() when calling this method)
	 */
	public static void log(LogEnums logLvl, String logLine) {
		//error lvl
		if (globalLogLvl == LogEnums.ERROR && logLvl == LogEnums.ERROR) {
			element = Thread.currentThread().getStackTrace()[2];
			System.out.println(LocalDateTime.now() + " [" + logLvl + "] (" + element.getClassName() + ") " + logLine);
		}
		//info lvl
		else if (globalLogLvl == LogEnums.INFO && (logLvl == LogEnums.ERROR || logLvl == LogEnums.INFO)) {
			element = Thread.currentThread().getStackTrace()[2];
			System.out.println(LocalDateTime.now() + " [" + logLvl + "] (" + element.getClassName() + "." + element.getMethodName() + ") " + logLine);
		}
		//debug lvl
		else if (globalLogLvl == LogEnums.DEBUG && (logLvl == LogEnums.ERROR || logLvl == LogEnums.INFO || logLvl == LogEnums.DEBUG)) {
			element = Thread.currentThread().getStackTrace()[2];
			System.out.println(LocalDateTime.now() + " [" + logLvl + "] (" + element.getClassName() + "." + element.getMethodName() + "$" + element.getLineNumber() + ") " + logLine);
		}
		//trace lvl
		else if (globalLogLvl == LogEnums.TRACE && (logLvl == LogEnums.ERROR || logLvl == LogEnums.INFO || logLvl == LogEnums.DEBUG || logLvl == LogEnums.TRACE)) {
			element = Thread.currentThread().getStackTrace()[2];
			System.out.println(LocalDateTime.now() + " [" + logLvl + "] (" + element.getClassName() + "." + element.getMethodName() + "$" + element.getLineNumber() + ") " + logLine);
		}
	}    
}
