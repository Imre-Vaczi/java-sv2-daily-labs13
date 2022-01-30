package day05;

public class TransferPerClient {

    private String clientID;
    private int sum;
    private int numOfTrans;

    public TransferPerClient(String clientID, int sum, int numOfTrans) {
        this.clientID = clientID;
        this.sum = sum;
        this.numOfTrans = numOfTrans;
    }

    public TransferPerClient increase(int amount) {
        this.sum += amount;
        this.numOfTrans ++;
        return this;
    }

    public TransferPerClient decrease(int amount) {
        this.sum -= amount;
        this.numOfTrans ++;
        return this;
    }

    @Override
    public String toString() {
        return clientID + "," + sum + "," + numOfTrans + "\t";
    }

    public String getClientID() {
        return clientID;
    }

    public int getSum() {
        return sum;
    }

    public int getNumOfTrans() {
        return numOfTrans;
    }
}
