package com.hnsfdx.hslife.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MiniProgramConst {

    public static String getMiniProgramAppId() {
        return miniProgramAppId;
    }

    public static String getMiniProgramSecret() {
        return miniProgramSecret;
    }

    static String miniProgramAppId="wx18408545fdbead70";
    static String miniProgramSecret="0f24a71aeebfdfd2d3c3dbfb4374873f";

}
