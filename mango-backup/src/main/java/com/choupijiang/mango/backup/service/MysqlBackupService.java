package com.choupijiang.mango.backup.service;

public interface MysqlBackupService {

    /**
     *
     * @param host
     * @param userName
     * @param password
     * @param backupFolderPath 备份路径
     * @param fileName 备份的文件名
     * @param database
     * @return
     * @throws Exception
     */
    boolean backup(String host, String port, String userName, String password, String backupFolderPath, String fileName, String database) throws Exception;


    boolean restore(String restoreFilePath,String host, String port, String userName, String password, String database) throws Exception;

}