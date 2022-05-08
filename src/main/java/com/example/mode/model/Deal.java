package com.example.mode.model;

import java.sql.Date;

public class Deal {

    private int id;
    private Date dateStart;
    private Date dateCloth;
    private Date dateEnd;
    private boolean done;
    private Cloth cloth;
    private Client client;
    private Master master;
    private Model model;

    public Deal() {
    }

    public Deal(int id,Date dateStart, Date dateCloth, Date dateEnd, boolean done, Cloth cloth, Client client, Master master, Model model) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateCloth = dateCloth;
        this.dateEnd = dateEnd;
        this.done = done;
        this.cloth = cloth;
        this.client = client;
        this.master = master;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateCloth() {
        return dateCloth;
    }

    public void setDateCloth(Date dateCloth) {
        this.dateCloth = dateCloth;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Cloth getCloth() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
