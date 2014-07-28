package app;

import de.spinscale.dropwizard.jobs.config.JobConfiguration;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class MigratorConfiguration extends Configuration {
    @Valid
    @NotNull
    @JsonProperty
    private String pollingUrl = "invalid";

    @Valid
    @NotNull
    @JsonProperty
    private String pollingUrlUsername = "";

    @Valid
    @NotNull
    @JsonProperty
    private String pollingUrlPassword = "";

    @Valid
    @NotNull
    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();

    @Valid
    @NotNull
    @JsonProperty
    private JobConfiguration jobs = new JobConfiguration();

    public DataSourceFactory getDatabase() {
        return database;
    }

    public String getPollingUrl() {
        return pollingUrl;
    }

    public String getPollingUrlPassword() {
        return pollingUrlPassword;
    }

    public String getPollingUrlUsername() {
        return pollingUrlUsername;
    }

    public JobConfiguration getJobs() {
        return jobs;
    }
}
