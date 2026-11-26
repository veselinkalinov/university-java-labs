package Study.Session_7;

public class StrBuilder_Study {
    public static void main(String args[]) {
        StringBuilder text = new StringBuilder("Programming");
        text.append(" Java");
        text.insert(0, "I love ");
        text.delete(7, 19);
        text.reverse();
        String text_string = text.toString();
        System.out.println(text_string);
        System.out.println(text_string.length());
    }

}
