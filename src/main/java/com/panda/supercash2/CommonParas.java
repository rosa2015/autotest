package com.panda.supercash2;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;


@Data
public class CommonParas {
    String ip_captcha="https://captcha.pinganzhiyuan.com";
    String ip_ind="http://dev-sit-ind.pinganzhiyuan.com";

    String bundle_id="com.supercs.android";
    String country_code="+62";
    String terminal_name="Supercash";
    String channel_code="16";
    String version="1";
    String platform="android";
    String product_code="SUPERCASH";
    String api_track_id="com.supercs.android_SUPERCASH__1566530247945";//RandomStringUtils.randomAlphanumeric(10);


}
