package org.example;//Реализуйте структуру телефонной книги с помощью HashMap.
//Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
//их необходимо считать, как одного человека с разными телефонами.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        addPhone(map, "Ivan", "+79114253658");
        addPhone(map, "Ivan", "+785632541");
        addPhone(map, "Konstantin", "+79114253658");
        addPhone(map, "Ivan", "+7921452341");
        addPhone(map, "Anna", "+79114253658");
        addPhone(map, "Anna", "+7856552251");

        ArrayList<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            list.add(s);
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1).size() - map.get(o2).size();
            }
        });
        list.forEach(n -> System.out.println(map.get(n) + " " + n));


    }

    private static void addPhone(HashMap<String, ArrayList<String>> map, String name, String phone) {
        map.putIfAbsent(name, new ArrayList<>());
        map.get(name).add(phone);
    }
}


