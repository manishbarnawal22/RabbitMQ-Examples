package org.springframework.amqp.helloworld;

import java.io.Serializable;

public class Employee implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -3157242198201576989L;
    
    private Integer id;
    private String name;
    private Address address;

    public Address getAddress()
    {
        return address;
    }

    public void setAddress( Address address )
    {
        this.address = address;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }
}
