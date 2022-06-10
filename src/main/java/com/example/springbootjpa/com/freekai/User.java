package com.example.springbootjpa.com.freekai;

import com.example.springbootjpa.com.freekai.event.UserSaveEvent;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

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


    @DomainEvents
    Collection<UserSaveEvent> domainEvents(){
        System.out.println("2.在user保存后...输出user信息：" + this.toString());
        return Arrays.asList(new UserSaveEvent(this.id));
    }

    @AfterDomainEventPublication
    void callbackMethod() {
        // … potentially clean up domain events list
        System.out.println("发布事件后...");
        // 执行线程等待，观察接口返回是否有影响 ==> sleep会影响 接口的返回...
//        try {
//            // sleep会影响 接口的返回...
//            TimeUnit.SECONDS.sleep(5);
//            System.out.println("等待5秒后...");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
