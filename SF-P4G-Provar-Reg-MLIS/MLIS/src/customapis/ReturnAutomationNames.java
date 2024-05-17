package customapis;


import java.util.logging.Logger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.provar.core.model.base.api.ValueScope;
import com.provar.core.testapi.ITestExecutionContext;
import com.provar.core.testapi.annotations.*;

@TestApi( title="Return Automation Names"
        , summary=""
        , remarks=""
        , iconBase=""
        , defaultApiGroups={"Custom"}
        )
@TestApiParameterGroups(parameterGroups={
	    @TestApiParameterGroup(groupName="inputs", title="Inputs"),
	    @TestApiParameterGroup(groupName="result", title="Result"),
	    })
public class ReturnAutomationNames {
    
    @TestApiParameter(seq=1, 
            summary="The first parameter's summary.",
            remarks="",
            mandatory=true,
            parameterGroup="inputs")
    public String TestCaseID;

    @TestApiParameter(seq=10, 
            summary="The name that the result will be stored under.",
            remarks="",
            mandatory=true,
            parameterGroup="result")
    public String Quote;
    
    @TestApiParameter(seq=10, 
            summary="The name that the result will be stored under.",
            remarks="",
            mandatory=false,
            parameterGroup="result")
    public String Submission;
    
    @TestApiParameter(seq=10, 
            summary="The Epoch Value",
            remarks="",
            mandatory=true,
            parameterGroup="result")
    public String epochString;
    
    
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

    	
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	Date date = new Date();
    	testLogger.info("Print from ReturnAutomationNames : " + dateFormat.format(date));
    	String timeStamp = dateFormat.format(date);
    	
    	//Epoch
    	long epochMilSec = new Date().getTime() / 1000;
    	String epochSec = Long.toString(epochMilSec);
    	
//    	String cName = "Auto_Case_"+value;
//    	String sName = "Auto_Sub_"+value;
//    	String qName = "Auto_Quote_"+value;
//    	String cName = "DTT-E2E-MLIS-"+TestCaseID+"-CSE-"+timeStamp;
    	String qName = "DTT-E2E-MLIS-"+TestCaseID+"-QTE-"+timeStamp;
    	String sName = "DTT-E2E-MLIS-"+TestCaseID+"-SUB-"+timeStamp;
    	
    	
//    	testExecutionContext.setValue(Case, cName, resultScope);
    	testExecutionContext.setValue(Quote, qName, resultScope);
    	testExecutionContext.setValue(Submission, sName, resultScope);
//    	testExecutionContext.setValue(Quote, qName, resultScope);
    	
    	
    	// Fetch String and find length then split into Half of string 20  . 10 c 

    	//adding epoch time
    	
    	testExecutionContext.setValue(epochString, epochSec, resultScope);
    }
   
}
