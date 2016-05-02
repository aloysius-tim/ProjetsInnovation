package common;

import java.io.Serializable;

public class Request implements Serializable {
    private Object[] args;
    private String method;
    private String name;

    public Request() {
    }

    public Request(String name, Object[] args, String method) {
        this.name = name;
        this.args = args;
        this.method = method;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
