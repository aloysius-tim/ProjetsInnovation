/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.common;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Sofiane
 */
public class Request implements Serializable {
 
    private String method;
    private HashMap<String, Object> args;
}
