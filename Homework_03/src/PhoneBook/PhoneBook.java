package PhoneBook;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String[]>> map;

    public PhoneBook() {
        map = new HashMap<>();
    }

    public void add(Person person) {
        String name = person.getName();
        String[] contacts = {person.getPhone(), person.getEmail()};
        ArrayList<String[]> listContacts = new ArrayList<>();
        listContacts.add(contacts);
        if (map.containsKey(name)) {
           map.get(name).addAll(listContacts);
        } else {
            map.put(name, listContacts);
        }
    }

    public ArrayList<String> findPhone(String name) {
        if (map.containsKey(name)) {
            ArrayList<String[]> listContacts = map.get(name);
            ArrayList<String> listPhone = new ArrayList<>();
            for (int i=0; i < listContacts.size(); i++) {
                listPhone.add(listContacts.get(i)[0]);
            }
            return listPhone;
        } else {
            return null;
        }
    }

    public ArrayList<String> findEmail(String name) {
        if (map.containsKey(name)) {
            ArrayList<String[]> listContacts = map.get(name);
            ArrayList<String> listEmail = new ArrayList<>();
            for (int i=0; i < listContacts.size(); i++) {
                listEmail.add(listContacts.get(i)[1]);
            }
            return listEmail;
        } else {
            return null;
        }
    }



}
