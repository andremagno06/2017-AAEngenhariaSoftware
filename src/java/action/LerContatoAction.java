/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;
import persistence.ContatoDAO;

/**
 *
 * @author ice
 */
public class LerContatoAction implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String codigo = request.getParameter("codigo");

        if (codigo.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                int codInt = Integer.parseInt(codigo);
                Contato c = ContatoDAO.getInstance().ler(codInt);

                request.setAttribute("codigo", c.getCodigo());
                request.setAttribute("nome", c.getNome());
                request.setAttribute("email", c.getEmail());

                RequestDispatcher view = request.getRequestDispatcher("ContatoLer.jsp");
                view.forward(request, response);

            } catch (ServletException ex) {
                Logger.getLogger(LerContatoAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LerContatoAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LerContatoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
