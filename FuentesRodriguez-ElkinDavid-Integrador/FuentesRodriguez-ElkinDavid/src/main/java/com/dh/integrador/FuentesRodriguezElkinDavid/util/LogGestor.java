package com.dh.integrador.FuentesRodriguezElkinDavid.util;

import org.apache.log4j.PropertyConfigurator;

import java.io.File;

public class LogGestor {

    public static final String RUTA_ABSOLUTA_ARCHIVO_PROPERTIES = "C:\\Users\\ekn31\\OneDrive\\Desktop\\KSJO\\FuentesRodriguez-ElkinDavid-Integrador\\FuentesRodriguez-ElkinDavid\\src\\main\\java\\config\\log4j.properties";

    public static void inicializar(){
        File log4jFile = new File(RUTA_ABSOLUTA_ARCHIVO_PROPERTIES);
        PropertyConfigurator.configure(log4jFile.getAbsolutePath());
    }
}
