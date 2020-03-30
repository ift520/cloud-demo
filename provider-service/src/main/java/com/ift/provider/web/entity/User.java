package com.ift.provider.web.entity;

import java.io.Serializable;

/**
 * 用户对象
 *
 * @author liufei
 * @since 2020/3/30
 */
public class User implements Serializable {

    private static final long serialVersionUID = 620471281928231884L;

    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
