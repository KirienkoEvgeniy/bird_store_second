package application;

import processor.IInfiniteLoopProcessor;
import processor.UserCommandProcessor;

public class BirdStoreApplication {

    public static void main(String[] args) {
         IInfiniteLoopProcessor userCommandProcessor = new UserCommandProcessor(); //создать реальный объект
         userCommandProcessor.processInLoop();


    }
}
