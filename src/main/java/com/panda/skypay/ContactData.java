package com.panda.skypay;

import lombok.Data;

import java.io.Serializable;


@Data
public class ContactData implements Serializable {//
    String contactId;
    String displayName;
    String mobile;
}
