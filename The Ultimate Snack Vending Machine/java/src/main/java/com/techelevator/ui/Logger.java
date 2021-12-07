package com.techelevator.ui;
import java.io.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Logger extends UserOutput implements Closeable {

    private File logFile;
    private PrintWriter writer;
    static Logger logger = new Logger("log.txt");

    public Logger(String File){
        this.logFile = new File("log.txt");
        if(!logFile.exists()){
            try {
                this.writer = new PrintWriter(this.logFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                this.writer = new PrintWriter(new FileWriter(this.logFile, true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void write(String logMessage){
        this.writer.println(logMessage);
        this.writer.flush();
    }


    @Override
    public void close() {
        this.writer.close();
    }

    public static String currentFormat() {

        DateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
        String dateString2 = dateFormat2.format(new Date()).toString();
        return dateString2;
    }



}
