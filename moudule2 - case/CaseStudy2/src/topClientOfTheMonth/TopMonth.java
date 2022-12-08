package topClientOfTheMonth;

import Person.ClientOfTheMonth;

import java.util.Comparator;

public class TopMonth implements Comparator<ClientOfTheMonth> {
    @Override
    public int compare(ClientOfTheMonth o1, ClientOfTheMonth o2) {
        if (o1.getMoney()>o2.getMoney()){
            return -1;
        } else if (o1.getMoney()==o2.getMoney()) {
            return 0;
        } else {
            return 1;
        }
    }
}
