package com.socialsoul.base.utils;

public class TextReader {
    

    public static String codeSnippet(String text, int index, int lines){

        //corre pra tras
        int lastIndex = index;
        for(int i =0; i <= lines; i++ ){
            int auxIndex = text.lastIndexOf("\n", lastIndex -1);
            lastIndex =  auxIndex == -1 ? lastIndex : auxIndex; 
        }
        //corre pra frente
        int nextIndex = index;
        for(int i =0; i <= lines; i++ ){
            int auxIndex = text.indexOf("\n", nextIndex+1);
            nextIndex =  auxIndex == -1 ? nextIndex : auxIndex; 
        }

        return text.substring(lastIndex, nextIndex);
    }
}
