package tutorial;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

//Основной класс телеграмм бота, наследуется от TelegramLongPollingBot
public class MyBot extends TelegramLongPollingBot {

    private final BotConfig config;
    private final List<BotCommandHandler> handlers = new ArrayList<>();

    public MyBot(BotConfig config) {
        this.config = config;
        handlers.add(new StartCommandHandler());
        handlers.add(new HelpCommandHandler());
    }

    @Override
    public String getBotUsername() {
        return config.getBotUsername();
    }

    @Override
    public String getBotToken() {
        return config.getBotToken();
    }

    //Метод, вызывающийся, когда бот получает сообщение
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String text = update.getMessage().getText();

            String response = null;

            for (BotCommandHandler handler : handlers) {
                if (handler.canHandle(text)) {
                    response = handler.handle(update);
                    break;
                }
            }

            if (response == null) {
                response = "Вы ввели: \"" + text + "\"";
            }

            SendMessage message = new SendMessage(chatId, response);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
