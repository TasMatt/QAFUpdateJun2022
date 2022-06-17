package com.application.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Validator;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFValidationSteps extends WebDriverTestCase {

    @QAFTestStep(description = "Validate PDF File")
    public void validatePDF() throws IOException {

        String userProfile = System.getenv("USERPROFILE");
        String folderName = userProfile + "\\Downloads\\";

        File pdfFile = new File((folderName+"eStmt_2022-03-17.pdf"));
        PDDocument document = Loader.loadPDF(pdfFile);
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        pdfTextStripper.setStartPage(1);
        pdfTextStripper.setEndPage(1);
        String strPDF = pdfTextStripper.getText(document);

        System.out.println(strPDF);

        Validator.verifyTrue(strPDF.contains("1.800.432.1000"),
                "The PDF Does not contain text",
                "The PDF does contain Text");
    }

    @QAFTestStep(description = "Delete Files With Same Name")
    public void deleteFile()  {

        String userProfile = System.getenv("USERPROFILE");
        String folderName = userProfile + "\\Downloads\\";
        String fileNameToDelete = "Document_2152022_71916_PM_XyF5ofoA";

        File [] listFiles = new File(folderName).listFiles();

        for (int i = 0; i < listFiles.length; i++) {

            if (listFiles[i].isFile()) {

                String fileName = listFiles[i].getName();

                File file = new File(String.valueOf(listFiles[i].getAbsoluteFile()));

                if (fileName.startsWith(fileNameToDelete)) {

                    file.delete();
                }
            }

        }


    }

}
