package PageObjectModel.NTTData.reporting;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import PageObjectModel.NTTData.context.PublicContext;

public class GetScreenshot {
	public String getScreenshotAs() {
		String dateTime = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		String DestinationPath=System.getProperty("user.dir")+"/Report/ScreenShots/abc_" + dateTime + ".png";
		File screenshotAs = ((TakesScreenshot) PublicContext.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotAs, new File(DestinationPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		PublicContext.test.log(Status.FATAL, MarkupHelper.createLabel("Screenshot capture", ExtentColor.GREEN));
		return DestinationPath;
	}
}
