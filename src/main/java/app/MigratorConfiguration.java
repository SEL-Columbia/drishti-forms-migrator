package app;

import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class MigratorConfiguration extends Configuration{
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
    private DatabaseConfiguration database = new DatabaseConfiguration();

    public DatabaseConfiguration getDatabase() {
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
}
