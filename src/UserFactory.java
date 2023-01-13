public class UserFactory {
    public static User factory (String userName) {
        if (userName.equals("Student"))
            return new Student("Diana", "Stefan");
        if (userName.equals("Parent"))
            return new Parent("Diana", "Stefan");
        if (userName.equals("Assistant"))
            return new Assistant("Diana", "Stefan");
        if (userName.equals("Teacher"))
            return new Teacher("Diana", "Stefan");
        return null;
    }
}
