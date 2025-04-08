package HolyJAR;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TrionLogger provides thread-safe logging functionality with configurable log levels and file paths.
 * This utility class allows for centralized logging across the application with various severity levels.
 */
public class Logger {
    
    // Lock object for thread safety using ReentrantLock instead of synchronized block
    private static final ReentrantLock LOCK = new ReentrantLock();
    
    // Default log file path
    private static String logFilePath = "logs/trion/Trion.log";
    
    // Date-time formatter for consistent timestamp formatting
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    // Log level constants for standardized logging
    public static final String INFO = "INFO";
    public static final String WARNING = "WARNING";
    public static final String ERROR = "ERROR";
    public static final String DEBUG = "DEBUG";
    public static final String FATAL = "FATAL";
    
    // Maximum log file size in bytes before rotation (default: 10MB)
    private static long maxLogSize = 10 * 1024 * 1024;
    
    // Maximum number of backup log files to keep
    private static int maxBackupFiles = 5;
    
    // Flag to enable/disable console output in addition to file logging
    private static boolean logToConsole = false;
    
    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    
    /**
     * Sets the log file path.
     * 
     * @param path The new path for the log file.
     */
    public static void setLogFilePath(String path) {
        LOCK.lock();
        try {
            logFilePath = path;
        } finally {
            LOCK.unlock();
        }
    }
    
    /**
     * Sets the maximum size of the log file before rotation occurs.
     * 
     * @param sizeInBytes The maximum size in bytes.
     */
    public static void setMaxLogSize(long sizeInBytes) {
        maxLogSize = sizeInBytes;
    }
    
    /**
     * Sets the maximum number of backup log files to keep.
     * 
     * @param count The maximum number of backup files.
     */
    public static void setMaxBackupFiles(int count) {
        maxBackupFiles = count > 0 ? count : 1;
    }
    
    /**
     * Enables or disables console logging in addition to file logging.
     * 
     * @param enable True to enable console logging, false to disable.
     */
    public static void enableConsoleLogging(boolean enable) {
        logToConsole = enable;
    }
    
    /**
     * Logs a message with INFO level.
     * 
     * @param message The message to log.
     */
    public static void info(String message) {
        log(message, INFO);
    }
    
    /**
     * Logs a message with WARNING level.
     * 
     * @param message The message to log.
     */
    public static void warning(String message) {
        log(message, WARNING);
    }
    
    /**
     * Logs a message with ERROR level.
     * 
     * @param message The message to log.
     */
    public static void error(String message) {
        log(message, ERROR);
    }
    
    /**
     * Logs an exception with ERROR level.
     * 
     * @param message The message to log.
     * @param e The exception to log.
     */
    public static void error(String message, Exception e) {
        StringBuilder sb = new StringBuilder(message);
        sb.append("\nException: ").append(e.getClass().getName());
        sb.append("\nMessage: ").append(e.getMessage());
        sb.append("\nStackTrace: ");
        for (StackTraceElement element : e.getStackTrace()) {
            sb.append("\n    ").append(element.toString());
        }
        log(sb.toString(), ERROR);
    }
    
    /**
     * Logs a message with DEBUG level.
     * 
     * @param message The message to log.
     */
    public static void debug(String message) {
        log(message, DEBUG);
    }
    
    /**
     * Logs a message with FATAL level.
     * 
     * @param message The message to log.
     */
    public static void fatal(String message) {
        log(message, FATAL);
    }
    
    /**
     * Logs a message with a specified log level.
     * 
     * @param message The message to log.
     * @param logLevel The severity level of the log entry.
     */
    public static void log(String message, String logLevel) {
        if (message == null) {
            return;
        }
        
        // Format the log entry with the current date and time, log level, and message
        String timestamp = LocalDateTime.now().format(DATE_FORMATTER);
        String logEntry = String.format("%s [%s] %s", timestamp, logLevel, message);
        
        // Print to console if enabled
        if (logToConsole) {
            System.out.println(logEntry);
        }
        
        // Write to log file
        writeToLogFile(logEntry);
    }
    
    /**
     * Writes a log entry to the log file with thread safety and file rotation.
     * 
     * @param logEntry The formatted log entry to write.
     */
    private static void writeToLogFile(String logEntry) {
        LOCK.lock();
        try {
            // Ensure the directory exists
            Path directoryPath = Paths.get(logFilePath).getParent();
            if (directoryPath != null) {
                Files.createDirectories(directoryPath);
            }
            
            // Check if log rotation is needed
            File logFile = new File(logFilePath);
            if (logFile.exists() && logFile.length() > maxLogSize) {
                rotateLogFiles();
            }
            
            // Write the log entry to the log file, appending to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath, true))) {
                writer.write(logEntry);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            System.err.println("Failed to write log: " + e.getMessage());
        } finally {
            LOCK.unlock();
        }
    }
    
    /**
     * Rotates log files when the current log file exceeds the maximum size.
     * This method renames existing log files and creates a new empty log file.
     */
    private static void rotateLogFiles() {
        try {
            // Delete the oldest log file if it exists
            File oldestBackup = new File(logFilePath + "." + maxBackupFiles);
            if (oldestBackup.exists()) {
                Files.delete(oldestBackup.toPath());
            }
            
            // Shift all existing backup files
            for (int i = maxBackupFiles - 1; i > 0; i--) {
                File backupFile = new File(logFilePath + "." + i);
                if (backupFile.exists()) {
                    Files.move(backupFile.toPath(), Paths.get(logFilePath + "." + (i + 1)));
                }
            }
            
            // Rename the current log file to .1
            File currentFile = new File(logFilePath);
            if (currentFile.exists()) {
                Files.move(currentFile.toPath(), Paths.get(logFilePath + ".1"));
            }
            
        } catch (IOException e) {
            System.err.println("Failed to rotate log files: " + e.getMessage());
        }
    }
    
    /**
     * Clears the log file, removing all existing log entries.
     */
    public static void clearLog() {
        LOCK.lock();
        try {
            // Create a new empty log file, overwriting the existing one
            try (FileWriter writer = new FileWriter(logFilePath, false)) {
                writer.write(""); // Write empty string
            }
        } catch (IOException e) {
            System.err.println("Failed to clear log file: " + e.getMessage());
        } finally {
            LOCK.unlock();
        }
    }
}