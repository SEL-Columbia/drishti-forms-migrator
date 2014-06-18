package app.scheduler;

import app.Context;
import app.model.Person;
import app.model.Student;
import app.repository.Repository;
import de.spinscale.dropwizard.jobs.Job;
import de.spinscale.dropwizard.jobs.annotations.Every;

@Every("5s")
public class JobScheduler extends Job {
    private final Context context;

    public JobScheduler() {
        context = Context.getInstance();
    }

    @Override
    public void doJob() {
        System.out.println("************");
        System.out.println("Hello");

        Person person = new Person();
        person.setFullName("Harry");
        person.setJobTitle("Wizard");

        Student student = new Student();
        student.setFullName("Ron");
        student.setCourse("Herbology");

        try {
            Repository repository = context.repository();

            repository.create(person);
            repository.create(student);

        } catch (ClassNotFoundException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
