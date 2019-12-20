package reporting;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import org.xhtmlrenderer.pdf.ITextRenderer;

import beans.BinaryTrade;

import utils.ObjectHelper;

public class HTMLReportFormat {
	private String reportHeader, reportTestDate, reportStartTime, reportEndTime;

	private Integer testExecutedCount, passedCount, failedCount;

	public static ArrayList<ReportData> reportList = new ArrayList<ReportData>();

	private final StringBuilder htmlBuffer = new StringBuilder();
	
	NumberFormat formatter = new DecimalFormat("#0.00"); 

	public StringBuilder getHtmlBuffer() {
		return htmlBuffer;
	}

	public String getReportHeader() {
		return reportHeader;
	}

	public void setReportHeader(String reportHeader) {
		this.reportHeader = reportHeader;
	}

	public String getReportTestDate() {
		return reportTestDate;
	}

	public void setReportTestDate(String reportTestDate) {
		this.reportTestDate = reportTestDate;
	}

	public String getReportStartTime() {
		return reportStartTime;
	}

	public void setReportStartTime(String reportStartTime) {
		this.reportStartTime = reportStartTime;
	}

	public String getReportEndTime() {
		return reportEndTime;
	}

	public void setReportEndTime(String reportEndTime) {
		this.reportEndTime = reportEndTime;
	}

	public Integer getTestExecutedCount() {
		return testExecutedCount;
	}

	public void setTestExecutedCount(Integer testExecutedCount) {
		this.testExecutedCount = testExecutedCount;
	}

	public Integer getPassedCount() {
		return passedCount;
	}

	public void setPassedCount(Integer passedCount) {
		this.passedCount = passedCount;
	}

	public Integer getFailedCount() {
		return failedCount;
	}

	public void setFailedCount(Integer failedCount) {
		this.failedCount = failedCount;
	}

	public HTMLReportFormat() {
	}

	public HTMLReportFormat(String reportHeader) {
		setReportHeader(reportHeader);
	}

	public void addReportData(ReportData reportData) {
		reportList.add(reportData);
	}

	public static class ReportData extends BinaryTrade {
		byte[] vstsid, description, result, reason;

		public ReportData() {
		}

		public ReportData(String vstsid, String description, String result, String reason) {
			setVstsid(vstsid);
			setDescription(description);
			setResult(result);
			setReason(reason);
		}

		public String getVstsid() {
			try {
				return new String(vstsid);
			} catch (NullPointerException ne) {
				return "";
			}
		}

		public void setVstsid(String Vstsid) {
			if (Vstsid == null || Vstsid.length() == 0) {
				return;
			}
			this.vstsid = new byte[Vstsid.length()];
			string2Bytes(Vstsid, this.vstsid);
		}

		public String getDescription() {
			try {
				return new String(description);
			} catch (NullPointerException ne) {
				return "";
			}
		}

		public void setDescription(String Description) {
			if (Description == null || Description.length() == 0) {
				return;
			}
			this.description = new byte[Description.length()];
			string2Bytes(Description, this.description);
		}

		public String getResult() {
			try {
				return new String(result);
			} catch (NullPointerException ne) {
				return "";
			}
		}

		public void setResult(String Result) {
			if (Result == null || Result.length() == 0) {
				return;
			}
			this.result = new byte[Result.length()];
			string2Bytes(Result, this.result);
		}

		public String getReason() {
			try {
				return new String(reason);
			} catch (NullPointerException ne) {
				return "";
			}
		}

		public void setReason(String Reason) {
			if (Reason == null || Reason.length() == 0) {
				return;
			}
			this.reason = new byte[Reason.length()];
			string2Bytes(Reason, this.reason);
		}

	}

	private void appendHeader(){
		htmlBuffer.append("<head>");
		String inline = "<style type='text/css'>" + 
        "	@page { " +
     	"		size: 8.5in 11in;" +
     	"		margin: auto;" +
     	"    }" +
        "    body{" +
        "        font-family: 'Trebuchet MS', Arial, Helvetica, sans-serif;" +
       // "        padding: 0 0 0 0;"+
       // "        width: 100%;" +
        "    }" +

        "    #notify-table {" +
        "        border-collapse: collapse;" +
        "        width: 100%;" +
        "        text-align: center;" +
        "        font-weight: 700;" +
        "        font-size: 12px;" +
        "    }" +

        "    #data-table {" +
        "        border-collapse: collapse;" +
        "        width: 100%;" +
        "        text-align: center;" +
        "        font-size: 12px;" +
        "    }" +

        "    #notify-table td, #notify-table th, #data-table td, #data-table th {" +
        "        border: 1px solid #323d43;" +
        "        padding: 8px;" +               
        "    }" +
        
        "    #data-table td{ font-size: 11px; }" +
        
        "    #data-table tr:nth-child(odd){background-color: #d0dced;}" +

        "    #data-table tr:hover {background-color: #ddd;}" +

        "    #data-table th {" +
        "        padding-top: 5px;" +
        "        padding-bottom: 5px;" +
        "        background-color: #ffff00;" +
        "        color: red;" +
        "        line-height: 6px" +
        "    }" +

        "    .id-column{" +
        "        width: 8%;" +
        "    }" +

        "    .desc-column{" +
        "        width: 20%;" +
        "    }" +
        

        "    .result-column{" +
        "        width: 5%;" +
        "    }" +
        

        "    .reason-column{" +
        "        width: 10%;" +
        "    }" +
        
        "    #page-header {" +
        "        display: block;" +
        "        border: 3px solid black;" +
        "        color: red;" +
        "        padding: 2px;" +
        "        text-align: center;" +
        //"        width : 300px;"+
        "    }" +
            
        "    .default {" +
        "        background-color: #f9f7f7;" +
        "    }" +

        "    .warning {" +
        "        background-color: #ffc000;" +
        "    }" +

        "    .success {" +
        "        background-color: rgb(146, 208, 80);" +
        "    }" +

        "    .error {" +
        "        background-color: #FF0000;" +
        "    }" +
        
        "    td th {" +
        "        background-color: #FF0000;" +
        "    }" +       

        "    .container {" +
        "        border: 1px solid black;" +
        "        margin-top: 15px;" +
        "        margin-bottom: 15px;" +
        "        padding: 10px 20px;" +
      //  "        width: 400px"+
        "    }" +
		"</style>";
		htmlBuffer.append(inline);
		htmlBuffer.append("</head>");
	}

	// With HTML CHART
//	public void regenerateHTML() {
//		htmlBuffer.setLength(0);
//		htmlBuffer.append("<!DOCTYPE html><html lang='en-US'>");
//		appendHeader();
//		htmlBuffer.append("<body>");
//		htmlBuffer.append("<h4 id='page-header'>");
//		htmlBuffer.append(getReportHeader());
//		htmlBuffer.append("</h4>");
//
//		double degree1 = (Double.parseDouble(Integer.toString(ObjectHelper.totaltests - ObjectHelper.totalfailed)) * 3.6);
//		double degree2 = (Double.parseDouble(Integer.toString(ObjectHelper.totalfailed)) * 3.6);
//
//		String inline = "" + "<div id='contentBox'  class='clearfix' style='margin:0px auto; width:100%'>" + "	<div id='column1' style='float:left; margin:0; width:50%;'>" + "        <table id='notify-table'>"
//				+ "            <tr class='default'>" + "                <td>Test Date</td>" + "                <td>" + getReportTestDate() + "</td>" + "            </tr>" + "            <tr class='default'>"
//				+ "                <td>Start Time</td>" + "                <td>" + getReportStartTime() + "</td>" + "            </tr>" + "            <tr class='default'>" + "                <td>End Time</td>"
//				+ "                <td>" + getReportEndTime() + "</td>" + "            </tr>" + "            <tr class='warning'>" + "                <td>No. of Tests Executed</td>" + "                <td>"
//				+ getTestExecutedCount() + "</td>" + "            </tr>" + "            <tr class='success'>" + "                <td>Passed</td>" + "                <td>" + getPassedCount() + "</td>"
//				+ "            </tr>" + "            <tr class='error'>" + "                <td>Failed</td>" + "                <td>" + getFailedCount() + "</td>" + "            </tr>" + "        </table>" + "    </div>"
//				+ "    <div id='column2' style='float:right; margin:auto; width:40%;'> <div style=\"width: 100px; height: 100px; position: relative; border-radius: 100px; background-color: rgb(136, 143, 255);\">"
//				+ "    <div style=\"position: absolute; top: 0px; left: 0px; width: 100px; height: 100px; border-radius: 100px; clip: rect(0px, 100px, 100px, 0px); transform: rotate(0deg);\"> "
//				+ "    <div style=\"background-color: rgb(255, 0, 0); position: absolute; top: 0px; left: 0px; width: 100px; height: 100px; border-radius: 100px; clip: rect(0px, 50px, 100px, 0px); "
//				+ "    transform: rotate(180deg);\"></div></div><div style=\"position: absolute; top: 0px; left: 0px; width: 100px; height: 100px; border-radius: 100px; clip: rect(0px, 100px, 100px, 50px); "
//				+ "    transform: rotate(180deg);\"><div style=\"background-color: rgb(255, 0, 0); position: absolute; top: 0px; left: 0px; width: 100px; height: 100px; border-radius: 100px; clip: rect(0px, 50px, 100px, 0px); "
//				+ "    transform: rotate(36deg);\"></div></div><div style=\"position: absolute; top: 0px; left: 0px; width: 100px; height: 100px; border-radius: 100px; clip: rect(0px, 100px, 100px, 50px); transform: rotate(216deg);\">"
//				+ "    <div style=\"background-color: rgb(0, 198, 0); position: absolute; top: 0px; left: 0px; width: 100px; height: 100px; border-radius: 100px; clip: rect(0px, 50px, 100px, 0px); transform: rotate(144deg);\"></div></div></div>"
//				+ "    </div>" + "</div>" + "<table id='data-table'>" + "    <tr>" + "        <th class='id-column'>VSTS TC ID</th>" + "        <th>DESCRIPTION</th>" + "        <th>RESULT</th>"
//				+ "        <th>REASON</th>" + "    </tr>" + getReportDataTable() + "</table>		";
//		htmlBuffer.append(inline);
//		htmlBuffer.append("<body>");
//
//		htmlBuffer.append("<html>");
//	}
	
	public void regenerateHTML(){
		htmlBuffer.setLength(0);
		htmlBuffer.append("<!DOCTYPE html><html lang='en-US'>");
		appendHeader();
		htmlBuffer.append("<body><div class='container'>");
		htmlBuffer.append("<h4 id='page-header'>");
		htmlBuffer.append(getReportHeader());
		htmlBuffer.append("</h4>");
		
		int pass = (ObjectHelper.totaltests - ObjectHelper.totalfailed);
		int fail = ObjectHelper.totalfailed;
		
		double passper = Double.parseDouble(Integer.toString(ObjectHelper.totaltests - ObjectHelper.totalfailed)) / Double.parseDouble(Integer.toString(ObjectHelper.totaltests)) * 100 ;
		double failper = Double.parseDouble(Integer.toString(ObjectHelper.totalfailed)) / Double.parseDouble(Integer.toString(ObjectHelper.totaltests)) * 100 ;		
		
		String inline = "" +
		"<div id='contentBox'  class='clearfix' style='width:85%'>" +
     //   "	<div id='column1' style='float:left; margin:0; width:60%;'>" +
	    "        <table width='100%'>" +
	    "		  <tr>" +
	    "          <td>" +
	    "            <table id='notify-table'>" +
		    "            <tr class='default'>" +
		    "                <td>Test Date</td>" +
		    "                <td>"+ getReportTestDate() + "</td>" +
		    "            </tr>" +
		    "            <tr class='default'>" +
		    "                <td>Start Time</td>" +
		    "                <td>"+ getReportStartTime() + "</td>" +
		    "            </tr>" +
		    "            <tr class='default'>" +
		    "                <td>End Time</td>" +
		    "                <td>"+ getReportEndTime() + "</td>" +
		    "            </tr>" +
		    "            <tr class='warning'>" +
		    "                <td>No. of Tests Executed</td>" +
		    "                <td>"+ getTestExecutedCount() + "</td>" +
		    "            </tr>" +
		    "            <tr class='success'>" +
		    "                <td>Passed</td>" +
		    "                <td>"+ getPassedCount() + "</td>" +
		    "            </tr>" +
		    "            <tr class='error'>" +
		    "                <td>Failed</td>" +
		    "                <td>"+ getFailedCount() + "</td>" +
		    "            </tr>" +	   
	    "          </table>"+
	    "        </td>"+
	    "    <td>"+
	   // "      <div id='column2' style='float:left; margin:auto; width:15%;'>" +
	    "        <span style='margin: auto;float:right;'><img src='http://chart.apis.google.com/chart?cht=p&chs=360x200&chdl=Pass%7CFail&chl=Pass+"+formatter.format(passper)+"%25%7CFail+"+formatter.format(failper)+"%25&chco=16ad16|ef2917&chp=0.436326388889&chtt=Test+Result&chts=000000,24&chd=t:"+pass+","+fail+"' /></span>" +
	    "        <!-- <img src='cid:chart'>   -->" +
	  //  "     </div>" +
	    "   </td>"+
	    "  </tr>"+
	    " </table>" +	    
	 //   " </div>" +	    
	    "</div>" +
	    "<br/><table id='data-table'>" +
	    "    <tr>" +
	    "        <th class='id-column'>VSTS TC ID</th>" + 
	    "	     <th class='desc-column'>DESCRIPTION</th>"+ 
	    "	     <th class='result-column'>RESULT</th>" + 
	    "	     <th class='reason-column'>REASON</th>" +
	    "    </tr>" +
	    getReportDataTable() +    
	    "</table></div>";
		htmlBuffer.append(inline);
		htmlBuffer.append("</body>");

		htmlBuffer.append("</html>");
	
	}

	private String getReportDataTable() {	
		
		StringBuilder sBuilder = new StringBuilder();
		for (ReportData reportData : reportList) {
			sBuilder.append("   <tr>");
			sBuilder.append("        <td>").append(reportData.getVstsid()).append("</td>");
			sBuilder.append("        <td>").append(reportData.getDescription()).append("</td>");
			sBuilder.append("        <td>").append(reportData.getResult().toString()).append("</td>");
			sBuilder.append("        <td>").append(reportData.getReason()).append("</td>");
			sBuilder.append("   </tr>");
		}
		return sBuilder.toString();
	}

	public void generatePDF(String html) {
		try {
			//convert String to HTML file
//		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(new File(".","\\TestData\\emailablereport.htm").getAbsolutePath())));
//		writer.write(html);
//		writer.close();
		
		String htmlformatted = html.replaceAll("\"", "");
			
		FileWriter fwriter = new FileWriter(new File(new File(".","\\TestData\\emailablereport.htm").getAbsolutePath()));
		fwriter.write(htmlformatted);
		fwriter.close();
			
		OutputStream out = new FileOutputStream(new File(".","\\TestData\\emailablereport.pdf").getAbsolutePath());
		
		ITextRenderer renderer = new ITextRenderer();
		
        String url = new File(new File(".","\\TestData\\emailablereport.htm").getAbsolutePath()).toURI().toURL().toString();
        
		renderer.setDocument(url);
		renderer.layout();
		renderer.createPDF(out);
		
		out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
