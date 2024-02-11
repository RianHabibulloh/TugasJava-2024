package Exercise;

import java.util.ArrayList;

public class AccountList {
    private ArrayList<String> accountNames = new ArrayList<>();
    private ArrayList<String> pins = new ArrayList<>();

    public void addAccount(String accountName, String pin) {
        accountNames.add(accountName);
        pins.add(pin);
    }

    public boolean validateAccount(String accountName, String pin) {
        int index = accountNames.indexOf(accountName);
        return index != -1 && pin.equals(pins.get(index));
    }
}
