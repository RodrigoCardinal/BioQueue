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

    //private ListaEnlazada<String> Onegativo;   // qué tipos puede recibir O-
    //private ListaEnlazada<String> Opositivo;   // qué tipos puede recibir O+
    //private ListaEnlazada<String> Anegativo;   // qué tipos puede recibir A-
    //private ListaEnlazada<String> Apositivo;   // qué tipos puede recibir A+
    //private ListaEnlazada<String> Bnegativo;   // qué tipos puede recibir B-
    //private ListaEnlazada<String> Bpositivo;   // qué tipos puede recibir B+
    // ListaEnlazada<String> ABnegativo;  // qué tipos puede recibir AB-
    //private ListaEnlazada<String> ABpositivo;  // qué tipos puede recibir AB+
    //public Lista_PosiblesTipodeSangre() {
    //this.Onegativo = new ListaEnlazada<>();
    //this.Opositivo = new ListaEnlazada<>();
    //this.Anegativo = new ListaEnlazada<>();
    //this.Apositivo = new ListaEnlazada<>();
    //this.Bnegativo = new ListaEnlazada<>();
    //this.Bpositivo = new ListaEnlazada<>();
    //this.ABnegativo = new ListaEnlazada<>();
    //this.ABpositivo = new ListaEnlazada<>();
    //cargarCompatibilidades();
    //}
    //private void cargarCompatibilidades() {
    //Onegativo.agregar("O-"); //o negativo solo puede recibir de otro o negativo
    //Opositivo.agregar("O-"); //o positivo puede recibir de o negativo
    //Opositivo.agregar("O+");//o positivo puede recibir de o positivo
    //Anegativo.agregar("O-");//a negativo puede recibir de o negativo
    //Anegativo.agregar("A-");//a negativo puede recibir de a negativo
    //Apositivo.agregar("O-");//a positivo puede recibir de o negativo
    //Apositivo.agregar("O+");//a positivo puede recibir de o positivo
    //Apositivo.agregar("A-");//a positivo puede recibir de a negativo
    //Apositivo.agregar("A+");//a positivo puede recibir de a positivo
    //Bnegativo.agregar("O-");//b negativo puede recibir de o negativo
    //Bnegativo.agregar("B-");//b negativo puede recibir de b negativo
    //Bpositivo.agregar("O-");//b positivo puede recibir de o negativo
    //Bpositivo.agregar("O+");//b positivo puede recibir de o positivo
    //Bpositivo.agregar("B-");//b positivo puede recibir de b negativo
    //Bpositivo.agregar("B+");//b positivo puede recibir de b positivo
    //ABnegativo.agregar("O-");//ab negativo puede recibir de o negativo
    //ABnegativo.agregar("A-");//ab negativo puede recibir de a negativo
    //ABnegativo.agregar("B-");//ab negativo puede recibir de b negativo
    //ABnegativo.agregar("AB-");//ab negativo puede recibir de ab negativo
    // RECEPTOR AB Positivo (AB+) recibe de TODOS
    //ABpositivo.agregar("O-");
    //ABpositivo.agregar("O+");
    //ABpositivo.agregar("A-");
    //ABpositivo.agregar("A+");
    //ABpositivo.agregar("B-");
    //ABpositivo.agregar("B+");
    //ABpositivo.agregar("AB-");
    //ABpositivo.agregar("AB+");
    //}
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
        //     System.out.println(" COMPATIBILIDADES DE SANGRE (RECEPTOR <- DONANTE) ");
        //     System.out.print("O- puede recibir de: \n");
        //     for (int i = 0; i < Onegativo.tamaño(); i++) {
        //         System.out.print(Onegativo.obtener(i) + "\n");
        //     }
        //     System.out.println("---------------------------------------");
        //     System.out.print("O+ puede recibir de: \n");
        //     for (int i = 0; i < Opositivo.tamaño(); i++) {
        //         System.out.print(Opositivo.obtener(i) + "\n");
        //     }
        //     System.out.println("---------------------------------------");
        //     System.out.print("A- puede recibir de: \n");
        //     for (int i = 0; i < Anegativo.tamaño(); i++) {
        //         System.out.print(Anegativo.obtener(i) + "\n");
        //     }
        //     System.out.println("---------------------------------------");
        //     System.out.print("A+ puede recibir de: \n");
        //     for (int i = 0; i < Apositivo.tamaño(); i++) {
        //         System.out.print(Apositivo.obtener(i) + "\n");
        //     }
        //     System.out.println("---------------------------------------");
        //     System.out.print("B- puede recibir de: \n");
        //     for (int i = 0; i < Bnegativo.tamaño(); i++) {
        //         System.out.print(Bnegativo.obtener(i) + "\n");
        //     }
        //     System.out.println("---------------------------------------");
        //     System.out.print("B+ puede recibir de: \n");
        //     for (int i = 0; i < Bpositivo.tamaño(); i++) {
        //         System.out.print(Bpositivo.obtener(i) + "\n");
        //     }
        //     System.out.println("---------------------------------------");
        //     System.out.print("AB- puede recibir de: \n");
        //     for (int i = 0; i < ABnegativo.tamaño(); i++) {
        //         System.out.print(ABnegativo.obtener(i) + "\n");
        //     }
        //     System.out.println("---------------------------------------");
        //     System.out.print("AB+ puede recibir de: \n");
        //     for (int i = 0; i < ABpositivo.tamaño(); i++) {
        //         System.out.print(ABpositivo.obtener(i) + "\n");
        //     }
        //     System.out.println("---------------------------------------");
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

        //     ListaEnlazada<String> listaCompatibles = null;
        //     // Primero: obtener la lista correspondiente al tipo de sangre del receptor
        //     if (tipoReceptor.equals("O-")) {
        //         listaCompatibles = Onegativo;
        //     } else if (tipoReceptor.equals("O+")) {
        //         listaCompatibles = Opositivo;
        //     } else if (tipoReceptor.equals("A-")) {
        //         listaCompatibles = Anegativo;
        //     } else if (tipoReceptor.equals("A+")) {
        //         listaCompatibles = Apositivo;
        //     } else if (tipoReceptor.equals("B-")) {
        //         listaCompatibles = Bnegativo;
        //     } else if (tipoReceptor.equals("B+")) {
        //         listaCompatibles = Bpositivo;
        //     } else if (tipoReceptor.equals("AB-")) {
        //         listaCompatibles = ABnegativo;
        //     } else if (tipoReceptor.equals("AB+")) {
        //         listaCompatibles = ABpositivo;
        //     }
        //     // Segundo: si la lista es null, el tipo de sangre no existe
        //     if (listaCompatibles == null) {
        //         return false;
        //     }
        //     // Tercero: recorrer la lista buscando el tipo del donante
        //     for (int i = 0; i < listaCompatibles.tamaño(); i++) {
        //         String tipoPermitido = listaCompatibles.obtener(i);
        //         if (tipoPermitido.equals(tipoDonante)) {
        //             return true;  // es compatible
        //         }
    }

    //     return false;  //no es compatible
}
