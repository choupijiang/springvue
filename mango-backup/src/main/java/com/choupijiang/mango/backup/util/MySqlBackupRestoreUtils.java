package com.choupijiang.mango.backup.util;

import java.io.File;
import java.io.IOException;

public class MySqlBackupRestoreUtils {

    private static String[] getCommand(String command) {
        String os = System.getProperty("os.name");
        String shell = "/bin/bash";
        String c = "-c";
        if(os.toLowerCase().startsWith("win")){
            shell = "cmd";
            c = "/c";
        }
        String[] cmd = { shell, c, command };
        return cmd;
    }

    public static boolean backup(String host, String port, String userName, String password, String backupFolderPath, String fileName,
                                 String database) throws Exception {
        File backupFolderFile = new File(backupFolderPath);
        if (!backupFolderFile.exists()) {
            // 如果目录不存在则创建
            backupFolderFile.mkdirs();
        }
        if (!backupFolderPath.endsWith(File.separator) && !backupFolderPath.endsWith("/")) {
            backupFolderPath = backupFolderPath + File.separator;
        }
        // 拼接命令行的命令
        String backupFilePath = backupFolderPath + fileName;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mysqldump --opt ").append(" --add-drop-database ").append(" --add-drop-table ");
        stringBuilder.append(" -h").append(host).append(" -P").append(port).append(" -u").append(userName).append(" -p").append(password);
        stringBuilder.append(" --result-file=").append(backupFilePath).append(" --default-character-set=utf8 ").append(database);
        // 调用外部执行 exe 文件的 Java API
        Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
        if (process.waitFor() == 0) {
            // 0 表示线程正常终止
            System.out.println("数据已经备份到 " + backupFilePath + " 文件中");
            return true;
        }
        return false;
    }

    public static boolean restore(String restoreFilePath, String host, String port, String userName, String password, String database)
            throws Exception {
        File restoreFile = new File(restoreFilePath);
        if (restoreFile.isDirectory()) {
            for (File file : restoreFile.listFiles()) {
                if (file.exists() && file.getPath().endsWith(".sql")) {
                    restoreFilePath = file.getAbsolutePath();
                    break;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mysql -h").append(host).append(" -P").append(port).append(" -u").append(userName).append(" -p").append(password);
        stringBuilder.append(" ").append(database).append(" < ").append(restoreFilePath);
        try {
            Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
            if (process.waitFor() == 0) {
                System.out.println("数据已从 " + restoreFilePath + " 导入到数据库中");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        String host = "localhost";
        String userName = "root";
        String password = "123456";
        String database = "mango";
        String port = "3306";

        System.out.println("开始备份");
        String backupFolderPath = "~/cooder/springvue/";
        String fileName = "mango.sql";
        backup(host, port, userName, password, backupFolderPath, fileName, database);
        System.out.println("备份成功");

        System.out.println("开始还原");
        String restoreFilePath = "~/cooder/springvue/";
        restore(restoreFilePath, host, port, userName, password, database);
        System.out.println("还原成功");

    }

}
