package me.playernguyen;

import me.playernguyen.configuration.StoreType;

public enum OptEcoConfiguration {

    CHECK_FOR_UPDATE        ("checkForUpdate", true),
    START_BALANCE           ("settings.startBalance", 0.0),
    MIN_BALANCE             ("settings.minimumBalance", -15.0),
    PAYMENT_CONFIRM         ("settings.timeToConfirmPayment", 15),
    CURRENCY_SYMBOL         ("settings.currencySymbol", "points"),
    STORED_TYPE             ("settings.storeType", StoreType.YAML.toString()),
    ACCOUNT_AUTO_UPDATE     ("settings.autoUpdate", true),

    MYSQL_HOST              ("settings.mysql.host", "localhost"),
    MYSQL_DATABASE          ("settings.mysql.database", "dbname"),
    MYSQL_PORT              ("settings.mysql.port", "3306"),
    MYSQL_USERNAME          ("settings.mysql.username", "root"),
    MYSQL_PASSWORD          ("settings.mysql.password", ""),
    MYSQL_TABLE_NAME        ("settings.mysql.tableName", "OptEco"),

    DEBUG                   ("debug", false),
    LANGUAGE_FILE           ("language", "lang")



    ;

    private String path;
    private Object wh;

    OptEcoConfiguration(String path, Object wh) {
        this.path = path;
        this.wh = wh;
    }

    public String getPath() {
        return path;
    }

    public Object getDefaultSetting() {
        return wh;
    }
}
