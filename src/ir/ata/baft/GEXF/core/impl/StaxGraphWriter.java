package ir.ata.baft.GEXF.core.impl;

import com.ctc.wstx.stax.WstxOutputFactory;

import ir.ata.baft.GEXF.core.Gexf;
import ir.ata.baft.GEXF.core.GexfWriter;
import ir.ata.baft.GEXF.core.impl.writer.GexfEntityWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * StaxGraphWriter class is an implementation of the GexfWriter interface.
 *
 */
public class StaxGraphWriter implements GexfWriter {

    @Override
    public void writeToStream(Gexf gexf, Writer out, String encoding) throws IOException {
        try {
            XMLOutputFactory outputFactory1 = WstxOutputFactory.newInstance();
            XMLStreamWriter streamWriter = outputFactory1.createXMLStreamWriter(out);
            streamWriter.writeStartDocument(encoding, "1.0");

            new GexfEntityWriter(streamWriter, gexf);

            streamWriter.writeEndDocument();

            streamWriter.flush();
            streamWriter.close();

        } catch (XMLStreamException e) {
            throw new IOException("XML Exception: " + e.getMessage(), e);
        }
    }
    
    @Override
    public void writeToStream(Gexf gexf, OutputStream out, String encoding) throws IOException {
        writeToStream(gexf, new OutputStreamWriter(out, encoding), encoding);
    }
}