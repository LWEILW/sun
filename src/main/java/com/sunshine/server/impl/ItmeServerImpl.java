package com.sunshine.server.impl;

import com.sunshine.dao.ItemMapperEx;
import com.sunshine.entity.Item;
import com.sunshine.server.ItemServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ItemServer")
public class ItmeServerImpl implements ItemServer {

    @Autowired
    private ItemMapperEx itemMapperEx;

    @Override
    public Item getItemById(Integer Id) {
        return itemMapperEx.getItemById(Id);
    }
}
