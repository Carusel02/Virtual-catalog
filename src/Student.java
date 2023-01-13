public class Student extends User{

    private Parent mother;
    private Parent father;

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }
    public void setMother(Parent mother) { /* TODO */
        this.mother = mother;
    }
    public void setFather(Parent father) { /* TODO */
        this.father = father;
    }


    public Parent getMother() {
        return mother;
    }

    public Parent getFather() {
        return father;
    }
}
