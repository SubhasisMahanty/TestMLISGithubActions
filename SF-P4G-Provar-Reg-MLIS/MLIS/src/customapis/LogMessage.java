package customapis;


import java.util.logging.Logger;

import org.testng.asserts.SoftAssert;

import com.provar.core.model.base.api.ValueScope;
import com.provar.core.testapi.ITestExecutionContext;
import com.provar.core.testapi.annotations.*;

@TestApi( title="LogMessage"
        , summary="Log "
        , remarks=""
        , iconBase=""
        , defaultApiGroups={"Custom"}
        )
@TestApiParameterGroups(parameterGroups={
	    @TestApiParameterGroup(groupName="inputs", title="Inputs"),
	    @TestApiParameterGroup(groupName="result", title="Result"),
	    })
public class LogMessage {
    
    @TestApiParameter(seq=1, 
            summary="The first parameter's summary.",
            remarks="",
            mandatory=true,
            parameterGroup="inputs")
    public String param1;
    
    @TestApiParameter(seq=2, 
            summary="The second parameter's summary.",
            remarks="",
            mandatory=true,
            parameterGroup="inputs")
    public boolean param2;

//    @TestApiParameter(seq=10, 
//            summary="The name that the result will be stored under.",
//            remarks="",
//            mandatory=true,
//            parameterGroup="result")
//    public String resultName;

    @TestApiParameter(seq=11, 
            summary="The lifespan of the result.",
            remarks="",
            mandatory=true,
            parameterGroup="result",
            defaultValue="Test")
    public ValueScope resultScope;

    /** 
     * Used to write to the test execution log.
     */
    @TestLogger
    public Logger testLogger;
    
    /** 
     * Provides access to facilities, mainly to set and get variable values.
     */
    @TestExecutionContext
    public ITestExecutionContext testExecutionContext;
    
    @TestApiExecutor
    public void execute() {

    	// Put our implementation logic here.
    	testLogger.info("Hello from " + this.getClass().getName());
    	testLogger.info("Message Logged as :: "+param1);
    	
    	String msg = param1;
    	testLogger.info("Message Logged as :: "+ msg);
//    	testExecutionContext.setValue(Quote, qName, resultScope);

        // Store the result (if appropriate).
//    	 String dummyResult = this.getClass().getName() + " result";
//        testExecutionContext.setValue(resultName, dummyResult, resultScope);
        

        
    }
    
}
