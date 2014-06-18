package app.scheduler;

import app.Context;
import app.model.Person;
import app.repository.PersonRepository;
import de.spinscale.dropwizard.jobs.Job;
import de.spinscale.dropwizard.jobs.annotations.Every;

@Every("5s")
public class JobScheduler extends Job {
    private final Context context;
    private PersonRepository personRepository;

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
        try {
            context.repository().create(person);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
