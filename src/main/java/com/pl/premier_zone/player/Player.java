package com.pl.premier_zone.player;

import jakarta.persistence.*;

@Entity
@Table(name="player_data")
public class Player {

    @Id
    @Column(name="player_name", unique=true)
    private String name;
    private String nation;
    private String position;
    private String team;
    private Double age;
    private Integer mp;
    private Integer starts;
    private Double min;
    private Double goals;
    private Double assists;
    private Double pk;
    private Double crdy;
    private Double crdr;
    private Double xg;
    private Double xa;

    public Player() {

    }

    public Player(String name, Double xa, Double xg, Double crdr, Double crdy, Double pk, Double assists, Double goals, Double min, Integer starts, Integer mp, Double age, String team, String position, String nation) {
        this.name = name;
        this.xa = xa;
        this.xg = xg;
        this.crdr = crdr;
        this.crdy = crdy;
        this.pk = pk;
        this.assists = assists;
        this.goals = goals;
        this.min = min;
        this.starts = starts;
        this.mp = mp;
        this.age = age;
        this.team = team;
        this.position = position;
        this.nation = nation;
    }

    public Player(String name, String nation, String position, String team, Double age) {
        this.name = name;
        this.nation = nation;
        this.position = position;
        this.team = team;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public Integer getStarts() {
        return starts;
    }

    public void setStarts(Integer starts) {
        this.starts = starts;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getGoals() {
        return goals;
    }

    public void setGoals(Double goals) {
        this.goals = goals;
    }

    public Double getAssists() {
        return assists;
    }

    public void setAssists(Double assists) {
        this.assists = assists;
    }

    public Double getPk() {
        return pk;
    }

    public void setPk(Double pk) {
        this.pk = pk;
    }

    public Double getCrdy() {
        return crdy;
    }

    public void setCrdy(Double crdy) {
        this.crdy = crdy;
    }

    public Double getCrdr() {
        return crdr;
    }

    public void setCrdr(Double crdr) {
        this.crdr = crdr;
    }

    public Double getXg() {
        return xg;
    }

    public void setXg(Double xg) {
        this.xg = xg;
    }

    public Double getXa() {
        return xa;
    }

    public void setXa(Double xa) {
        this.xa = xa;
    }
}

