package app.model;

import app.Constants;
import com.google.common.base.Strings;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

import static app.Constants.*;
import static com.google.common.base.Strings.*;
import static junit.framework.Assert.*;

public class ErrorAuditTest {
    @Test
    public void shouldSetDetailedMessageOfAllowedLengthOf255() {
        ErrorAudit errorAudit = new ErrorAudit("123", "failed reason", repeat("a", 300));

        assertEquals(repeat("a", MAX_MSG_LENGTH), errorAudit.getDetailedReason());
        assertEquals(MAX_MSG_LENGTH, errorAudit.getDetailedReason().length());
    }

    @Test
    public void shouldSetDetailedMessageOfValidLength() {
        ErrorAudit errorAudit = new ErrorAudit("123", "failed reason", "valid message");

        assertEquals("valid message", errorAudit.getDetailedReason());
    }
}