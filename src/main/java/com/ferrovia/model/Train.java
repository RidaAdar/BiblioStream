package com.ferrovia.model;

import jakarta.persistence.*;

@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String type;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Station getStation() { return station; }
    public void setStation(Station station) { this.station = station; }
}
