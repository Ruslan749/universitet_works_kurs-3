package com.example.exa1_start.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    private List<String> dataArrayList = new ArrayList<>() ;
    private Map<Integer, String> dataHashMap = new HashMap<>();

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "Word") String name){
        return String.format("Hello %s",name);
    }

    @GetMapping("/update-array")
    public void uppdataArrayList(@RequestParam(value = "name") String name){
        if (dataArrayList.isEmpty()){
            dataArrayList = new ArrayList<>();
            dataArrayList.add(name);
            System.out.println("1 вложение элимента в array List: " + dataArrayList.get(0));
        }else {
            dataArrayList.add(name);
            System.out.println(dataArrayList);
        }
    }

    @GetMapping("/show-array")
    public String showArrayList(){
        return String.format(dataArrayList.toString());
    }

    @GetMapping("/update-map")
    public void updateHashMap(@RequestParam(value = "data") String data){

        if (dataHashMap.isEmpty()){
            dataHashMap = new HashMap<>();
        }

        int counter = dataHashMap.size()+1;
        dataHashMap.put(counter, data);
        System.out.println(dataHashMap);
    }

    @GetMapping("/show-map")
    public String showHashMap(){
        return String.format(dataHashMap.toString());
    }

    @GetMapping("/show-all-lenght")
    public String showAllLenght(){
        String resault = "All Lenght:\n" +
                "arrayList: " + dataArrayList.size() +
                "\n HashMap: " + dataHashMap.size();
        return String.format(resault);
    }
}
