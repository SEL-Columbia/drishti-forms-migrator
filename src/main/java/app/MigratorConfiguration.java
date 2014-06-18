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
    private String defaultName = "Stranger";

    @Valid
    @NotNull
    @JsonProperty
    private DatabaseConfiguration database = new DatabaseConfiguration();

    public String getDefaultName() {
        return defaultName;
    }

    public DatabaseConfiguration getDatabase() {
        return database;
    }
}
