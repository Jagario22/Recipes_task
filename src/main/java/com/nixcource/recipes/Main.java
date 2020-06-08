package com.nixcource.recipes;

import com.nixcource.recipes.builder.DataBuilder;
import com.nixcource.recipes.config.ApplicationEnvironment;

public class Main {

    public static void main(String[] args) {
        runDataBuilder(args);
    }

    private static  void runDataBuilder(String[] args) {
        DataBuilder dataBuilder = new DataBuilder();
        if (args.length != 0) {
            ApplicationEnvironment.setPropertyLang(args[0]);
        } else {
            ApplicationEnvironment.setPropertyLang("ru");
        }
        dataBuilder.buildDataList();
    }
}
