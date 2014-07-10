package app.scheduler;

import app.MigratorConfiguration;
import app.model.Audit;
import app.repository.Repository;
import app.service.FormService;
import app.util.HttpClient;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static app.Constants.SERVER_VERSION;
import static com.google.common.collect.Lists.newArrayList;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class JobSchedulerTest {
    private Repository repository;
    private MigratorConfiguration configuration;
    private FormService formService;
    private HttpClient httpClient;
    private JobScheduler jobScheduler;

    @Before
    public void setup() {
        repository = mock(Repository.class);
        configuration = mock(MigratorConfiguration.class);
        formService = mock(FormService.class);
        httpClient = mock(HttpClient.class);

        jobScheduler = new JobScheduler(repository, formService, configuration, httpClient);
    }

    @Test
    public void shouldReplaceTheLastTimestampFromTheLastAuditBeforePolling() throws URISyntaxException {
        Audit lastPolledAudit = new Audit(420L, 100L);
        String pollingUrl = "www.localhost.com/form?timestamp=0";

        when(repository.getLastAudit()).thenReturn(lastPolledAudit);
        when(configuration.getPollingUrl()).thenReturn(pollingUrl);
        when(configuration.getPollingUrlUsername()).thenReturn("admin");
        when(configuration.getPollingUrlPassword()).thenReturn("password");
        when(formService.save(any())).thenReturn(newArrayList());

        jobScheduler.doJob();

        verify(httpClient).call(new URI("www.localhost.com/form?timestamp=420"), "admin", "password");
    }

    @Test
    public void shouldAddTheDefaultTimestampValueOfZeroWhenTheLastAuditIsNull() throws URISyntaxException {
        String pollingUrl = "www.localhost.com/form";

        when(repository.getLastAudit()).thenReturn(null);
        when(configuration.getPollingUrl()).thenReturn(pollingUrl);
        when(configuration.getPollingUrlUsername()).thenReturn("admin");
        when(configuration.getPollingUrlPassword()).thenReturn("password");
        when(formService.save(any())).thenReturn(newArrayList());

        jobScheduler.doJob();

        verify(httpClient).call(new URI("www.localhost.com/form?timestamp=0"), "admin", "password");
    }

    @Test
    public void shouldCreateAuditWithTheMaxVersionedForm() {
        HashMap<String, Object> form1 = new HashMap<String, Object>() {{ put(SERVER_VERSION, "120"); }};
        HashMap<String, Object> form2 = new HashMap<String, Object>() {{ put(SERVER_VERSION, "420"); }};
        HashMap<String, Object> form3 = new HashMap<String, Object>() {{ put(SERVER_VERSION, "220"); }};

        ArrayList<Map<String, Object>> processedForms = newArrayList(form1, form2, form3);

        when(configuration.getPollingUrl()).thenReturn("www.localhost.com/form");
        when(httpClient.call(any(), anyString(), anyString())).thenReturn(processedForms);
        when(formService.save(any())).thenReturn(processedForms);

        jobScheduler.doJob();

        verify(repository).create(new Audit(420L, 3L));
    }

    @Test
    public void shouldNotCreateAuditWhenTheFormsAreEmpty() {
        ArrayList<Map<String, Object>> processedForms = newArrayList();

        when(configuration.getPollingUrl()).thenReturn("www.localhost.com/form");
        when(httpClient.call(any(), anyString(), anyString())).thenReturn(processedForms);
        when(formService.save(any())).thenReturn(processedForms);

        jobScheduler.doJob();

        verify(repository, never()).create(any(Audit.class));
    }
}