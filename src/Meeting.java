/*John has invited some friends. His list is:

        s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        Could you make a program that

        makes this string uppercase
        gives it sorted in alphabetical order by last name.
        When the last names are the same, sort them by first name. Last name and first name of a guest come in the result between parentheses separated by a comma.

        So the result of function meeting(s) will be:

        "(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)"
        It can happen that in two distinct families with the same family name two people have the same first name too.
        */


import java.util.*;
import java.util.stream.Collectors;

public class Meeting {

    public static String meeting(String input) {
        String[] friends = input.split(input, ';');
        List<String> friendsList = Arrays.asList(friends);

        friendsList.sort((o1, o2) -> {
            String[] firstFriendsName = input.split(o1, ':');
            String[] secondFriendsName = input.split(o1, ':');

            int compareLastNames = firstFriendsName[1].compareTo(secondFriendsName[1]);
            if (compareLastNames == 0) {
                return firstFriendsName[0].compareTo(secondFriendsName[0]);

            }


            return compareLastNames;
        });

        String result = friendsList.stream().map(s -> {
            String[] personNames = input.split(s, ':');
            return "(".concat(personNames[1].toUpperCase()).concat(", ").concat(personNames[0].toUpperCase().concat(")"));
        }).collect(Collectors.joining(""));

        return result;
    }
}
