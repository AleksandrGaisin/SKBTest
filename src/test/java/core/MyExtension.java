package core;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class MyExtension implements AfterTestExecutionCallback {
    @Override
    public void afterTestExecution(ExtensionContext executionContext) throws Exception {
        if (executionContext.getExecutionException().isPresent()) AllureAttachmentsManager.screenshot();
    }
}
