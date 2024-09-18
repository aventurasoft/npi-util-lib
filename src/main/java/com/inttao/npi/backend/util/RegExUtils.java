package com.inttao.npi.backend.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class  RegExUtils {

    /***
     * Devuelve una lista de variables que contiene el texto
     * se identifican con el prefijo
     * Por ejemplo:
     *   'hola @name, bienvenido' -> ["@name"]
     *
     * @param text
     * @param variablePrefix
     * @return
     */
    public static List<String> extractVariables(String text, String variablePrefix) {
        List<String> variables = new ArrayList<>();

        // Definir el patrón para encontrar variables que comiencen con prefijo
        Pattern pattern = Pattern.compile(variablePrefix + "\\w+");
        Matcher matcher = pattern.matcher(text);

        // Encontrar y agregar las variables coincidentes a la lista
        while (matcher.find()) {
            variables.add(matcher.group());
        }

        return variables;
    }

    public static BigDecimal extractPercentage(String input) {
        if (input == null) return null;
        Pattern pattern = Pattern.compile("\\$?\\d+(?:\\.\\d+)?%?");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String decimalNumberStr = matcher.group();
            decimalNumberStr = decimalNumberStr.replaceAll("[\\$%]", ""); // Remover $ y %

            return new BigDecimal(decimalNumberStr);
        }

        return null;
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static String extractDecimal(String input) {
        // Eliminar espacios u otros caracteres no numéricos al principio y al final
        String trimmedInput = input.trim();

        // Remover caracteres no numéricos excepto el punto
        String cleanedInput = trimmedInput.replaceAll("[^0-9.]", "");

        // Buscar el número decimal
        String decimalPart = "";
        boolean decimalFound = false;
        for (char c : cleanedInput.toCharArray()) {
            if (Character.isDigit(c)) {
                decimalPart += c;
                decimalFound = true;
            } else if (c == '.' && decimalFound) {
                decimalPart += c;
            }
        }

        return decimalPart;
    }
}
