package projetsinnovation.common;

/**
 * Created by matthieuberger on 30/04/2016.
 */
public enum Status {
    ;

    public int code;
    public String message;

    Status(int codeId, String message){
        this.code = codeId;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
