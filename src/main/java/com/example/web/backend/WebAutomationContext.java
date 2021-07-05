package com.example.web.backend;

import java.util.HashMap;

public class WebAutomationContext {
    private static HashMap<ContextKeys, String> contextMap;


    public static void initializeContext(){
        contextMap = new HashMap<ContextKeys, String>();
    }

    public static void addContext(ContextKeys key, String value){
        if(contextMap == null)
            initializeContext();
        if(contextMap.get(key) != null)
            contextMap.remove(key);
        contextMap.put(key, value);
    }

    public static String getContextValue(ContextKeys key){
        if(contextMap == null)
            return "CONTEXT IS NULL";
        String value = contextMap.get(key);
        if(value == null)
            return "CONTEXT WITH KEY " + key + " NOT FOUND";
        return value;
    }

}
