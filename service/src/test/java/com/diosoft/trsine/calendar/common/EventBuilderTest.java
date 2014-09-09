package com.diosoft.trsine.calendar.common;

import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class EventBuilderTest {

    @Test
    public void testSetAttendersWithHashSet() throws Exception {
        //init
        Event.Builder builder1 = new Event.Builder() {
            @Override
            public Set newSet() {
                return new HashSet<String>();
            }
        };

        builder1
                .addAttender("alex@zamkovyi.name")
                .addAttender("igor.vartanian@gmail.com");

        HashSet<String> set = new HashSet<String>();
        set.add("alex@zamkovyi.name");
        set.add("igor.vartanian@gmail.com");

        Event.Builder builder2 = new Event.Builder() {
            @Override
            public Set newSet() {
                return new HashSet<String>();
            }
        };
        builder2.setAttenders(set);

        //check
        assertEquals(builder1, builder2);
    }

    @Test
    public void testRemoveAttender() throws Exception {
        //init
        Event.Builder builder1 = new Event.Builder() {
            @Override
            public Set newSet() {
                return new HashSet<String>();
            }
        };

        builder1
                .addAttender("alex@zamkovyi.name")
                .addAttender("igor.vartanian@gmail.com")
                .removeAttender("alex@zamkovyi.name");

        HashSet<String> set = new HashSet<String>();
        set.add("igor.vartanian@gmail.com");

        Event.Builder builder2 = new Event.Builder() {
            @Override
            public Set newSet() {
                return new HashSet<String>();
            }
        };
        builder2.setAttenders(set);

        //check
        assertEquals(builder1, builder2);
    }
}