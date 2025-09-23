package tutorial;

import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpCommandHandler implements BotCommandHandler {

    @Override
    public boolean canHandle(String command) {
        return command.equals("/help");
    }

    @Override
    public String handle(Update update) {
        return "Я тестовый бот \n\n" +
                "/start — рассказать о себе\n" +
                "/help — напомнить, как со мной взаимодействовать\n\n" +
                "Если напишешь любой текст, я отвечу: «Вы ввели: <текст>».";
    }
}
