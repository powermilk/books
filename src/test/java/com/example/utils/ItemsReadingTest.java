package com.example.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.example.domain.models.Item;
import com.example.domain.models.JsonResult;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

class ItemsReadingTest {
    private static final Gson GSON = new GsonBuilder().create();
    private List<Item> items;

    @BeforeEach
    void setUp() {
        InputStream inputStream = getClass().getResourceAsStream("/books.json");
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        JsonResult json = GSON.fromJson(reader, JsonResult.class);
        items = json.getItems();
    }

    @Test
    void isItemsSizeOk() {
        Assert.assertEquals(40, items.size());
    }
}
