package com.test.JsonArraySortDemo;

import java.util.ArrayList;
import java.util.List;

public class TestEquals {
    public static void main(String[] args) {
        List<Role> baseList = new ArrayList<Role>();
        List<Role> newList = new ArrayList<Role>();
 
        for (int i = 0; i < 50; i++) {
            baseList.add(new Role(i, "role:" + i));
        }
        for (int i = 0; i < 100; i++) {
            newList.add(new Role(i, "role:" + i));
        }
 
        System.out.println(baseList.get(0).equals(newList.get(0)));
        System.out.println(newList.get(0).equals(baseList.get(0)));
 
        newList.removeAll(baseList);
        for (Role role : newList) {
            System.out.println(role);
        }
    }
}
 
class Role {
    private Integer id;
    private String name;
 
    public Role() {
 
    }
 
    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else {
            if (obj instanceof Role) {
                if (((Role) obj).getId().equals(this.getId())) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
 
    @Override
    public String toString() {
        return this.getName();
    }
}