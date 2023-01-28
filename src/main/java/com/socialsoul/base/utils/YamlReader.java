package com.socialsoul.base.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YamlReader {
 
    public static String findValue(List<String> parents,String value_key, String yaml){
        int search = yaml.indexOf(parents.get(0));
        int node = countNode(getLine(search, yaml));

        int child = 0;
        boolean firstNode = true;
        boolean lastNode = false;
        int i = search; //comeca a partir da proxima linha 
        while(i != yaml.length()){ //find parent
            if(String.valueOf(yaml.charAt(i)).matches("[:]")){
                String line = getLine(i, yaml);

                if(countNode(line) > node || firstNode){ // eh filho
                    firstNode = false;
                    if(!lastNode){// se n for o last node
                        if(line.contains(parents.get(child))){
                            node = countNode(line);
                            if(child < parents.size()-1){//aumenta se houver mais childs
                                child++;
                            }else{
                                lastNode = true;
                            }
                        }
                    }else{
                        if(line.contains(value_key)){
                            return getValue(line, yaml);
                        }
                    }

                    
                }else{//nao eh filho ou seja nao existe
                    return null;
                }
            }
            i++;
        }

        return null;
    }

    private static int countNode(String line){
        int count = 0;
        while(true){
            if(String.valueOf(line.charAt(count)).matches("[ -]") ){
                count++;
            }else{
                return count;
            }
        }
    }

    private static String getLine(int index,String text){
        int begin= 0;
        int end= 0;
        int i = index;
        while(true){ //corre para tras
            if(String.valueOf(text.charAt(i)).matches("[\n\r]") ){
                begin = i+1;
                break;
            }
            i--;
        }
        i = index;
        while(true){ //corre para frente
            if(String.valueOf(text.charAt(i)).matches("[\n\r]") ){
                end = i;
                break;
            }
            i++;
        }

        return text.substring(begin, end);
    }

    private static String getValue(String line, String yaml){
        Map<String,String> result = new HashMap<>();
        String key = line.substring(0,line.indexOf(":")).trim();
        String value = line.substring(line.indexOf(":") +1, line.length()).trim();
        result.put(key, value);
        return value;
    }

}
