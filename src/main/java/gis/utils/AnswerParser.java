package gis.utils;

import gis.app.NdsResponse2;

public class AnswerParser {

    private static String getResponse(String number) {
        switch (number) {
            case "0":
                return "Налогоплательщик зарегистрирован в ЕГРН и имел статус действующего в указанную дату";
            case "1":
                return "Налогоплательщик зарегистрирован в ЕГРН, но не имел статус действующего в указанную дату ";
            case "2":
                return "Налогоплательщик зарегистрирован в ЕГРН ";
            case "3":
                return "Налогоплательщик с указанным ИНН зарегистрирован в ЕГРН, КПП не соответствует ИНН или не указан";
            case "4":
                return "Налогоплательщик с указанным ИНН не зарегистрирован в ЕГРН 5 - Некорректный ИНН ";
            case "6":
                return "Недопустимое количество символов ИНН";
            case "7":
                return "Недопустимое количество символов КПП ";
            case "8":
                return "Недопустимые символы в ИНН ";
            case "9":
                return "Недопустимые символы в КПП";
            case "11":
                return "некорректный формат даты";
            case "12":
                return "некорректная дата (ранее 01.01.1991 или позднее текущей даты)";
            default:
                return "Что-то пошло не так";
        }
    }

    public static void printState(NdsResponse2.NP np){
        System.out.println("ИНН: " + np.getINN());
        System.out.println("КПП: " + np.getKPP());
        System.out.println("Дата: " + np.getDT());
        System.out.println("Ответ: " + getResponse(np.getState()));
    }

}