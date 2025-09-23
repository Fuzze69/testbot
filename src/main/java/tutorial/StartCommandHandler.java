package tutorial;

import org.telegram.telegrambots.meta.api.objects.Update;

//Обработчик команды /start
public class StartCommandHandler implements BotCommandHandler {

    @Override
    public boolean canHandle(String command) {
        return command.equals("/start");
    }

    @Override
    public String handle(Update update) {
        return "Привет! Я тестовый бот.\n\n" +
                "Я повторяю ваши сообщения и комментирую их в формате: «Вы ввели: <текст>».\n\n" +
                "Чтобы напомнить, что я умею, введите /help.";
    }
}
