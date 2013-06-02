package Technique;

import com.cete.dynamicpdf.*;
import com.cete.dynamicpdf.pageelements.FormattedTextArea;
import com.cete.dynamicpdf.pageelements.FormattedTextAreaStyle;
import com.cete.dynamicpdf.pageelements.Label;
import com.cete.dynamicpdf.pageelements.PageNumberingLabel;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;


public class SavePDF
{
    private static Template template = new Template();
    
    public SavePDF(String title, String textToSave, String filename)
    {
        PageNumberingLabel objPageNumLabel = new PageNumberingLabel("Page " +
                                                 "%%CP%% of %%TP%%", 0, 494, 
                                                 684, 10, Font.getHelvetica(), 
                                                 10, TextAlign.CENTER);
        
        template.getElements().add(objPageNumLabel);
        
        
        Document objDocument = new Document();
        objDocument.setCreator("SavePDF.java");
        objDocument.setAuthor("Karhabti");
        objDocument.setTitle(title);
        objDocument.setTemplate(template);
        
        FormattedTextAreaStyle objStyle = new FormattedTextAreaStyle(FontFamily
                                             .getHelvetica(), 10, false);
	objStyle.paragraph.indent = 36;
	objStyle.paragraph.spacingAfter = 6;
	objStyle.paragraph.allowOrphanLines = false;
        
        Page objPage = new Page(PageSize.LETTER, PageOrientation.PORTRAIT,54.0f);
        
        //Label objLabel = new Label(textToSave, 0, 0, 504, 100, Font.getHelvetica(),18, TextAlign.CENTER);-
        
        FormattedTextArea objHtmlTextArea = new FormattedTextArea(textToSave, 0, 60,
                                                      315, 424, objStyle);
        
        while (objHtmlTextArea != null)	{
	    objHtmlTextArea = this.addTextToDocument(objDocument, 
                                                               objHtmlTextArea);
	}
        
        objDocument.draw("C:\\Users\\Fourat\\Documents\\Karhabti\\"+filename+".pdf");
        
    }
    
    private FormattedTextArea addTextToDocument(Document document, 
                                           FormattedTextArea htmlTextArea) {
	// Create a new page
	Page objPage = new Page(PageSize.LETTER, PageOrientation.LANDSCAPE, 
                              54.0f);
	// Add left column FormattedTextArea to page
	objPage.getElements().add(htmlTextArea);
	// Create the right column FormattedTextArea
	htmlTextArea = htmlTextArea.getOverflowFormattedTextArea(369, 60);
	// Add it to the page if it had overflow text
	if (htmlTextArea != null) {
	    objPage.getElements().add(htmlTextArea);
	}
			
	// Add page to document
	document.getPages().add(objPage);

	// Return the next FormattedTextArea if there is overflow text
	if (htmlTextArea == null) {
	    return null;
	} else	{
	    return htmlTextArea.getOverflowFormattedTextArea(0, 60);
	}
    }
}