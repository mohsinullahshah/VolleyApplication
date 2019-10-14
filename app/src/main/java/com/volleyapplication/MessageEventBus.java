package com.volleyapplication;

import com.volleyapplication.VolleyClasses.ModalObject;

import java.util.ArrayList;
import java.util.List;

public class MessageEventBus {


    List<ModalObject> list = new ArrayList<>();

    public MessageEventBus(List<ModalObject> list)
    {
        this.list = list;
    }

}
