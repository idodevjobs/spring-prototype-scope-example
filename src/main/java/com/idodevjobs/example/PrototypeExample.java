package com.idodevjobs.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.inject.Provider;

@Service
public class PrototypeExample {

    @Autowired
    private PrototypeService prototypeService;

    @Autowired
    Provider<PrototypeService> prototypeServiceProvider;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        System.out.println("non-autowired access : " + context.getBean(PrototypeService.class));
        System.out.println("non-autowired access : " + context.getBean(PrototypeService.class));
        PrototypeExample prototypeExample = context.getBean(PrototypeExample.class);
        PrototypeExample prototypeExample1 = context.getBean(PrototypeExample.class);
        prototypeExample.printMessageSingleton();
        prototypeExample1.printMessageSingleton();
        prototypeExample.printMessagePrototype();
        prototypeExample1.printMessagePrototype();
    }

    private void printMessageSingleton() {
        System.out.println("printMessageSingleton : " + prototypeService);
    }

    private void printMessagePrototype() {
        PrototypeService prototypeService1 = prototypeServiceProvider.get();
        System.out.println("printMessagePrototype : " + prototypeService1);
        PrototypeService prototypeService2 = prototypeServiceProvider.get();
        System.out.println("printMessagePrototype : " + prototypeService2);
    }
}