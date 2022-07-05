package com.apachefirst.models;

import org.apache.wicket.model.IModel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeModel implements IModel {
    @Override
    public Object getObject() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss:SSS");
        return simpleDateFormat.format(date);
    }

    @Override
    public void setObject(Object object) {

    }

    @Override
    public void detach() {
    }
}
