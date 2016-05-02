/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.client;

import projetsinnovation.common.Request;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;

/**
 * @author Sofiane
 */

/**
 * @author Alain Defrance
 */
public class Client {
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private String name;

    public Client(String name, ObjectInputStream ois, ObjectOutputStream oos) {
        this.name = name;
        this.ois = ois;
        this.oos = oos;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        oos.writeObject(new Request(name, args, method.getName()));
        return ois.readObject();
    }
}
