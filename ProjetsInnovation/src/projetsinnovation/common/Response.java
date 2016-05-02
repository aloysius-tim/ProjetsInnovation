/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.common;

import java.io.Serializable;

/**
 *
 * @author Sofiane
 */
public class Response implements Serializable {
    private Status status;
    private String message;
    private Serializable value;

    public Response(Status status, String message, Serializable value) {
        this.status = status;
        this.message = message;
        this.value = value;
    }
}
