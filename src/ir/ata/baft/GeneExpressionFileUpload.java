package ir.ata.baft;

import ir.ata.baft.excel.ReadExcel;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@SuppressWarnings("serial")
public class GeneExpressionFileUpload extends HttpServlet {

	private final String UPLOAD_DIRECTORY = "/tmp/baft_files" ; // "graphs/";
	private File UPLOADED_FILE;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// process only if its multipart content
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(
						new DiskFileItemFactory()).parseRequest(request);

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String name = new File(item.getName()).getName();
						item.write(new File(UPLOAD_DIRECTORY + File.separator
								+ name));
						UPLOADED_FILE = new File(UPLOAD_DIRECTORY
								+ File.separator + name);
					}
				}

				// File uploaded successfully
				request.setAttribute("message", "File Uploaded Successfully");
				ReadExcel r_exel=new ReadExcel();
				r_exel.read(UPLOADED_FILE, FileType.weights);

			} catch (Exception ex) {
				request.setAttribute("message", "File Upload Failed due to "
						+ ex);
			}

		} else {
			request.setAttribute("message",
					"Sorry this Servlet only handles file upload request");
		}

	}
}