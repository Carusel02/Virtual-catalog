# Electronic-calculator

## Implementation

The main classes worth mentioning are:

* `Catalog` , in which the courses are stored, being built using the Singleton design template in which a single object of this type is instantiated
* `Course` , the core of the project, which contains all the necessary information about the details related to the course
* `User` , which defines the construction mode of all users (Student, Parent, Teacher, Assistant)

The main template (sabloane) worth mentioning are:

* `Observer` , which allows sending a Notification (encoding a student's grade) and stores it in a notification vector of the student's parents (if the parent is in the observer vector)
* `Visitor` , which allows the assistant or teacher to validate grades from 2 dictionaries in the corresponding courses


Graphic interface:

* For the `student page` , insert the student's name in a text area, then press the search button, subsequently displaying buttons with each course; upon pressing such a button, details related to the student's situation in that course are provided
* For the `parent page` , insert the parent's name in a text area, and if he is in the observers vector, a button will appear which, once pressed, will display a window with the details of all the notifications received in chronological order
* For the `teacher/assistant page` , write the name in the text area; if there are, 2 buttons will be displayed; one displays the details of each student from each course and another that validates the grades from the dictionary specific to the teacher/assistant

IDE & Testing

* Intellij IDEA
* Testing was customized for each page depending on the classes
