package by.nure.jekacroul.web.command;

import by.nure.jekacroul.web.command.admin.*;
import by.nure.jekacroul.web.command.client.PersonalDataCommand;
import by.nure.jekacroul.web.command.admin.*;
import by.nure.jekacroul.web.command.client.AccountCommand;
import by.nure.jekacroul.web.command.common.LogoutCommand;
import by.nure.jekacroul.web.command.common.NoCommand;
import by.nure.jekacroul.web.command.common.PdfBuilderCommand;
import by.nure.jekacroul.web.command.outofcontrol.I18NCommand;
import by.nure.jekacroul.web.command.outofcontrol.LoginCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author @author Evgeny Norkin
 */
public class CommandFactory {
    private static CommandFactory factory = new CommandFactory();
    private static Map<String, ICommand> commands = new HashMap<>();

    private CommandFactory() {

    }

    public static CommandFactory commandFactory() {
        if (factory == null) {
            factory = new CommandFactory();
        }
        return factory;
    }

    static {
        // common commands
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("pdf_builder", new PdfBuilderCommand());
        commands.put("no_command", new NoCommand());
        commands.put("i18n", new I18NCommand());
        commands.put("redirect", null);

        // admin commands
        commands.put("main", new MainCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("edit_client", new EditClientICommand());
        commands.put("profile", new ProfileCommand());
        commands.put("add_tariff", new AddTariffCommand());
        commands.put("edit_tariff", new EditTariffCommand());
        commands.put("remove_tariff", new RemoveTariffCommand());

        // client commands
        commands.put("account", new AccountCommand());
        commands.put("personal_data", new PersonalDataCommand());
    }

    public ICommand getCommand(HttpServletRequest request) {
        String action = request.getParameter("action");
        return commands.get(action);
    }
}
