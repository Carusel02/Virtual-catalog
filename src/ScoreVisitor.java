import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class ScoreVisitor implements Visitor{

    private HashMap<Teacher, ArrayList<Tuple<Student, String, Double>>> teacherTupleHashMap;
    private HashMap<Assistant, ArrayList<Tuple<Student, String, Double>>> assistantTupleHashMap;

    private ArrayList<Tuple<Student, String, Double>> teacherArray;
    private ArrayList<Tuple<Student, String, Double>> assistantArray;
    public ArrayList<Tuple<Student, String, Double>> getTeacherArray() {
        return teacherArray;
    }

    public ArrayList<Tuple<Student, String, Double>> getAssistantArray() {
        return assistantArray;
    }
    public void createArrayTeacher(ArrayList<Grade> grades) {
        // creare array teacher
        teacherArray = new ArrayList<>();

        // adaugare
        for(Grade nota : grades) {
            teacherArray.add(new Tuple<Student, String, Double>(nota.getStudent(), nota.getCourse(), nota.getExamScore()));
        }
    }

    public void createArrayAssistent(ArrayList<Grade> grades) {
        // creare array assistent
        assistantArray = new ArrayList<>();

        // adaugare
        for(Grade nota : grades) {
            assistantArray.add(new Tuple<Student, String, Double>(nota.getStudent(), nota.getCourse(), nota.getPartialScore()));
        }
    }

    @Override
    public void visit(Assistant assistant) {

        if(assistantTupleHashMap == null)
            assistantTupleHashMap = new HashMap<>();

        assistantTupleHashMap.put(assistant, getAssistantArray());



        // pentru fiecare curs
        for(Course curs : Catalog.getInstance().cursuri) {
            // am gasit asistentul
            for(Assistant asistent : curs.getAssistants()) {
                if(asistent.toString().equals(assistant.toString())) {
                    // pentru fiecare nota
                    for(Tuple<Student, String, Double> tuple : assistantTupleHashMap.get(assistant)) {
                        // suntem la cursul bun
                        if(curs.getName().equals(tuple.nameCurs)) {
                            // preluare array note
                            ArrayList<Grade> note = curs.getGrade();
                            int flag = 0;

                            // creare nota
                            Grade adaugareNota = new Grade();
                            adaugareNota.setStudent(tuple.student);
                            adaugareNota.setCourse(tuple.nameCurs);
                            adaugareNota.setExamScore(tuple.nota);

                            if(note.size() == 0) {
                                curs.addGrade(adaugareNota);
                                continue;
                            }

                            for(Grade nota : note) {
                                // am gasit nota
                                if(nota.getStudent().equals(tuple.student)) {
                                    nota.setPartialScore(tuple.nota);
                                    flag = 1;
                                    break;
                                }



                            }

                            if(flag == 0)
                                curs.addGrade(adaugareNota);

                        }

                    }


                }
            }
        }

    }

    @Override
    public void visit(Teacher teacher) {

        if(teacherTupleHashMap == null)
            teacherTupleHashMap = new HashMap<>();

        teacherTupleHashMap.put(teacher, getTeacherArray());

        // pentru fiecare curs
        for(Course curs : Catalog.getInstance().cursuri) {
            // cursul sa fie al profului
            if(curs.getTeacher().toString().equals(teacher.toString())) {
                // pentru fiecare tuple DE BAGAT
                for(Tuple<Student, String, Double> tuple : teacherTupleHashMap.get(teacher)) {
                    // e cursul bun

                    if(curs.getName().equals(tuple.nameCurs)) {
                        ArrayList<Grade> note = curs.getGrade();

                        int flag = 0;

                        // creare nota
                        Grade adaugareNota = new Grade();
                        adaugareNota.setStudent(tuple.student);
                        adaugareNota.setCourse(tuple.nameCurs);
                        adaugareNota.setExamScore(tuple.nota);

                        if(note.size() == 0) {
                            curs.addGrade(adaugareNota);
                            continue;
                        }

                        for(Grade nota : note) {
                            // am gasit nota
                            if(nota.getStudent().equals(tuple.student)) {
                                nota.setExamScore(tuple.nota);
                                flag = 1;
                                break;
                            }


                        }

                        if(flag == 0)
                            curs.addGrade(adaugareNota);

                    }


                }


            }
        }
    }

    private static class Tuple<A,B,C> {
        A student;
        B nameCurs;
        C nota;

        Tuple(A student, B nameCurs, C nota) {
            this.student = student;
            this.nameCurs = nameCurs;
            this.nota = nota;
        }
    }
}
