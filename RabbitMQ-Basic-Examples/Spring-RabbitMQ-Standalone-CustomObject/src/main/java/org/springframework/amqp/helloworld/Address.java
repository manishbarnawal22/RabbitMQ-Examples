package org.springframework.amqp.helloworld;

import java.io.Serializable;

public class Address implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -1460645702201178736L;
    /**
     * 
     */
    private String streeLine1;
    private Integer pin;
    public String getStreeLine1()
    {
        return streeLine1;
    }
    public void setStreeLine1( String streeLine1 )
    {
        this.streeLine1 = streeLine1;
    }
    public Integer getPin()
    {
        return pin;
    }
    public void setPin( Integer pin )
    {
        this.pin = pin;
    }
}
