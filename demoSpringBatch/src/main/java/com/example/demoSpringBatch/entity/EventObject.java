package com.example.demoSpringBatch.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

//@Schema(description = "Сущность событий")
@Table(name = "event")
@Entity
@Getter @Setter
public class EventObject {
    //в application.properties включен веб интерфейс на котором можно посмотреть таблицы
    //по адресу http://localhost:8080/h2-console

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    //@Schema(description = "Город проведения", example = "")
    @Column(name = "city")
    private String city;

    //@Schema(description = "Возрастные ограничения", example = "")
    @Column(name = "ageRestriction")
    private int ageRestriction;

    //@Schema(description = "Название", example = "")
    @Column(name = "name")
    private String name;

    //@Schema(description = "Места проведения", example = "")
    @ElementCollection
    @Column(name = "buildings")
    private List<String> buildings;

    //@Schema(description = "Дата начала показа", example = "")
    @Column(name = "startDateTime")
    private Date startDateTime;

    //@Schema(description = "Дата окончания показа", example = "")
    @Column(name = "endDateTime")
    private Date endDateTime;

    public EventObject(){
    }

    public EventObject(String city, int ageRestriction, String name, List<String> buildings,
                       Date startDateTime, Date endDateTime){
        this.city = city;
        this.ageRestriction = ageRestriction;
        this.name = name;
        this.buildings = buildings;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

}
