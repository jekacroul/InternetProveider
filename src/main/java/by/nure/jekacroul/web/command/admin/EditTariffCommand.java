package by.nure.jekacroul.web.command.admin;

import by.nure.jekacroul.Path;
import by.nure.jekacroul.db.entity.Tariff;
import by.nure.jekacroul.db.services.ITariffService;
import by.nure.jekacroul.db.services.TariffServiceImpl;
import by.nure.jekacroul.web.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author @author Evgeny Norkin
 */
public class EditTariffCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("tariff_id"));
        String name = request.getParameter("name").trim();
        double price = Double.parseDouble(request.getParameter("price").trim());
        String description = request.getParameter("description").trim();

        String resp = Path.COMMAND_MAIN;

        ITariffService service = new TariffServiceImpl();
        Tariff tariff = new Tariff();
        tariff.setId(id);
        tariff.setName(name);
        tariff.setPrice(price);
        tariff.setDescription(description);

        service.update(tariff);
        try {
            response.sendRedirect(resp);
            resp = Path.COMMAND_REDIRECT;
        } catch (IOException e) {
            resp = Path.PAGE_ERROR_PAGE;
        }
        return resp;
    }
}
