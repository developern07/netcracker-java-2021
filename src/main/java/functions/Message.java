package functions;

import helpers.CheckStatus;

/**
 * Message model
 */
public class Message {
    /**
     * parameter to check
     */
    protected String check;

    /**
     * Method of getting parameter to check
     * @return check
     */
    public String getCheck() {
        return check;
    }

    /**
     * Method of setting parameter to check
     * @param check
     */
    public void setCheck(String check) {
        this.check = check;
    }

    /**
     * Status of check
     */
    protected CheckStatus status;

    /**
     * Method of getting status of check
     * @return status
     */
    public CheckStatus getStatus() { return status; }

    /**
     * Method of setting status of check
     * @param status
     */
    public void setStatus(CheckStatus status) {
        this.status = status;
    }

    /**
     * Constructor of message
     * @param check
     * @param status
     */
    public Message(String check, CheckStatus status) {
        this.check = check;
        this.status = status;
    }

    /**
     * Method of getting string to string
     * @return message to string
     */
    @Override
    public String toString() {
        return "Message{" +
                "check='" + check + '\'' +
                ", status=" + status +
                '}';
    }
}