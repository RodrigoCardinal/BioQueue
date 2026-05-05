package com.example;

import java.util.Arrays;

public class AnalisisDeSangre {

    private final String[] oNegativo = {"O-"};
    private final String[] oPositivo = {"O-", "O+"};
    private final String[] aNegativo = {"O-", "A-"};
    private final String[] aPositivo = {"O-", "A-", "O+", "A+"};
    private final String[] bNegativo = {"O-", "B-"};
    private final String[] bPositivo = {"O-", "B-", "O+", "B+"};
    private final String[] abNegativo = {"O-", "B-", "A-", "AB-"};
    private final String[] abPositivo = {"O-", "B-", "A-", "AB-", "O+", "B+", "A+", "AB+"};

    public void mostrarCompatibilidades() //muestra todas las compatibilidades de sangre
    {
        StringBuilder toReturn=new StringBuilder();
        toReturn.append("COMPATIBILIDADES DE SANGRE (RECEPTOR <- DONANTE)\r\n");
        toReturn.append("O- puede recibir de: "+Arrays.toString(oNegativo)+"\r\n");
        toReturn.append("O+ puede recibir de: "+Arrays.toString(oPositivo)+"\r\n");
        toReturn.append("A- puede recibir de: "+Arrays.toString(aNegativo)+"\r\n");
        toReturn.append("A+ puede recibir de: "+Arrays.toString(aPositivo)+"\r\n");
        toReturn.append("B- puede recibir de: "+Arrays.toString(bNegativo)+"\r\n");
        toReturn.append("B+ puede recibir de: "+Arrays.toString(bPositivo)+"\r\n");
        toReturn.append("AB- puede recibir de: "+Arrays.toString(abNegativo)+"\r\n");
        toReturn.append("AB+ puede recibir de: "+Arrays.toString(abPositivo)+"\r\n");
        toReturn.append("---------------------------------------------------------------------------------------\r\n");
        System.out.println(toReturn.toString());
    }

    public boolean esCompatible(String tipoReceptor, String tipoDonante) {
        switch (tipoReceptor) {
            case "O-":
                for (String sangre : oNegativo) {
                    if (sangre.equalsIgnoreCase(tipoDonante)) {
                        return true;
                    }
                }
                return (false);
            case "O+":
                for (String sangre : oPositivo) {
                    if (sangre.equalsIgnoreCase(tipoDonante)) {
                        return true;
                    }
                }
                return (false);
            case "A-":
                for (String sangre : aNegativo) {
                    if (sangre.equalsIgnoreCase(tipoDonante)) {
                        return true;
                    }
                }
                return (false);
            case "A+":
                for (String sangre : aPositivo) {
                    if (sangre.equalsIgnoreCase(tipoDonante)) {
                        return true;
                    }
                }
                return (false);
            case "B-":
                for (String sangre : bNegativo) {
                    if (sangre.equalsIgnoreCase(tipoDonante)) {
                        return true;
                    }
                }
                return (false);
            case "B+":
                for (String sangre : bPositivo) {
                    if (sangre.equalsIgnoreCase(tipoDonante)) {
                        return true;
                    }
                }
                return (false);
            case "AB-":
                for (String sangre : abNegativo) {
                    if (sangre.equalsIgnoreCase(tipoDonante)) {
                        return true;
                    }
                }
                return (false);
            case "AB+":
                for (String sangre : abPositivo) {
                    if (sangre.equalsIgnoreCase(tipoDonante)) {
                        return true;
                    }
                }
                return (false);
            default:
                throw new AssertionError();
        }
    }
}
