package com.example.springbootjpa.com.freekai;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;

    /**
     * @OneToOne 映射 不配置双向主键作为外键的话， 配置mapper的一方，本代码中是user 即使配置了address对象的Lazy延迟加载，也不会生效..
     *
     *          当配置双向主键关联时， 去掉mapper, LAZY延迟加载生效
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY/*, mappedBy = "user"*/)
    @JoinColumn(name = "address_id")
    private Address address;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
