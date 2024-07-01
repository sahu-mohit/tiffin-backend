package com.tifin.common;

import com.tifin.Utility.DataTypeUtility;
import com.tifin.dto.request.Payload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.util.Base64;

@Slf4j
@Service
public class AesUtil {
    public String decode(String strValue){
        if(!DataTypeUtility.isValid(strValue)){
            return  strValue;
        }
        try{
            strValue = strValue.replaceAll(" ", "+");
            strValue = new String(Base64.getDecoder().decode(strValue));
            strValue = URLDecoder.decode(strValue, "UTF-8");
            return strValue;
        }catch (Exception e){
            log.error("Decode Exception caught >>>> "+ e);
        }
        return "";
    }
}
