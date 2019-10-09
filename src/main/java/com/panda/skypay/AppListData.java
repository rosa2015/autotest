package com.panda.skypay;

import lombok.Data;

import java.io.Serializable;


@Data
public class AppListData implements Serializable {
    private String appName;
    private String packageName;

}
