package reseau.common;

import java.io.Serializable;

/**
 * The type Response.
 */
public class Response implements Serializable {
    private Status status;
    private String message;
    private Serializable value;

    /**
     * Instantiates a new Response.
     *
     * @param status  the status
     * @param message the message
     * @param value   the value
     */
    public Response(Status status, String message, Serializable value) {
        this.status = status;
        this.message = message;
        this.value = value;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public Serializable getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (status == null) status = Status.NOSTATUS;
        if (message == null) message = "null";
        if (value == null) value = "null";

        String r = "\n\tstatus \t\t: " + status.toString();
        r += "\n\tmessage \t: " + message;
        r += "\n\tvalue \t\t: [";
        if (this.value instanceof Iterable || this.value instanceof Object[]) {
            Iterable l = (Iterable) this.value;
            for (Object o : l) {
                r += "\n\t\t";
                r += o.toString();

            }
            r += "\n\t";
        } else if (this.value instanceof Exception) {
            Exception e = (Exception) this.value;
            r += e.getClass().getSimpleName();
        }


        r += "]";
        return r;
    }
}
