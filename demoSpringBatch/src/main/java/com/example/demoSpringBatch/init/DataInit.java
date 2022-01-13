package com.example.demoSpringBatch.init;

import com.example.demoSpringBatch.entity.EventObject;
import com.example.demoSpringBatch.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
public class DataInit implements ApplicationRunner {
    //создает одно тестовое событие в бд

    private final List<String> list = new LinkedList<>(); //тестовый набор мест проведения мероприятия

    private EventRepository eventRepository;

    @Autowired
    public DataInit(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        list.add("cemetery");
        list.add("crematorium");
        list.add("morgue");

        eventRepository.save(new EventObject("Atlanta", 100, "Ded Dance", list,
                new Date(), new Date()));
    }
}
