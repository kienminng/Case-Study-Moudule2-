package Person;

import java.io.Serializable;

public class ClientOfTheMonth implements Serializable {
    private String nameOfClient;
    private Double Money;

    

    public ClientOfTheMonth(String nameOfClient, Double money) {
        this.nameOfClient = nameOfClient;
        Money = money;
    }

    public ClientOfTheMonth() {
    }

    public String getNameOfClient() {
        return nameOfClient;
    }

    public void setNameOfClient(String nameOfClient) {
        this.nameOfClient = nameOfClient;
    }

    public Double getMoney() {
        return Money;
    }

    public void setMoney(Double money) {
        Money = money;
    }

    @Override
    public String toString() {
        return "ClientOfTheMonth" +
                "nameOfClient = '" + nameOfClient + '\'' +
                ", Money = " + Money +"\n"
                ;
    }
}
