package ir.ata.baft;

import ir.ata.baft.model.WeightDataDAO;
import ir.ata.baft.model.Weights;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DisplayDNAStrand extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Weights> myDataList = new WeightDataDAO().getWeightData();
		request.setAttribute("myDataList", myDataList);
		request.getRequestDispatcher("DNAStrand.jsp").forward(request,
				response);

	}
}
