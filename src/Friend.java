import java.util.ArrayList;

public class Friend {

    public Friend()
    {

    }

    public String singleGreet(String name)
    {
        if (name == null || name.isEmpty())
            return "Hello, my friend.";
        else if (name.equals(name.toUpperCase()))
            return "HELLO " + name + "!";
        return "Hello, " + name + ".";
    }

    public String doubleGreet(ArrayList<String> names)
    {
        if (names.get(0) != null && !names.get(0).isEmpty() && names.get(0).equals(names.get(0).toUpperCase()) && (names.get(1) == null || !names.get(1).equals(names.get(1).toUpperCase()) || names.get(1).isEmpty()))
            return "Hello, " + handleName(names.get(1)) + ". " + handleName(names.get(0));
        else if (names.get(1) != null && !names.get(1).isEmpty() && names.get(1).equals(names.get(1).toUpperCase()) && (names.get(0) == null || !names.get(0).equals(names.get(0).toUpperCase()) || names.get(0).isEmpty()))
            return "Hello, " + handleName(names.get(0)) + ". " + handleName(names.get(1));
        else if (names.get(0) != null && !names.get(0).isEmpty() && names.get(1) != null && !names.get(1).isEmpty() && names.get(0).equals(names.get(0).toUpperCase()) && names.get(1).equals(names.get(1).toUpperCase()))
            return handleName(names.get(0)) + " " + handleName(names.get(1));
        return "Hello, " + handleName(names.get(0)) + " and " + handleName(names.get(1)) + ".";
    }

    public String handleName(String name)
    {
        if (name == null || name.isEmpty())
            return "my friend";
        else if (name.equals(name.toUpperCase()))
            return "HELLO " + name + "!";
        return name;
    }

    public String greet(String ...namesArr)
    {
        if (namesArr == null || namesArr.length == 0)
            return "Hello, my friend.";

        ArrayList<String> names = new ArrayList<>();
        for (String str : namesArr)
        {
            if (str != null && !str.isEmpty() && str.contains(", "))
            {
                if (str.contains("\""))
                    names.add(str.replaceAll("\"", ""));
                else
                {
                    String[] splitNames = str.split(", ");
                    for (String n : splitNames)
                    {
                        names.add(n);
                    }
                }
            }
            else
            {
                names.add(str);
            }
        }

        if (names.size() == 1) {
            return singleGreet(names.get(0));
        }
        else if (names.size() == 2)
        {
            return doubleGreet(names);
        }
        else {
            ArrayList<String> shouts = new ArrayList<>();
            ArrayList<String> nonShouts = new ArrayList<>();
            for (String str : names)
            {
                if (str != null && !str.isEmpty() && str.equals(str.toUpperCase()))
                    shouts.add(handleName(str));
                else
                    nonShouts.add(handleName(str));
            }
            String result = "";
            if (!nonShouts.isEmpty())
            {
                if (nonShouts.size() == 1)
                    result += singleGreet(nonShouts.get(0)) + " ";
                else if (nonShouts.size() == 2)
                    result += doubleGreet(nonShouts) + " ";
                else {
                    result += "Hello, ";
                    for (int i = 0; i < nonShouts.size(); i++) {
                        if (i == nonShouts.size() - 1)
                            result += "and ";
                        result += nonShouts.get(i);
                        if (i < nonShouts.size() - 1)
                            result += ", ";
                        else
                            result += ". ";
                    }
                }
            }
            if (!shouts.isEmpty())
            {
                for (String str : shouts)
                {
                    result += str + " ";
                }
            }
            return result;
        }
    }

}
