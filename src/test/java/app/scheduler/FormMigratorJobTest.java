package app.scheduler;

import app.MigratorConfiguration;
import app.model.Audit;
import app.repository.Repository;
import app.service.AuditService;
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

public class FormMigratorJobTest {
    private AuditService auditService;
    private MigratorConfiguration configuration;
    private FormService formService;
    private HttpClient httpClient;
    private FormMigratorJob jobScheduler;

    @Before
    public void setup() {
        auditService = mock(AuditService.class);
        configuration = mock(MigratorConfiguration.class);
        formService = mock(FormService.class);
        httpClient = mock(HttpClient.class);

        jobScheduler = new FormMigratorJob(formService, auditService, configuration, httpClient);
    }

    @Test
    public void shouldReplaceTheLastTimestampFromTheLastAuditBeforePolling() throws URISyntaxException {
        Audit lastPolledAudit = new Audit(420L, 100L, 100L);
        String pollingUrl = "www.localhost.com/form?timestamp=0";

        when(auditService.getLastAudit()).thenReturn(lastPolledAudit);
        when(configuration.getPollingUrl()).thenReturn(pollingUrl);
        when(configuration.getPollingUrlUsername()).thenReturn("admin");
        when(configuration.getPollingUrlPassword()).thenReturn("password");
        when(formService.save(any())).thenReturn(newArrayList());

        jobScheduler.process();

        verify(httpClient).call(new URI("www.localhost.com/form?timestamp=420"), "admin", "password");
    }

    @Test
    public void shouldAddTheDefaultTimestampValueOfZeroWhenTheLastAuditIsNull() throws URISyntaxException {
        String pollingUrl = "www.localhost.com/form";

        when(auditService.getLastAudit()).thenReturn(null);
        when(configuration.getPollingUrl()).thenReturn(pollingUrl);
        when(configuration.getPollingUrlUsername()).thenReturn("admin");
        when(configuration.getPollingUrlPassword()).thenReturn("password");
        when(formService.save(any())).thenReturn(newArrayList());

        jobScheduler.process();

        verify(httpClient).call(new URI("www.localhost.com/form?timestamp=0"), "admin", "password");
    }

    @Test
    public void shouldCallAuditServiceAfterFormProcessing() {
        HashMap<String, Object> form1 = new HashMap<String, Object>() {{ put(SERVER_VERSION, "120"); }};
        HashMap<String, Object> form2 = new HashMap<String, Object>() {{ put(SERVER_VERSION, "420"); }};
        ArrayList<Map<String, Object>> allForms = newArrayList(form1, form2);
        ArrayList<Map<String, Object>> processForms = newArrayList(form2);

        when(configuration.getPollingUrl()).thenReturn("www.localhost.com/form");
        when(httpClient.call(any(), anyString(), anyString())).thenReturn(allForms);
        when(formService.save(any())).thenReturn(processForms);

        jobScheduler.process();

        verify(auditService).createAuditFor(processForms, allForms);
    }
}