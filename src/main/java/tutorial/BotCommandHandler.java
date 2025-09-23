package tutorial;

import org.telegram.telegrambots.meta.api.objects.Update;

//Интерфейс для обработчиков команд
public interface BotCommandHandler {
    boolean canHandle(String command);
    String handle(Update update);
}
