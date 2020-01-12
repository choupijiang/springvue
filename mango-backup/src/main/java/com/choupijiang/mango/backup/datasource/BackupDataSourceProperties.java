package com.choupijiang.mango.backup.datasource;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "mango.backup.datasource")
@Data
@NoArgsConstructor
public class BackupDataSourceProperties {

    private String host;
    private String userName;
    private String password;
    private String database;
    private String port;


}
