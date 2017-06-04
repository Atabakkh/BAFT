package ir.ata.baft.createGEXF;

import java.io.IOException;

import org.xml.sax.SAXException;

public class testGEXF {
	
	public void callTestFunction() throws IOException, SAXException {
		
		CreateGEXF cg=new CreateGEXF();
		cg.testDynamicGexfGraph();
		
	}

}
