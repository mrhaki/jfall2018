package jfall;

import java.io.Serializable;

public class Request implements Serializable {

    private int value;

    public Request() {
    }

    public Request(final int value) {
        this.value = value;
    }

    public Request(final String value) {
        this.value = Integer.parseInt(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

}
