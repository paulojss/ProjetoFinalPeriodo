package br.com.hotel.bll.pattern.hotel;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.hotel.dal.HotelDAO;
import br.com.hotel.model.EHotel;

public class ListarMatriz implements InterfaceStrategyHotel{
	private static final String DISPATCHER = "listarMatrizHotel.jsp";
	HotelDAO hdao = new HotelDAO();
	EHotel hotel = new EHotel();
	public ListarMatriz() {
	}

	@Override
	public void acaoStrategy(HttpServletRequest request, HttpServletResponse response) {
		Iterator<EHotel> listHotelFilial = hdao.listarHotelMatriz();
		request.setAttribute("listHotel", listHotelFilial);
		RequestDispatcher rd = request.getRequestDispatcher(DISPATCHER);
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
